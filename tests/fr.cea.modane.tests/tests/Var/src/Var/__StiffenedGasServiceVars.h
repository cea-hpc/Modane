#ifndef VAR___STIFFENEDGASSERVICEVARS_H
#define VAR___STIFFENEDGASSERVICEVARS_H

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

//! Classe de variable pour apply
struct StiffenedGasApplyVars final
{
  StiffenedGasApplyVars(const VariableCellReal& pressure,
      const VariableArrayString& plasticity,
      const VariableParticleReal& particle_density,
      VariableCellReal& temperature,
      MaterialVariableCellReal& mat_density,
      const VariableParticleReal& abstract_particle_var)
  : m_pressure(pressure)
  , m_plasticity(plasticity)
  , m_particle_density(particle_density)
  , m_temperature(temperature)
  , m_mat_density(mat_density)
  , m_abstract_particle_var(abstract_particle_var)
  {}

  /*!
  [in] pressure
  */
  const VariableCellReal& m_pressure;
  /*!
  [in] plasticity
  */
  const VariableArrayString& m_plasticity;
  /*!
  [in] particle_density
  */
  const VariableParticleReal& m_particle_density;
  /*!
  [out] temperature
  */
  VariableCellReal& m_temperature;
  /*!
  [out] mat_density
  */
  MaterialVariableCellReal& m_mat_density;
  /*!
  [in] abstract_particle_var
  */
  const VariableParticleReal& m_abstract_particle_var;
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Var

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // VAR___STIFFENEDGASSERVICEVARS_H
