#ifndef ABSTRACTVAR___HYDROMODULEVARS_H
#define ABSTRACTVAR___HYDROMODULEVARS_H

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
namespace AbstractVar {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

//! Classe de variable pour compute
struct HydroComputeVars final
{
  HydroComputeVars(VariableCellReal& new_pressure,
      VariableCellReal& old_pressure)
  : m_new_pressure(new_pressure)
  , m_old_pressure(old_pressure)
  {}

  /*!
  [inout] new_pressure
  */
  VariableCellReal& m_new_pressure;
  /*!
  [inout] old_pressure
  */
  VariableCellReal& m_old_pressure;
};

//! Classe de variable pour init
struct HydroInitVars final
{
  HydroInitVars(VariableCellReal& new_pressure,
      VariableCellReal& old_pressure)
  : m_new_pressure(new_pressure)
  , m_old_pressure(old_pressure)
  {}

  /*!
  [out] new_pressure
  */
  VariableCellReal& m_new_pressure;
  /*!
  [out] old_pressure
  */
  VariableCellReal& m_old_pressure;
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace AbstractVar

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // ABSTRACTVAR___HYDROMODULEVARS_H
