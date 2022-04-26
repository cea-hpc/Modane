#include "PtyOnInterface/__IEos.h"
#include "PtyOnInterface/__IMyStruct.h"
#include "PtyOnInterface/__IMyInterf.h"
#include "PtyOnInterface/HydroModule.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace PtyOnInterface {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

HydroModule::
HydroModule(const ModuleBuildInfo & mbi)
: HydroModuleBase<HydroModule>(mbi)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

HydroModule::
~HydroModule()
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void HydroModule::
compute(HydroComputeVars& vars)
{
	IEos* eos = options()->eos();

	compare(eos->getMyReal(), 12.35);
	compare(eos->getMyStruct()->getR(), 35.26);
	compare(eos->getMyInterf()->getR(), 48.15);
	compare(eos->getMyInterf()->getS()->getR(), 18.35);

	Real index = 35.0;
	for (int i = 0 ; i < eos->getMyStructs().size() ; ++i)
		compare(eos->getMyStructs()[i]->getR(), index+i);

	for (int i = 0 ; i < eos->getMyIntegers().size() ; ++i)
		compare(eos->getMyIntegers()[i], 1+i);


}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ARCANE_REGISTER_MODULE_HYDRO(HydroModule);

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace PtyOnInterface
