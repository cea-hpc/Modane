#ifndef STIFFENED_GAS_SERVICE_H
#define STIFFENED_GAS_SERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "MicroHydro/Eos/__StiffenedGasServiceBase.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace MicroHydroEos {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Classe d'implémentation du service StiffenedGas
 *
 * 
 */
class StiffenedGasService
: public StiffenedGasServiceBase<StiffenedGasService>
{
 public:
	StiffenedGasService(const ServiceBuildInfo& sbi);
	~StiffenedGasService();

 public:
	/** Commentaire pour vérifier que le lien Doxygen sur le graphe depuis IEquationOfState fonctionne. */
	void initEOS(const Cell cell, StiffenedGasInitEOSVars& vars);
	void applyEOS(const Cell cell, StiffenedGasApplyEOSVars& vars);
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace MicroHydroEos

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif /* STIFFENED_GAS_SERVICE_H */
