#ifndef PTYONINTERFACE_HYDROMODULE_H
#define PTYONINTERFACE_HYDROMODULE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "PtyOnInterface/__HydroModuleBase.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace PtyOnInterface {

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

private:
	template<class T> void compare(T found, T expected)
	{
		if (found != expected)
			fatal() << "Expected: " << expected << ", Found: " << found;
	};

};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace PtyOnInterface

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif /* PTYONINTERFACE_HYDROMODULE_H */
