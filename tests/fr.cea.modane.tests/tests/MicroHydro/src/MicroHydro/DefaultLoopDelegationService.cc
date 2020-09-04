#include "MicroHydro/DefaultLoopDelegationService.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace MicroHydro {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

DefaultLoopDelegationService::
DefaultLoopDelegationService(const ServiceBuildInfo & sbi)
: DefaultLoopDelegationServiceBase<DefaultLoopDelegationService>(sbi)
  {
  }

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

DefaultLoopDelegationService::
~DefaultLoopDelegationService()
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void DefaultLoopDelegationService::
computeNodeImpulsion(const Node node, DefaultLoopDelegationComputeNodeImpulsionVars& vars)
{
	Real node_mass = vars.m_node_mass[node];

	Real3 old_velocity = vars.m_velocity[node];
	Real3 new_velocity = old_velocity + (m_global_deltat() / node_mass) * vars.m_force[node];

	vars.m_velocity[node] = new_velocity;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void DefaultLoopDelegationService::
applyBoundaryCondition(const Face face, DefaultLoopDelegationApplyBoundaryConditionVars& vars, const Real boundary_condition_value, const BoundaryConditionType boundary_condition_type)
{
	Integer nb_node = face.nbNode();

	// boucle sur les noeuds de la face
	for (Integer k = 0; k < nb_node; ++k){
		const Node & node = face.node(k);
		Real3 & velocity = vars.m_velocity[node];

		switch (boundary_condition_type){
		case BoundaryConditionType::Vx:
			velocity.x = boundary_condition_value;
			break;
		case BoundaryConditionType::Vy:
			velocity.y = boundary_condition_value;
			break;
		case BoundaryConditionType::Vz:
			velocity.z = boundary_condition_value;
			break;
		}
	}
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void DefaultLoopDelegationService::
moveNodes(const Node node, DefaultLoopDelegationMoveNodesVars& vars)
{
	Real deltat = m_global_deltat();
	vars.m_node_coord[node] += deltat * vars.m_velocity[node];
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void DefaultLoopDelegationService::
computeGeometricValues(const Cell cell, DefaultLoopDelegationComputeGeometricValuesVars& vars)
{
	// Copie locale des coordonnées des sommets d'une maille
	Real3 coord[8];
	// Coordonnées des centres des faces
	Real3 face_coord[6];

	// Recopie les coordonnées locales (pour le cache)
	for (NodeEnumerator inode(cell.nodes()); inode.index() < 8; ++inode)
		coord[inode.index()] = vars.m_node_coord[inode];

	// Calcul les coordonnées des centres des faces
	face_coord[0] = 0.25 * (coord[0] + coord[3] + coord[2] + coord[1]);
	face_coord[1] = 0.25 * (coord[0] + coord[4] + coord[7] + coord[3]);
	face_coord[2] = 0.25 * (coord[0] + coord[1] + coord[5] + coord[4]);
	face_coord[3] = 0.25 * (coord[4] + coord[5] + coord[6] + coord[7]);
	face_coord[4] = 0.25 * (coord[1] + coord[2] + coord[6] + coord[5]);
	face_coord[5] = 0.25 * (coord[2] + coord[3] + coord[7] + coord[6]);

	// Calcule la longueur caractéristique de la maille.
	{
		Real3 median1 = face_coord[0] - face_coord[3];
		Real3 median2 = face_coord[2] - face_coord[5];
		Real3 median3 = face_coord[1] - face_coord[4];
		Real d1 = median1.abs();
		Real d2 = median2.abs();
		Real d3 = median3.abs();

		Real dx_numerator = d1 * d2 * d3;
		Real dx_denominator = d1 * d2 + d1 * d3 + d2 * d3;
		vars.m_caracteristic_length[cell] = dx_numerator / dx_denominator;
	}

	// Calcule les résultantes aux sommets
	computeCQs(coord, face_coord, cell);

	// Calcule le volume de la maille
	{
		Real volume = 0.;
		for (Integer inode = 0; inode < 8; ++inode)
			volume += math::scaMul(coord[inode], vars.m_cell_cqs[cell] [inode]);
		volume /= 3.;

		vars.m_cell_volume[cell] = volume;
	}
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void DefaultLoopDelegationService::
updateDensity(const Cell cell, DefaultLoopDelegationUpdateDensityVars& vars)
{
	// Real old_density = vars.m_density[icell];
	Real new_density = vars.m_cell_mass[cell] / vars.m_cell_volume[cell];
	vars.m_density[cell] = new_density;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void DefaultLoopDelegationService::
computeInternalEnergy(const Cell cell, DefaultLoopDelegationComputeInternalEnergyVars& vars)
{
	Real adiabatic_cst = vars.m_adiabatic_cst[cell];
	Real volume_ratio = vars.m_cell_volume[cell] / vars.m_old_cell_volume[cell];
	Real x = 0.5 * (adiabatic_cst - 1.);
	Real numer_accrois_nrj = 1. + x * (1. - volume_ratio);
	Real denom_accrois_nrj = 1. + x * (1. - 1. / volume_ratio);
	//denom_accrois_nrj = 0.0;
	vars.m_internal_energy[cell] *= numer_accrois_nrj / denom_accrois_nrj;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void DefaultLoopDelegationService::
computePressureForce(const Cell cell, DefaultLoopDelegationComputePressureForceVars& vars)
{
	Real pressure = vars.m_pressure[cell];
	for (NodeEnumerator inode(cell.nodes()); inode.hasNext(); ++inode)
		vars.m_force[inode] += pressure * vars.m_cell_cqs[cell] [inode.index()];
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

inline void DefaultLoopDelegationService::
computeCQs(Real3 node_coord[8], Real3 face_coord[6], const Cell & cell)
{
	const Real3 c0 = face_coord[0];
	const Real3 c1 = face_coord[1];
	const Real3 c2 = face_coord[2];
	const Real3 c3 = face_coord[3];
	const Real3 c4 = face_coord[4];
	const Real3 c5 = face_coord[5];

	// Calcul des normales face 1 :
	const Real3 n1a04 = 0.5 * math::vecMul(node_coord[0] - c0, node_coord[3] - c0);
	const Real3 n1a03 = 0.5 * math::vecMul(node_coord[3] - c0, node_coord[2] - c0);
	const Real3 n1a02 = 0.5 * math::vecMul(node_coord[2] - c0, node_coord[1] - c0);
	const Real3 n1a01 = 0.5 * math::vecMul(node_coord[1] - c0, node_coord[0] - c0);

	// Calcul des normales face 2 :
	const Real3 n2a05 = 0.5 * math::vecMul(node_coord[0] - c1, node_coord[4] - c1);
	const Real3 n2a12 = 0.5 * math::vecMul(node_coord[4] - c1, node_coord[7] - c1);
	const Real3 n2a08 = 0.5 * math::vecMul(node_coord[7] - c1, node_coord[3] - c1);
	const Real3 n2a04 = 0.5 * math::vecMul(node_coord[3] - c1, node_coord[0] - c1);

	// Calcul des normales face 3 :
	const Real3 n3a01 = 0.5 * math::vecMul(node_coord[0] - c2, node_coord[1] - c2);
	const Real3 n3a06 = 0.5 * math::vecMul(node_coord[1] - c2, node_coord[5] - c2);
	const Real3 n3a09 = 0.5 * math::vecMul(node_coord[5] - c2, node_coord[4] - c2);
	const Real3 n3a05 = 0.5 * math::vecMul(node_coord[4] - c2, node_coord[0] - c2);

	// Calcul des normales face 4 :
	const Real3 n4a09 = 0.5 * math::vecMul(node_coord[4] - c3, node_coord[5] - c3);
	const Real3 n4a10 = 0.5 * math::vecMul(node_coord[5] - c3, node_coord[6] - c3);
	const Real3 n4a11 = 0.5 * math::vecMul(node_coord[6] - c3, node_coord[7] - c3);
	const Real3 n4a12 = 0.5 * math::vecMul(node_coord[7] - c3, node_coord[4] - c3);

	// Calcul des normales face 5 :
	const Real3 n5a02 = 0.5 * math::vecMul(node_coord[1] - c4, node_coord[2] - c4);
	const Real3 n5a07 = 0.5 * math::vecMul(node_coord[2] - c4, node_coord[6] - c4);
	const Real3 n5a10 = 0.5 * math::vecMul(node_coord[6] - c4, node_coord[5] - c4);
	const Real3 n5a06 = 0.5 * math::vecMul(node_coord[5] - c4, node_coord[1] - c4);

	// Calcul des normales face 6 :
	const Real3 n6a03 = 0.5 * math::vecMul(node_coord[2] - c5, node_coord[3] - c5);
	const Real3 n6a08 = 0.5 * math::vecMul(node_coord[3] - c5, node_coord[7] - c5);
	const Real3 n6a11 = 0.5 * math::vecMul(node_coord[7] - c5, node_coord[6] - c5);
	const Real3 n6a07 = 0.5 * math::vecMul(node_coord[6] - c5, node_coord[2] - c5);

	// Calcul des résultantes aux sommets :
	m_cell_cqs[cell] [0] = (5. * (n1a01 + n1a04 + n2a04 + n2a05 + n3a05 + n3a01) +
			(n1a02 + n1a03 + n2a08 + n2a12 + n3a06 + n3a09)) * (1. / 12.);
	m_cell_cqs[cell] [1] = (5. * (n1a01 + n1a02 + n3a01 + n3a06 + n5a06 + n5a02) +
			(n1a04 + n1a03 + n3a09 + n3a05 + n5a10 + n5a07)) * (1. / 12.);
	m_cell_cqs[cell] [2] = (5. * (n1a02 + n1a03 + n5a07 + n5a02 + n6a07 + n6a03) +
			(n1a01 + n1a04 + n5a06 + n5a10 + n6a11 + n6a08)) * (1. / 12.);
	m_cell_cqs[cell] [3] = (5. * (n1a03 + n1a04 + n2a08 + n2a04 + n6a08 + n6a03) +
			(n1a01 + n1a02 + n2a05 + n2a12 + n6a07 + n6a11)) * (1. / 12.);
	m_cell_cqs[cell] [4] = (5. * (n2a05 + n2a12 + n3a05 + n3a09 + n4a09 + n4a12) +
			(n2a08 + n2a04 + n3a01 + n3a06 + n4a10 + n4a11)) * (1. / 12.);
	m_cell_cqs[cell] [5] = (5. * (n3a06 + n3a09 + n4a09 + n4a10 + n5a10 + n5a06) +
			(n3a01 + n3a05 + n4a12 + n4a11 + n5a07 + n5a02)) * (1. / 12.);
	m_cell_cqs[cell] [6] = (5. * (n4a11 + n4a10 + n5a10 + n5a07 + n6a07 + n6a11) +
			(n4a12 + n4a09 + n5a06 + n5a02 + n6a03 + n6a08)) * (1. / 12.);
	m_cell_cqs[cell] [7] = (5. * (n2a08 + n2a12 + n4a12 + n4a11 + n6a11 + n6a08) +
			(n2a04 + n2a05 + n4a09 + n4a10 + n6a07 + n6a03)) * (1. / 12.);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ARCANE_REGISTER_SERVICE_DEFAULTLOOPDELEGATION(DefaultLoopDelegation, DefaultLoopDelegationService);

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace MicroHydro
