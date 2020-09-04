#ifndef SERVICE___TRACKINGDEFAULTSERVICEVARS_H
#define SERVICE___TRACKINGDEFAULTSERVICEVARS_H

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

//! Classe de variable pour init
struct TrackingDefaultInitVars final
{
  TrackingDefaultInitVars()
  {}
};

//! Classe de variable pour compute
struct TrackingDefaultComputeVars final
{
  TrackingDefaultComputeVars()
  {}
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE___TRACKINGDEFAULTSERVICEVARS_H
