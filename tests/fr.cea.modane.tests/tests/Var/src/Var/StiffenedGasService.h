#ifndef VAR_STIFFENEDGASSERVICE_H
#define VAR_STIFFENEDGASSERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Var/__StiffenedGasServiceBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace Var {

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
  void apply(StiffenedGasApplyVars& vars, const Real coef) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Var

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // VAR_STIFFENEDGASSERVICE_H
