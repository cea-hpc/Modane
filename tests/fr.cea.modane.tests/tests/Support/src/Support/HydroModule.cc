#include <arcane/ServiceBuilder.h>
#include "Support/HydroModule.h"
#include "Support/Eos/__IEos.h"


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace SupportEos;
namespace Support {

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

/*
 * Méthodes appelées par compute :
 *   - Eos::computeSequential
 *   - Eos::computeParallel
 *   - Eos::computeByItemType
 */
void HydroModule::
compute(HydroComputeVars& vars)
{
	// IEos* eos = options()->eos();
//	IServiceMng* sm = subDomain()->serviceMng();
//	IEos* eos = ServiceFinderT<IEos>(sm).findSingleton();

	IEos* eos = ServiceBuilder<IEos>(subDomain()).getSingleton();

	eos->computeSequential(allCells().view(), 4.);
	eos->computeParallel(allCells().view(), 4.);
	eos->computeByItemType(allCells(), 4.);
	//eos->computeByMatCellSequential(allCells(), 4.);
	//eos->computeByMatCellParallel(allCells(), 4.);
	//eos->computeByComponentCellParallel(allCells(), 4.);

	info() << "Valeur sequentielle " << eos->getSequentialCpt();
	info() << "Valeur par item " << eos->getItemTypeCpt();
	info() << "Valeur parallele " << eos->getParallelCpt();
	if (eos->getSequentialCpt() != eos->getItemTypeCpt()
			|| eos->getItemTypeCpt() != eos->getParallelCpt()) exit(4444);

}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ARCANE_REGISTER_MODULE_HYDRO(HydroModule);

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace Support
