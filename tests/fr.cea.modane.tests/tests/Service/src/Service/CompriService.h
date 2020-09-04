#ifndef SERVICE_COMPRISERVICE_H
#define SERVICE_COMPRISERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Service/__CompriServiceBase.h"
#include "ProjectIncludes.h"
#include "Service/Legacy.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service Compri : implémentation
 * 
 */
class CompriService
: public CompriServiceBase<CompriService>
{
 public:
  explicit CompriService(const ServiceBuildInfo& bi);
  ~CompriService();

 public:
  void compute(CompriComputeVars& vars, const ::onf::OnfUtils::Duboi* duboi, Array< Danlacol* >& danlacol) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE_COMPRISERVICE_H
