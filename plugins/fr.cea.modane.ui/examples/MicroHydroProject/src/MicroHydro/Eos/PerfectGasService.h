#ifndef PERFECT_GAS_SERVICE_H
#define PERFECT_GAS_SERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "MicroHydro/Eos/__PerfectGasServiceBase.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace MicroHydroEos {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Classe d'implémentation du service PerfectGas
 *
 * 
 */
class PerfectGasService
: public PerfectGasServiceBase<PerfectGasService>
{
 public:
	PerfectGasService(const ServiceBuildInfo& sbi);
	~PerfectGasService();

 public:
	void initEOS(const Cell cell, PerfectGasInitEOSVars& vars);
	void applyEOS(const Cell cell, PerfectGasApplyEOSVars& vars);
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace MicroHydroEos

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif /* PERFECT_GAS_SERVICE_H */
