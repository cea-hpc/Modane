#ifndef SERVICE_SINGLETONDEFAULTSERVICE_H
#define SERVICE_SINGLETONDEFAULTSERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Service/__SingletonDefaultServiceBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service SingletonDefault : implémentation
 * 
 */
class SingletonDefaultService
: public SingletonDefaultServiceBase<SingletonDefaultService>
{
 public:
  explicit SingletonDefaultService(const ServiceBuildInfo& bi);
  ~SingletonDefaultService();

 public:
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE_SINGLETONDEFAULTSERVICE_H
