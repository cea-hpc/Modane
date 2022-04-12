#ifndef PARAMETERDEFAULTVALUE_HYDROMODULE_H
#define PARAMETERDEFAULTVALUE_HYDROMODULE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "ParameterDefaultValue/__HydroModuleBase.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace ParameterDefaultValue {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Module ParameterDefaultValue.Hydro : implémentation
 * 
 */
class HydroModule
: public HydroModuleBase<HydroModule>
{
 public:
  explicit HydroModule(const ModuleBuildInfo& bi);
  
  ~HydroModule();

 public:
  void compute(HydroComputeVars& vars) override;
  void computeWithMyStruct(HydroComputeWithMyStructVars& vars, const IMyStruct* my_struct=nullptr) override;
  void computeWithString(HydroComputeWithStringVars& vars, const String my_string="ficelle") override;

 private:
  void compare(Real expected, Real actual)
  {
	  if (actual != expected)
		  fatal() << "ERREUR " << actual << " != " << expected;
  }
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace ParameterDefaultValue

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PARAMETERDEFAULTVALUE_HYDROMODULE_H
