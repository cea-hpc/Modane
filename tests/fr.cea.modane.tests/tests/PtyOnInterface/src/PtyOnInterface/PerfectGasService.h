#ifndef PTYONINTERFACE_PERFECTGASSERVICE_H
#define PTYONINTERFACE_PERFECTGASSERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "PtyOnInterface/__PerfectGasServiceBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace PtyOnInterface {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service PerfectGas : implémentation
 * 
 */
class PerfectGasService
: public PerfectGasServiceBase<PerfectGasService>
{
 public:
  explicit PerfectGasService(const ServiceBuildInfo& bi);
  ~PerfectGasService();

 public:
  void compute(PerfectGasComputeVars& vars) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace PtyOnInterface

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PTYONINTERFACE_PERFECTGASSERVICE_H
