#ifndef MICROHYDRO___MICROHYDROMODULEVARS_H
#define MICROHYDRO___MICROHYDROMODULEVARS_H

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

//! Classe de variable pour hydroStartInit
struct MicroHydroHydroStartInitVars final
{
  MicroHydroHydroStartInitVars(const VariableCellReal& density,
      VariableCellArrayReal3& cell_cqs,
      VariableCellReal& cell_mass,
      VariableNodeReal& node_mass,
      VariableCellReal& old_cell_volume,
      VariableCellReal& caracteristic_length,
      VariableCellReal& cell_volume,
      VariableNodeReal3& node_coord)
  : m_density(density)
  , m_cell_cqs(cell_cqs)
  , m_cell_mass(cell_mass)
  , m_node_mass(node_mass)
  , m_old_cell_volume(old_cell_volume)
  , m_caracteristic_length(caracteristic_length)
  , m_cell_volume(cell_volume)
  , m_node_coord(node_coord)
  {}

  /*!
  [in] density
  Ceci est la documentation de la densité.
  */
  const VariableCellReal& m_density;
  /*!
  [inout] cell_cqs
  Ceci est la documentation du Cqs.
  */
  VariableCellArrayReal3& m_cell_cqs;
  /*!
  [out] cell_mass
  */
  VariableCellReal& m_cell_mass;
  /*!
  [out] node_mass
  */
  VariableNodeReal& m_node_mass;
  /*!
  [out] old_cell_volume
  */
  VariableCellReal& m_old_cell_volume;
  /*!
  [out] caracteristic_length
  */
  VariableCellReal& m_caracteristic_length;
  /*!
  [out] cell_volume
  */
  VariableCellReal& m_cell_volume;
  /*!
  [out] node_coord
  */
  VariableNodeReal3& m_node_coord;
};

//! Classe de variable pour hydroContinueInit
struct MicroHydroHydroContinueInitVars final
{
  MicroHydroHydroContinueInitVars(const VariableNodeReal3& node_coord,
      const VariableCellArrayReal3& cell_cqs,
      VariableCellReal& cell_volume)
  : m_node_coord(node_coord)
  , m_cell_cqs(cell_cqs)
  , m_cell_volume(cell_volume)
  {}

  /*!
  [in] node_coord
  */
  const VariableNodeReal3& m_node_coord;
  /*!
  [in] cell_cqs
  Ceci est la documentation du Cqs.
  */
  const VariableCellArrayReal3& m_cell_cqs;
  /*!
  [out] cell_volume
  */
  VariableCellReal& m_cell_volume;
};

//! Classe de variable pour computePressureForce
struct MicroHydroComputePressureForceVars final
{
  explicit MicroHydroComputePressureForceVars(VariableNodeReal3& force)
  : m_force(force)
  {}

  /*!
  [out] force
  */
  VariableNodeReal3& m_force;
};

//! Classe de variable pour computeVelocity
struct MicroHydroComputeVelocityVars final
{
  explicit MicroHydroComputeVelocityVars(VariableNodeReal3& velocity)
  : m_velocity(velocity)
  {}

  /*!
  [out] velocity
  */
  VariableNodeReal3& m_velocity;
};

//! Classe de variable pour applyBoundaryCondition
struct MicroHydroApplyBoundaryConditionVars final
{
  MicroHydroApplyBoundaryConditionVars()
  {}
};

//! Classe de variable pour moveNodes
struct MicroHydroMoveNodesVars final
{
  MicroHydroMoveNodesVars()
  {}
};

//! Classe de variable pour computeGeometricValues
struct MicroHydroComputeGeometricValuesVars final
{
  MicroHydroComputeGeometricValuesVars(const VariableCellReal& cell_volume,
      VariableCellReal& old_cell_volume)
  : m_cell_volume(cell_volume)
  , m_old_cell_volume(old_cell_volume)
  {}

  /*!
  [in] cell_volume
  */
  const VariableCellReal& m_cell_volume;
  /*!
  [out] old_cell_volume
  */
  VariableCellReal& m_old_cell_volume;
};

//! Classe de variable pour updateDensity
struct MicroHydroUpdateDensityVars final
{
  explicit MicroHydroUpdateDensityVars(VariableCellReal& density)
  : m_density(density)
  {}

  /*!
  [out] density
  Ceci est la documentation de la densité.
  */
  VariableCellReal& m_density;
};

//! Classe de variable pour applyEquationOfState
struct MicroHydroApplyEquationOfStateVars final
{
  MicroHydroApplyEquationOfStateVars()
  {}
};

//! Classe de variable pour computeDeltaT
struct MicroHydroComputeDeltaTVars final
{
  MicroHydroComputeDeltaTVars(const VariableCellReal& caracteristic_length,
      const VariableCellReal& sound_speed)
  : m_caracteristic_length(caracteristic_length)
  , m_sound_speed(sound_speed)
  {}

  /*!
  [in] caracteristic_length
  */
  const VariableCellReal& m_caracteristic_length;
  /*!
  [in] sound_speed
  */
  const VariableCellReal& m_sound_speed;
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace MicroHydro

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // MICROHYDRO___MICROHYDROMODULEVARS_H
