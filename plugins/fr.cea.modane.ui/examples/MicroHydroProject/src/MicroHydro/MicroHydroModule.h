#ifndef MICRO_HYDRO_MODULE_H
#define MICRO_HYDRO_MODULE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "MicroHydro/__MicroHydroModuleBase.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace MicroHydro {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Classe d'implémentation du module MicroHydro
 *
 * 
 */
class MicroHydroModule
: public MicroHydroModuleBase<MicroHydroModule>
{
 public:
	MicroHydroModule(const ModuleBuildInfo& mbi);
	~MicroHydroModule();

 protected:
	void hydroStartInit(MicroHydroHydroStartInitVars& vars);
	void hydroContinueInit(MicroHydroHydroContinueInitVars& vars);
	void computePressureForce(MicroHydroComputePressureForceVars& vars);
	void computeVelocity(MicroHydroComputeVelocityVars& vars);
	void applyBoundaryCondition(MicroHydroApplyBoundaryConditionVars& vars);
	void moveNodes(MicroHydroMoveNodesVars& vars);
	void computeGeometricValues(MicroHydroComputeGeometricValuesVars& vars);
	void updateDensity(MicroHydroUpdateDensityVars& vars);
	void applyEquationOfState(MicroHydroApplyEquationOfStateVars& vars);
	void computeDeltaT(MicroHydroComputeDeltaTVars& vars);
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace MicroHydro

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif /* MICRO_HYDRO_MODULE_H */
