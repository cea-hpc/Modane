#ifndef INHERITANCE_HYDROMODULE_H
#define INHERITANCE_HYDROMODULE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Inheritance/__HydroModuleBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace Inheritance {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Module Hydro : implémentation
 * Mon module Hydro
 */
class HydroModule
: public HydroModuleBase<HydroModule>
{
 public:
  explicit HydroModule(const ModuleBuildInfo& bi);
  ~HydroModule();

 public:
  void compute(HydroComputeVars& vars) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Inheritance

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // INHERITANCE_HYDROMODULE_H
