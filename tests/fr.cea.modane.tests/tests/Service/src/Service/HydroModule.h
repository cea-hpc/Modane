#ifndef SERVICE_HYDROMODULE_H
#define SERVICE_HYDROMODULE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Service/__HydroModuleBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace Service {

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
  void autoLoadCompute(HydroAutoLoadComputeVars& vars) override;
  void giveContribution(HydroGiveContributionVars& vars) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE_HYDROMODULE_H
