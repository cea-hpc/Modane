#ifndef ABSTRACTVAR_UPDATER___UPDATERIMPLSERVICEVARS_H
#define ABSTRACTVAR_UPDATER___UPDATERIMPLSERVICEVARS_H

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
namespace AbstractVarUpdater {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

//! Classe de variable pour update
struct UpdaterImplUpdateVars final
{
  UpdaterImplUpdateVars(const VariableCellReal& temperature,
      VariableCellReal& abstract_pressure)
  : m_temperature(temperature)
  , m_abstract_pressure(abstract_pressure)
  {}

  /*!
  [in] temperature
  */
  const VariableCellReal& m_temperature;
  /*!
  [inout] abstract_pressure
  */
  VariableCellReal& m_abstract_pressure;
};

//! Classe de variable pour updatePressure
struct UpdaterImplUpdatePressureVars final
{
  UpdaterImplUpdatePressureVars(const VariableCellReal& temperature,
      VariableCellReal& abstract_pressure)
  : m_temperature(temperature)
  , m_abstract_pressure(abstract_pressure)
  {}

  /*!
  [in] temperature
  */
  const VariableCellReal& m_temperature;
  /*!
  [inout] abstract_pressure
  */
  VariableCellReal& m_abstract_pressure;
};

//! Classe de variable pour updatePressureWithParam
struct UpdaterImplUpdatePressureWithParamVars final
{
  UpdaterImplUpdatePressureWithParamVars(const VariableCellReal& temperature,
      VariableCellReal& abstract_pressure)
  : m_temperature(temperature)
  , m_abstract_pressure(abstract_pressure)
  {}

  /*!
  [in] temperature
  */
  const VariableCellReal& m_temperature;
  /*!
  [inout] abstract_pressure
  */
  VariableCellReal& m_abstract_pressure;
};

//! Classe de variable pour updateOldPressure
struct UpdaterImplUpdateOldPressureVars final
{
  UpdaterImplUpdateOldPressureVars(const VariableCellReal& temperature,
      VariableCellReal& old_pressure)
  : m_temperature(temperature)
  , m_old_pressure(old_pressure)
  {}

  /*!
  [in] temperature
  */
  const VariableCellReal& m_temperature;
  /*!
  [inout] old_pressure
  */
  VariableCellReal& m_old_pressure;
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace AbstractVarUpdater

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // ABSTRACTVAR_UPDATER___UPDATERIMPLSERVICEVARS_H
