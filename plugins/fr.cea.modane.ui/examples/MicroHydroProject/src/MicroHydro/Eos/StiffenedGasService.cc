#include "MicroHydro/Eos/StiffenedGasService.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace MicroHydroEos {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

StiffenedGasService::
StiffenedGasService(const ServiceBuildInfo & sbi)
: StiffenedGasServiceBase<StiffenedGasService>(sbi)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

StiffenedGasService::
~StiffenedGasService()
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void StiffenedGasService::
initEOS(const Cell cell, StiffenedGasInitEOSVars& vars)
{
	  Real pressure = vars.m_pressure[cell];
	  Real adiabatic_cst = vars.m_adiabatic_cst[cell];
	  Real density = vars.m_density[cell];
	  vars.m_internal_energy[cell] = (pressure + (adiabatic_cst * options()->limitTension())) / ((adiabatic_cst - 1.) * density);
	  vars.m_sound_speed[cell] = sqrt((adiabatic_cst/density)*(pressure+options()->limitTension()));
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void StiffenedGasService::
applyEOS(const Cell cell, StiffenedGasApplyEOSVars& vars)
{
	  Real internal_energy = vars.m_internal_energy[cell];
	  Real density = vars.m_density[cell];
	  Real adiabatic_cst = vars.m_adiabatic_cst[cell];
	  Real pressure = ((adiabatic_cst- 1.) * density * internal_energy) - (adiabatic_cst * options()->limitTension());
	  vars.m_pressure[cell] = pressure;
	  vars.m_sound_speed[cell] = sqrt((adiabatic_cst/density)*(pressure+options()->limitTension()));
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ARCANE_REGISTER_SERVICE_STIFFENEDGAS(StiffenedGas, StiffenedGasService);

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace MicroHydroEos
