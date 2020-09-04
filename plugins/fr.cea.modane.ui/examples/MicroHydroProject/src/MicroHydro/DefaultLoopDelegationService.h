#ifndef DEFAULT_LOOP_DELEGATION_SERVICE_H
#define DEFAULT_LOOP_DELEGATION_SERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "MicroHydro/__DefaultLoopDelegationServiceBase.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace MicroHydro {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Classe d'implémentation du service DefaultLoopDelegation
 *
 * 
 */
class DefaultLoopDelegationService
: public DefaultLoopDelegationServiceBase<DefaultLoopDelegationService>
{
 public:
	DefaultLoopDelegationService(const ServiceBuildInfo& sbi);
	~DefaultLoopDelegationService();

 public:
	void computeNodeImpulsion(const Node node, DefaultLoopDelegationComputeNodeImpulsionVars& vars);
	void applyBoundaryCondition(const Face face, DefaultLoopDelegationApplyBoundaryConditionVars& vars, const Real boundary_condition_value, const BoundaryConditionType boundary_condition_type);
	void moveNodes(const Node node, DefaultLoopDelegationMoveNodesVars& vars);
	void computeGeometricValues(const Cell cell, DefaultLoopDelegationComputeGeometricValuesVars& vars);
	void updateDensity(const Cell cell, DefaultLoopDelegationUpdateDensityVars& vars);
	void computeInternalEnergy(const Cell cell, DefaultLoopDelegationComputeInternalEnergyVars& vars);
 	void computePressureForce(const Cell cell, DefaultLoopDelegationComputePressureForceVars& vars);

 private:
	inline void computeCQs(Real3 node_coord[8], Real3 face_coord[6], const Cell & cell);
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace MicroHydro

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif /* DEFAULT_LOOP_DELEGATION_SERVICE_H */
