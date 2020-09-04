#ifndef IWITHOUTS_INTERFACES___REFPROPERTYINTERFDEFAULTVARS_H
#define IWITHOUTS_INTERFACES___REFPROPERTYINTERFDEFAULTVARS_H

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
namespace IWithoutSInterfaces {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

//! Classe de variable pour compute
struct RefPropertyInterfDefaultComputeVars final
{
  RefPropertyInterfDefaultComputeVars(const VariableCellReal& abstract_temperature,
      VariableCellReal& abstract_density)
  : m_abstract_temperature(abstract_temperature)
  , m_abstract_density(abstract_density)
  {}

  /*!
  [in] abstract_temperature
  */
  const VariableCellReal& m_abstract_temperature;
  /*!
  [out] abstract_density
  */
  VariableCellReal& m_abstract_density;
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSInterfaces

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_INTERFACES___REFPROPERTYINTERFDEFAULTVARS_H
