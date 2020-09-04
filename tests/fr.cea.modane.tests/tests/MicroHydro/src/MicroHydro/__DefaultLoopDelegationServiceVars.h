#ifndef MICROHYDRO___DEFAULTLOOPDELEGATIONSERVICEVARS_H
#define MICROHYDRO___DEFAULTLOOPDELEGATIONSERVICEVARS_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace MicroHydro {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

//! Classe de variable pour computeNodeImpulsion
struct DefaultLoopDelegationComputeNodeImpulsionVars final
{
  DefaultLoopDelegationComputeNodeImpulsionVars(const VariableNodeReal& node_mass,
      const VariableNodeReal3& force,
      VariableNodeReal3& velocity)
  : m_node_mass(node_mass)
  , m_force(force)
  , m_velocity(velocity)
  {}

  /*!
  [in] node_mass
  */
  const VariableNodeReal& m_node_mass;
  /*!
  [in] force
  */
  const VariableNodeReal3& m_force;
  /*!
  [inout] velocity
  */
  VariableNodeReal3& m_velocity;
};

//! Classe de variable pour applyBoundaryCondition
struct DefaultLoopDelegationApplyBoundaryConditionVars final
{
  explicit DefaultLoopDelegationApplyBoundaryConditionVars(VariableNodeReal3& velocity)
  : m_velocity(velocity)
  {}

  /*!
  [inout] velocity
  */
  VariableNodeReal3& m_velocity;
};

//! Classe de variable pour moveNodes
struct DefaultLoopDelegationMoveNodesVars final
{
  DefaultLoopDelegationMoveNodesVars(const VariableNodeReal3& velocity,
      VariableNodeReal3& node_coord)
  : m_velocity(velocity)
  , m_node_coord(node_coord)
  {}

  /*!
  [in] velocity
  */
  const VariableNodeReal3& m_velocity;
  /*!
  [out] node_coord
  */
  VariableNodeReal3& m_node_coord;
};

//! Classe de variable pour computeGeometricValues
struct DefaultLoopDelegationComputeGeometricValuesVars final
{
  DefaultLoopDelegationComputeGeometricValuesVars(const VariableNodeReal3& node_coord,
      VariableCellReal& old_cell_volume,
      VariableCellReal& cell_volume,
      VariableCellReal& caracteristic_length,
      VariableCellArrayReal3& cell_cqs)
  : m_node_coord(node_coord)
  , m_old_cell_volume(old_cell_volume)
  , m_cell_volume(cell_volume)
  , m_caracteristic_length(caracteristic_length)
  , m_cell_cqs(cell_cqs)
  {}

  /*!
  [in] node_coord
  */
  const VariableNodeReal3& m_node_coord;
  /*!
  [inout] old_cell_volume
  */
  VariableCellReal& m_old_cell_volume;
  /*!
  [inout] cell_volume
  */
  VariableCellReal& m_cell_volume;
  /*!
  [out] caracteristic_length
  */
  VariableCellReal& m_caracteristic_length;
  /*!
  [inout] cell_cqs
  Ceci est la documentation du Cqs.
  */
  VariableCellArrayReal3& m_cell_cqs;
};

//! Classe de variable pour updateDensity
struct DefaultLoopDelegationUpdateDensityVars final
{
  DefaultLoopDelegationUpdateDensityVars(const VariableCellReal& cell_mass,
      const VariableCellReal& cell_volume,
      VariableCellReal& density)
  : m_cell_mass(cell_mass)
  , m_cell_volume(cell_volume)
  , m_density(density)
  {}

  /*!
  [in] cell_mass
  */
  const VariableCellReal& m_cell_mass;
  /*!
  [in] cell_volume
  */
  const VariableCellReal& m_cell_volume;
  /*!
  [out] density
  Ceci est la documentation de la densité.
  */
  VariableCellReal& m_density;
};

//! Classe de variable pour computeInternalEnergy
struct DefaultLoopDelegationComputeInternalEnergyVars final
{
  DefaultLoopDelegationComputeInternalEnergyVars(const VariableCellReal& cell_volume,
      const VariableCellReal& old_cell_volume,
      const VariableCellReal& adiabatic_cst,
      VariableCellReal& internal_energy)
  : m_cell_volume(cell_volume)
  , m_old_cell_volume(old_cell_volume)
  , m_adiabatic_cst(adiabatic_cst)
  , m_internal_energy(internal_energy)
  {}

  /*!
  [in] cell_volume
  */
  const VariableCellReal& m_cell_volume;
  /*!
  [in] old_cell_volume
  */
  const VariableCellReal& m_old_cell_volume;
  /*!
  [in] adiabatic_cst
  */
  const VariableCellReal& m_adiabatic_cst;
  /*!
  [out] internal_energy
  */
  VariableCellReal& m_internal_energy;
};

//! Classe de variable pour computePressureForce
struct DefaultLoopDelegationComputePressureForceVars final
{
  DefaultLoopDelegationComputePressureForceVars(const VariableCellReal& pressure,
      const VariableCellArrayReal3& cell_cqs,
      VariableNodeReal3& force)
  : m_pressure(pressure)
  , m_cell_cqs(cell_cqs)
  , m_force(force)
  {}

  /*!
  [in] pressure
  */
  const VariableCellReal& m_pressure;
  /*!
  [in] cell_cqs
  Ceci est la documentation du Cqs.
  */
  const VariableCellArrayReal3& m_cell_cqs;
  /*!
  [out] force
  */
  VariableNodeReal3& m_force;
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace MicroHydro

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // MICROHYDRO___DEFAULTLOOPDELEGATIONSERVICEVARS_H
