#ifndef IWITHOUTS_OUTSIDE_OUTSIDESERVICE_H
#define IWITHOUTS_OUTSIDE_OUTSIDESERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "IWithoutS/Outside/__OutsideServiceBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace IWithoutSOutside {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service Outside : implémentation
 * 
 */
class OutsideService
: public OutsideServiceBase<OutsideService>
{
 public:
  explicit OutsideService(const ServiceBuildInfo& bi);
  ~OutsideService();

 public:
  void compute(OutsideComputeVars& vars) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSOutside

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_OUTSIDE_OUTSIDESERVICE_H
