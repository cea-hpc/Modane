#ifndef PARAMETERDEFAULTVALUE_NOVARASARGS_UPDATERNOVARSIMPLSERVICE_H
#define PARAMETERDEFAULTVALUE_NOVARASARGS_UPDATERNOVARSIMPLSERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "ParameterDefaultValue/NoVarAsArgs/__UpdaterNoVarsImplServiceBase.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace ParameterDefaultValueNoVarAsArgs {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service ParameterDefaultValue.NoVarAsArgs.UpdaterNoVarsImpl : implémentation
 * 
 */
class UpdaterNoVarsImplService
: public UpdaterNoVarsImplServiceBase<UpdaterNoVarsImplService>
{
 public:
  explicit UpdaterNoVarsImplService(const ServiceBuildInfo& bi);
  
  ~UpdaterNoVarsImplService();

 public:
  Real fOfService(const Real a=1.0) override;
  Real f(const Real a=1.0) override;
  void fWithSupport(const Cell cell, const Real a=1.0) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace ParameterDefaultValueNoVarAsArgs

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PARAMETERDEFAULTVALUE_NOVARASARGS_UPDATERNOVARSIMPLSERVICE_H
