#ifndef VAR___HYDROMODULEVARS_H
#define VAR___HYDROMODULEVARS_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "arcane/materials/ComponentItemVector.h"
#include "arcane/materials/ComponentItemVectorView.h"
#include "arcane/materials/MeshEnvironmentVariableRef.h"
#include "arcane/materials/MeshMaterialVariableRef.h"
#include "arcane/materials/IMeshMaterialMng.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace Var {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

//! Classe de variable pour compute
struct HydroComputeVars final
{
  HydroComputeVars(const VariableCellReal& pressure,
      const VariableCellByte& boolean_var,
      const VariableParticleReal& particle_energy,
      const MaterialVariableCellArrayByte& mat_array_var,
      const VariableDoFReal& dof_energy,
      VariableCellReal& temperature,
      EnvironmentVariableCellReal& env_elasticity,
      VariableParticleReal& particle_density)
  : m_pressure(pressure)
  , m_boolean_var(boolean_var)
  , m_particle_energy(particle_energy)
  , m_mat_array_var(mat_array_var)
  , m_dof_energy(dof_energy)
  , m_temperature(temperature)
  , m_env_elasticity(env_elasticity)
  , m_particle_density(particle_density)
  {}

  /*!
  [in] pressure
  */
  const VariableCellReal& m_pressure;
  /*!
  [in] boolean_var
  */
  const VariableCellByte& m_boolean_var;
  /*!
  [in] particle_energy
  */
  const VariableParticleReal& m_particle_energy;
  /*!
  [in] mat_array_var
  */
  const MaterialVariableCellArrayByte& m_mat_array_var;
  /*!
  [in] dof_energy
  */
  const VariableDoFReal& m_dof_energy;
  /*!
  [out] temperature
  */
  VariableCellReal& m_temperature;
  /*!
  [out] env_elasticity
  */
  EnvironmentVariableCellReal& m_env_elasticity;
  /*!
  [out] particle_density
  */
  VariableParticleReal& m_particle_density;
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Var

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // VAR___HYDROMODULEVARS_H
