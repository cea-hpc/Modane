#include "AbstractVar/Updater/__IUpdater.h"
#include "AbstractVar/HydroModule.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace AbstractVarUpdater;

namespace AbstractVar {

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
 *   - Updater::updatePressure
 *   - Updater::updatePressureWithParam
 *   - Updater::updateOldPressure
 */
void HydroModule::
compute(HydroComputeVars& vars)
{
	// appel des fonctions
	IUpdater* updater = options()->updater();
	updater->updateOldPressure();
	updater->updatePressure(vars.m_new_pressure);

	// comparaison du résultat
	ENUMERATE_CELL(icell, allCells()) {
		if (vars.m_old_pressure[icell] != vars.m_new_pressure[icell])
		{
			fatal() << "DIFFERENCE";
		}
	}
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void HydroModule::
init(HydroInitVars& vars)
{
	ENUMERATE_CELL(icell, allCells()) {
		vars.m_old_pressure[icell] = 1.0;
		vars.m_new_pressure[icell] = 1.0;
	}
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ARCANE_REGISTER_MODULE_HYDRO(HydroModule);

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace AbstractVar
