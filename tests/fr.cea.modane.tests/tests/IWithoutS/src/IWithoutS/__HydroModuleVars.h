#ifndef IWITHOUTS___HYDROMODULEVARS_H
#define IWITHOUTS___HYDROMODULEVARS_H

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
namespace IWithoutS {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

//! Classe de variable pour computeEos
struct HydroComputeEosVars final
{
  HydroComputeEosVars()
  {}
};

//! Classe de variable pour computeNoPropertyInterf
struct HydroComputeNoPropertyInterfVars final
{
  HydroComputeNoPropertyInterfVars(const VariableCellReal& temperature,
      VariableCellReal& density)
  : m_temperature(temperature)
  , m_density(density)
  {}

  /*!
  [in] temperature
  */
  const VariableCellReal& m_temperature;
  /*!
  [out] density
  */
  VariableCellReal& m_density;
};

//! Classe de variable pour computeRefPropertyInterf
struct HydroComputeRefPropertyInterfVars final
{
  HydroComputeRefPropertyInterfVars(const VariableCellReal& temperature,
      VariableCellReal& density)
  : m_temperature(temperature)
  , m_density(density)
  {}

  /*!
  [in] temperature
  */
  const VariableCellReal& m_temperature;
  /*!
  [out] density
  */
  VariableCellReal& m_density;
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutS

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS___HYDROMODULEVARS_H
