#ifndef SERVICE___ITRACKING_H
#define SERVICE___ITRACKING_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Service/__ITrackingable.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Tracking
 * 
 */
class ITracking
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  ITracking() {}
  virtual ~ITracking() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;
  virtual Real getCfl() = 0;

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li TrackingDefaultServiceBase::init
  */
  virtual void init(const ITrackingable* t) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li TrackingDefaultServiceBase::compute
  */
  virtual void compute() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE___ITRACKING_H
