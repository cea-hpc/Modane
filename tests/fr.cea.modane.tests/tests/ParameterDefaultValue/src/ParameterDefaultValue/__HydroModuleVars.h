#ifndef PARAMETERDEFAULTVALUE___HYDROMODULEVARS_H
#define PARAMETERDEFAULTVALUE___HYDROMODULEVARS_H

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
namespace ParameterDefaultValue {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

//! Classe de variable pour compute
struct HydroComputeVars final
{
  HydroComputeVars()
  {}
};

//! Classe de variable pour computeWithMyStruct
struct HydroComputeWithMyStructVars final
{
  HydroComputeWithMyStructVars()
  {}
};

//! Classe de variable pour computeWithString
struct HydroComputeWithStringVars final
{
  HydroComputeWithStringVars()
  {}
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace ParameterDefaultValue

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PARAMETERDEFAULTVALUE___HYDROMODULEVARS_H
