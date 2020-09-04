#ifndef VAR_PERFECTGASSERVICE_H
#define VAR_PERFECTGASSERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Var/__PerfectGasServiceBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace Var {

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
  void persoFunc(PerfectGasPersoFuncVars& vars) override;
  void apply(PerfectGasApplyVars& vars, const Real coef) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Var

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // VAR_PERFECTGASSERVICE_H
