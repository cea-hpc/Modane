#include "MicroHydro/Eos/PerfectGasService.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace MicroHydroEos {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

PerfectGasService::
PerfectGasService(const ServiceBuildInfo & sbi)
: PerfectGasServiceBase<PerfectGasService>(sbi)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

PerfectGasService::
~PerfectGasService()
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void PerfectGasService::
initEOS(const Cell cell, PerfectGasInitEOSVars& vars)
{
	  Real pressure = vars.m_pressure[cell];
	  Real adiabatic_cst = vars.m_adiabatic_cst[cell];
	  Real density = vars.m_density[cell];
	  vars.m_internal_energy[cell] = pressure / ((adiabatic_cst - 1.) * density);
	  vars.m_sound_speed[cell] = sqrt(adiabatic_cst * pressure / density);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void PerfectGasService::
applyEOS(const Cell cell, PerfectGasApplyEOSVars& vars)
{
	  Real internal_energy = vars.m_internal_energy[cell];
	  Real density = vars.m_density[cell];
	  Real adiabatic_cst = vars.m_adiabatic_cst[cell];
	  Real pressure = (adiabatic_cst - 1.) * density * internal_energy;
	  vars.m_pressure[cell] = pressure;
	  vars.m_sound_speed[cell] = sqrt(adiabatic_cst * pressure / density);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ARCANE_REGISTER_SERVICE_PERFECTGAS(PerfectGas, PerfectGasService);

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace MicroHydroEos
