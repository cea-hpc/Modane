#ifndef SERVICE_COMPRI2SERVICE_H
#define SERVICE_COMPRI2SERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Service/__Compri2ServiceBase.h"
#include "ProjectIncludes.h"
#include "Service/Legacy.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service Compri2 : implémentation
 * 
 */
class Compri2Service
: public Compri2ServiceBase<Compri2Service>
{
 public:
  explicit Compri2Service(const ServiceBuildInfo& bi);
  ~Compri2Service();

 public:
  void compute(Compri2ComputeVars& vars, const ::onf::OnfUtils::Duboi* duboi, Array< Danlacol* >& danlacol) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE_COMPRI2SERVICE_H
