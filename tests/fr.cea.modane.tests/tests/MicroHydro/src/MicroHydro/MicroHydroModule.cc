#include <arcane/IParallelMng.h>
#include <arcane/ITimeLoopMng.h>
#include "MicroHydro/Eos/__IEquationOfState.h"
#include "MicroHydro/__IBoundaryCondition.h"
#include "MicroHydro/__ILoopDelegation.h"
#include "MicroHydro/MicroHydroModule.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace MicroHydroEos;
namespace MicroHydro {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

MicroHydroModule::MicroHydroModule(const ModuleBuildInfo & mbi)
: MicroHydroModuleBase<MicroHydroModule>(mbi)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

MicroHydroModule::~MicroHydroModule()
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*
 * Méthodes appelées par hydroStartInit :
 *   - EquationOfState::initEOS
 */
void MicroHydroModule::
hydroStartInit(MicroHydroHydroStartInitVars& vars)
{
	// Dimensionne les variables tableaux
	vars.m_cell_cqs.resize(8);

	// Initialise le delta-t
	Real deltat_init = options()->deltatInit();
	m_global_deltat = deltat_init;

	// Initialise les données géométriques: volume, cqs, longueurs caractéristiques
	MicroHydroComputeGeometricValuesVars geometric_vars(vars.m_cell_volume, vars.m_old_cell_volume);
	computeGeometricValues(geometric_vars);

	// Initialisation de la masses des mailles et des masses nodale
	ENUMERATE_CELL(icell, allCells()) {
		const Cell & cell = * icell;
		vars.m_cell_mass[icell] = vars.m_density[icell] * vars.m_cell_volume[icell];

		Real contrib_node_mass = 0.125 * vars.m_cell_mass[cell];
		for( NodeEnumerator inode(cell.nodes()); inode.hasNext(); ++inode){
			vars.m_node_mass[inode] += contrib_node_mass;
		}
	}

	vars.m_node_mass.synchronize();

	// Initialise l'énergie et la vitesse du son
	options()->eosModel()->initEOS(allCells().view());
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void MicroHydroModule::
hydroContinueInit(MicroHydroHydroContinueInitVars& vars)
{
	ENUMERATE_CELL(icell, allCells()){
		const Cell & cell = * icell;

		// Calcule le volume de la maille
		Real volume = 0.;
		for (Integer inode = 0; inode < 8; ++inode)
			volume += math::scaMul(vars.m_node_coord[cell.node(inode)], vars.m_cell_cqs[icell] [inode]);
		volume /= 3.;

		vars.m_cell_volume[icell] = volume;
	}
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void MicroHydroModule::
computePressureForce(MicroHydroComputePressureForceVars& vars)
{
	// Remise à zéro du vecteur des forces.
	vars.m_force.fill(Real3::null());

	// Calcul pour chaque noeud de chaque maille la contribution
	// des forces de pression
	options()->loopDelegation()->computePressureForce(allCells().view());
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void MicroHydroModule::
computeVelocity(MicroHydroComputeVelocityVars& vars)
{
	// Calcule l'impulsion aux noeuds
	options()->loopDelegation()->computeNodeImpulsion(ownNodes().view());

	vars.m_velocity.synchronize();
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void MicroHydroModule::
applyBoundaryCondition(MicroHydroApplyBoundaryConditionVars& vars)
{
	ILoopDelegation* ld = options()->loopDelegation();
	for (Integer i = 0, nb = options()->boundaryCondition.size(); i < nb; ++i){
		FaceGroup face_group = options()->boundaryCondition[i]->surface();
		Real value = options()->boundaryCondition[i]->value();
		BoundaryConditionType type = options()->boundaryCondition[i]->type();

		// boucle sur les faces de la surface
		ld->applyBoundaryCondition(face_group.view(), value, type);
	}
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void MicroHydroModule::
moveNodes(MicroHydroMoveNodesVars& vars)
{
	options()->loopDelegation()->moveNodes(allNodes().view());
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void MicroHydroModule::
computeGeometricValues(MicroHydroComputeGeometricValuesVars& vars)
{
	vars.m_old_cell_volume.copy(vars.m_cell_volume);
	options()->loopDelegation()->computeGeometricValues(allCells().view());
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void MicroHydroModule::
updateDensity(MicroHydroUpdateDensityVars& vars)
{
	options()->loopDelegation()->updateDensity(ownCells().view());
	vars.m_density.synchronize();
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*
 * Méthodes appelées par applyEquationOfState :
 *   - EquationOfState::applyEOS
 */
void MicroHydroModule::
applyEquationOfState(MicroHydroApplyEquationOfStateVars& vars)
{
	// Calcul de l'énergie interne
	options()->loopDelegation()->computeInternalEnergy(allCells().view());
	// Calcul de la pression et de la vitesse du son
	options()->eosModel()->applyEOS(allCells().view());
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void MicroHydroModule::
computeDeltaT(MicroHydroComputeDeltaTVars& vars)
{
	// const Real old_dt = m_global_deltat();

	// Calcul du pas de temps pour le respect du critère de CFL

	Real minimum_aux = FloatInfo < Real >::maxValue();
	Real new_dt = FloatInfo < Real >::maxValue();

	ENUMERATE_CELL(icell, ownCells()){
		Real cell_dx = vars.m_caracteristic_length[icell];
		// Real density = vars.m_density[icell];
		// Real pressure = vars.m_pressure[icell];
		Real sound_speed = vars.m_sound_speed[icell];
		Real dx_sound = cell_dx / sound_speed;
		minimum_aux = math::min(minimum_aux, dx_sound);
	}

	new_dt = options()->cfl() * minimum_aux;

	new_dt = parallelMng()->reduce(Parallel::ReduceMin, new_dt);

	// Real density_ratio_dt = new_dt;

	// respect des valeurs min et max imposées par le fichier de données .plt
	new_dt = math::min(new_dt, options()->deltatMax());
	new_dt = math::max(new_dt, options()->deltatMin());

	// Real data_min_max_dt = new_dt;

	// Le dernier calcul se fait exactement au temps stopTime()
	Real stop_time  = options()->finalTime();
	bool not_yet_finish = (m_global_time() < stop_time);
	bool too_much = ((m_global_time()+new_dt) > stop_time);

	if ( not_yet_finish && too_much ){
		new_dt = stop_time - m_global_time();
		subDomain()->timeLoopMng()->stopComputeLoop(true);
	}

	// Mise à jour du pas de temps
	m_global_deltat = new_dt;
}


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ARCANE_REGISTER_MODULE_MICROHYDRO(MicroHydroModule);

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace MicroHydro
