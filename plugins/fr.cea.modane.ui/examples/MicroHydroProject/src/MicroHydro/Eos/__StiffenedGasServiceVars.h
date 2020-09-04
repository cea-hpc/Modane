#ifndef MICROHYDRO_EOS___STIFFENEDGASSERVICEVARS_H
#define MICROHYDRO_EOS___STIFFENEDGASSERVICEVARS_H

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
namespace MicroHydroEos {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

//! Classe de variable pour initEOS
struct StiffenedGasInitEOSVars final
{
  StiffenedGasInitEOSVars(const VariableCellReal& adiabatic_cst,
      const VariableCellReal& density,
      const VariableCellReal& pressure,
      VariableCellReal& internal_energy,
      VariableCellReal& sound_speed)
  : m_adiabatic_cst(adiabatic_cst)
  , m_density(density)
  , m_pressure(pressure)
  , m_internal_energy(internal_energy)
  , m_sound_speed(sound_speed)
  {}

  /*!
  [in] adiabatic_cst
  */
  const VariableCellReal& m_adiabatic_cst;
  /*!
  [in] density
  */
  const VariableCellReal& m_density;
  /*!
  [in] pressure
  */
  const VariableCellReal& m_pressure;
  /*!
  [out] internal_energy
  */
  VariableCellReal& m_internal_energy;
  /*!
  [out] sound_speed
  */
  VariableCellReal& m_sound_speed;
};

//! Classe de variable pour applyEOS
struct StiffenedGasApplyEOSVars final
{
  StiffenedGasApplyEOSVars(const VariableCellReal& internal_energy,
      const VariableCellReal& density,
      const VariableCellReal& adiabatic_cst,
      VariableCellReal& pressure,
      VariableCellReal& sound_speed)
  : m_internal_energy(internal_energy)
  , m_density(density)
  , m_adiabatic_cst(adiabatic_cst)
  , m_pressure(pressure)
  , m_sound_speed(sound_speed)
  {}

  /*!
  [in] internal_energy
  */
  const VariableCellReal& m_internal_energy;
  /*!
  [in] density
  */
  const VariableCellReal& m_density;
  /*!
  [in] adiabatic_cst
  */
  const VariableCellReal& m_adiabatic_cst;
  /*!
  [out] pressure
  */
  VariableCellReal& m_pressure;
  /*!
  [out] sound_speed
  */
  VariableCellReal& m_sound_speed;
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace MicroHydroEos

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // MICROHYDRO_EOS___STIFFENEDGASSERVICEVARS_H
