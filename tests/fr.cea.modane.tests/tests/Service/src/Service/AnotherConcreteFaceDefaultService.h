#ifndef SERVICE_ANOTHERCONCRETEFACEDEFAULTSERVICE_H
#define SERVICE_ANOTHERCONCRETEFACEDEFAULTSERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Service/__AnotherConcreteFaceDefaultServiceBase.h"
#include "ProjectIncludes.h"
#include "Service/__IDeura.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service AnotherConcreteFaceDefault : implémentation
 * Service par défaut pour l'interface AnotherConcreteFace
 */
class AnotherConcreteFaceDefaultService
: public AnotherConcreteFaceDefaultServiceBase<AnotherConcreteFaceDefaultService>
{
 public:
  explicit AnotherConcreteFaceDefaultService(const ServiceBuildInfo& bi);
  ~AnotherConcreteFaceDefaultService();

 public:
  void compute(AnotherConcreteFaceDefaultComputeVars& vars, const IDeura* deura) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE_ANOTHERCONCRETEFACEDEFAULTSERVICE_H
