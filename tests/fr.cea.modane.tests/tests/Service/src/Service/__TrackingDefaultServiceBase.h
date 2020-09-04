#ifndef SERVICE___TRACKINGDEFAULTSERVICEBASE_H
#define SERVICE___TRACKINGDEFAULTSERVICEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Service/__ITracking.h"
#include "Service/__TrackingDefaultServiceVars.h"
#include "Service/__ITrackingable.h"
#include "Service/TrackingDefault_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service TrackingDefault : classe de base. 
 * Service par défaut pour l'interface Tracking
 */
template<class T>
class TrackingDefaultServiceBase
: public ArcaneTrackingDefaultObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit TrackingDefaultServiceBase(const ServiceBuildInfo& bi)
  : ArcaneTrackingDefaultObject(bi)
  {
  }

  virtual ~TrackingDefaultServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  Real getCfl() { return options()->getCfl(); }
  const String getImplName() const { return "TrackingDefaultService"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle TrackingDefaultService::init.
  */
  void init(const ITrackingable* t) override
  {
    TrackingDefaultInitVars vars;
    this->init(vars, t);
  }

  /*!
   Cette méthode construit les variables et appelle TrackingDefaultService::compute.
  */
  void compute() override
  {
    TrackingDefaultComputeVars vars;
    this->compute(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void init(TrackingDefaultInitVars& vars, const ITrackingable* t) = 0;
  virtual void compute(TrackingDefaultComputeVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE___TRACKINGDEFAULTSERVICEBASE_H
