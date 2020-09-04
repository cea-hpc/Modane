#ifndef SERVICE_TRACKINGDEFAULTSERVICE_H
#define SERVICE_TRACKINGDEFAULTSERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Service/__TrackingDefaultServiceBase.h"
#include "ProjectIncludes.h"
#include "Service/__ITrackingable.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service TrackingDefault : implémentation
 * Service par défaut pour l'interface Tracking
 */
class TrackingDefaultService
: public TrackingDefaultServiceBase<TrackingDefaultService>
{
 public:
  explicit TrackingDefaultService(const ServiceBuildInfo& bi);
  ~TrackingDefaultService();

 public:
  void init(TrackingDefaultInitVars& vars, const ITrackingable* t) override;
  void compute(TrackingDefaultComputeVars& vars) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE_TRACKINGDEFAULTSERVICE_H
