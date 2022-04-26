#include "IWithoutS/Eos/__IEos.h"
#include "IWithoutS/__IRefNoPropertyStruct.h"
#include "IWithoutS/Interfaces/__IOutsideServiceInterf.h"
#include "IWithoutS/HydroModule.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace IWithoutSEos;
using namespace Arcane::Materials;
namespace IWithoutS {

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
 * Méthodes appelées par computeEos :
 *   - Eos::computeSequential
 *   - Eos::computeParallel
 *   - Eos::computeByItemType
 */
void HydroModule::
computeEos(HydroComputeEosVars& vars)
{
	IEos* eos = options()->eos();
	eos->computeSequential(allCells().view(), 4.);
	eos->computeParallel(allCells().view(), 4.);
	eos->computeByItemType(allCells(), 4.);
	//eos->computeByMatCellSequential(allCells(), 4.);
	//eos->computeByMatCellParallel(allCells(), 4.);

	info() << "HydroModule.computeEos()";
	info() << "Valeur sequentielle " << eos->getSequentialCpt();
	info() << "Valeur par item " << eos->getItemTypeCpt();
	info() << "Valeur parallele " << eos->getParallelCpt();
	if (eos->getSequentialCpt() != eos->getItemTypeCpt()
			|| eos->getItemTypeCpt() != eos->getParallelCpt())
		exit(4444);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void HydroModule::
computeNoPropertyInterf(HydroComputeNoPropertyInterfVars& vars)
{
	m_no_property_interf->computeSequential(allCells().view(), vars.m_temperature, vars.m_density, 4.);
	m_no_property_interf->computeParallel(allCells().view(), vars.m_temperature, vars.m_density, 4.);
	m_no_property_interf->computeByItemType(allCells(), vars.m_temperature, vars.m_density, 4.);

	info() << "HydroModule.computeNoPropertyInterf()";
	info() << "Valeur sequentielle " << m_no_property_interf->getSequentialCpt();
	info() << "Valeur par item " << m_no_property_interf->getItemTypeCpt();
	info() << "Valeur parallele " << m_no_property_interf->getParallelCpt();
	if (m_no_property_interf->getSequentialCpt() != m_no_property_interf->getItemTypeCpt()
			|| m_no_property_interf->getItemTypeCpt() != m_no_property_interf->getParallelCpt())
		exit(4444);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void HydroModule::
computeRefPropertyInterf(HydroComputeRefPropertyInterfVars& vars)
{
	m_ref_property_interf->compute(vars.m_temperature, vars.m_density);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ARCANE_REGISTER_MODULE_HYDRO(HydroModule);

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace IWithoutS
