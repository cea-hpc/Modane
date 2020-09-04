#ifndef SERVICE___HYDROMODULEVARS_H
#define SERVICE___HYDROMODULEVARS_H

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
namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

//! Classe de variable pour compute
struct HydroComputeVars final
{
  HydroComputeVars()
  {}
};

//! Classe de variable pour autoLoadCompute
struct HydroAutoLoadComputeVars final
{
  HydroAutoLoadComputeVars()
  {}
};

//! Classe de variable pour giveContribution
struct HydroGiveContributionVars final
{
  HydroGiveContributionVars()
  {}
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE___HYDROMODULEVARS_H
