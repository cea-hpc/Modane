#ifndef IWITHOUTS_HYDROMODULE_H
#define IWITHOUTS_HYDROMODULE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "IWithoutS/__HydroModuleBase.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace IWithoutS {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Classe d'implémentation du module Hydro
 *
 * 
 */
class HydroModule
: public HydroModuleBase<HydroModule>
{
 public:
	HydroModule(const ModuleBuildInfo& mbi);
	~HydroModule();

 protected:
	void computeEos(HydroComputeEosVars& vars);
	void computeNoPropertyInterf(HydroComputeNoPropertyInterfVars& vars);
	void computeRefPropertyInterf(HydroComputeRefPropertyInterfVars& vars);
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace IWithoutS

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif /* IWITHOUTS_HYDROMODULE_H */
