#ifndef PTYONINTERFACE_STIFFENEDGASSERVICE_H
#define PTYONINTERFACE_STIFFENEDGASSERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "PtyOnInterface/__StiffenedGasServiceBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace PtyOnInterface {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service StiffenedGas : implémentation
 * 
 */
class StiffenedGasService
: public StiffenedGasServiceBase<StiffenedGasService>
{
 public:
  explicit StiffenedGasService(const ServiceBuildInfo& bi);
  ~StiffenedGasService();

 public:
  void compute(StiffenedGasComputeVars& vars) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace PtyOnInterface

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PTYONINTERFACE_STIFFENEDGASSERVICE_H
