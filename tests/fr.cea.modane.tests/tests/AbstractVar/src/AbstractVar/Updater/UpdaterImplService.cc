#include "AbstractVar/Updater/UpdaterImplService.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;

namespace AbstractVarUpdater {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

UpdaterImplService::
UpdaterImplService(const ServiceBuildInfo & sbi)
: UpdaterImplServiceBase<UpdaterImplService>(sbi)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

UpdaterImplService::
~UpdaterImplService()
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void UpdaterImplService::
updatePressure(UpdaterImplUpdatePressureVars& vars)
{
	ENUMERATE_CELL(icell, allCells()) {
		vars.m_abstract_pressure[icell] = 2.3;
	}
}


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void UpdaterImplService::
updatePressureWithParam(UpdaterImplUpdatePressureWithParamVars& vars, const Real alpha)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void UpdaterImplService::
updateOldPressure(UpdaterImplUpdateOldPressureVars& vars)
{
	ENUMERATE_CELL(icell, allCells()) {
		vars.m_old_pressure[icell] = 2.3;
	}
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void UpdaterImplService::
update(UpdaterImplUpdateVars& vars, const Real alpha)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ARCANE_REGISTER_SERVICE_UPDATERIMPL(UpdaterImpl, UpdaterImplService);

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace AbstractVarUpdater
