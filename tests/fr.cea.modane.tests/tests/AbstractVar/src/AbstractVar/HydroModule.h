#ifndef ABSTRACTVAR_HYDROMODULE_H
#define ABSTRACTVAR_HYDROMODULE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "AbstractVar/__HydroModuleBase.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;

namespace AbstractVar {

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
	void compute(HydroComputeVars& vars);
	void init(HydroInitVars& vars);
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace AbstractVar

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif /* ABSTRACTVAR_HYDROMODULE_H */
