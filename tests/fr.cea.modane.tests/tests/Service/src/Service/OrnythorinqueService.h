#ifndef SERVICE_ORNYTHORINQUESERVICE_H
#define SERVICE_ORNYTHORINQUESERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Service/__OrnythorinqueServiceBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service Ornythorinque : implémentation
 * 
 */
class OrnythorinqueService
: public OrnythorinqueServiceBase<OrnythorinqueService>
{
 public:
  explicit OrnythorinqueService(const ServiceBuildInfo& bi);
  ~OrnythorinqueService();

 public:
  void g(OrnythorinqueGVars& vars) override;
  void f(OrnythorinqueFVars& vars) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE_ORNYTHORINQUESERVICE_H
