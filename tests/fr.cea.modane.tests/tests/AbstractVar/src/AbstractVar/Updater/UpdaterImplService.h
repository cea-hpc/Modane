#ifndef ABSTRACTVAR_UPDATER_UPDATERIMPLSERVICE_H
#define ABSTRACTVAR_UPDATER_UPDATERIMPLSERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "AbstractVar/Updater/__UpdaterImplServiceBase.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;

namespace AbstractVarUpdater {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Classe d'implémentation du service UpdaterImpl
 *
 * 
 */
class UpdaterImplService
: public UpdaterImplServiceBase<UpdaterImplService>
{
 public:
	UpdaterImplService(const ServiceBuildInfo& sbi);
	~UpdaterImplService();

 public:
	void updatePressure(UpdaterImplUpdatePressureVars& vars);
	void updatePressureWithParam(UpdaterImplUpdatePressureWithParamVars& vars, const Real alpha);
	void updateOldPressure(UpdaterImplUpdateOldPressureVars& vars);
	void update(UpdaterImplUpdateVars& vars, const Real alpha);
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace AbstractVarUpdater

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif /* ABSTRACTVAR_UPDATER_UPDATERIMPLSERVICE_H */
