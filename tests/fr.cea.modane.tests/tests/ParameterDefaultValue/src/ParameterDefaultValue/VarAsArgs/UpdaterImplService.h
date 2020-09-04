#ifndef PARAMETERDEFAULTVALUE_VARASARGS_UPDATERIMPLSERVICE_H
#define PARAMETERDEFAULTVALUE_VARASARGS_UPDATERIMPLSERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "ParameterDefaultValue/VarAsArgs/__UpdaterImplServiceBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace ParameterDefaultValueVarAsArgs {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service ParameterDefaultValue.VarAsArgs.UpdaterImpl : implémentation
 * 
 */
class UpdaterImplService
: public UpdaterImplServiceBase<UpdaterImplService>
{
 public:
  explicit UpdaterImplService(const ServiceBuildInfo& bi);
  
  ~UpdaterImplService();

 public:
  Real f1(UpdaterImplF1Vars& vars, const Real a=1.0) override;
  Real f2(UpdaterImplF2Vars& vars, const Real a=1.0, const Integer b=25) override;
  Real f3(UpdaterImplF3Vars& vars, const Real a, const Integer b, const bool c=true) override;
  Real fWithReturn(UpdaterImplFWithReturnVars& vars) override;
  void fWithOut(UpdaterImplFWithOutVars& vars, Real& a) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace ParameterDefaultValueVarAsArgs

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PARAMETERDEFAULTVALUE_VARASARGS_UPDATERIMPLSERVICE_H
