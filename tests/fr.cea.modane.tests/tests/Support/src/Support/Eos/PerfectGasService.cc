#include "Support/Eos/PerfectGasService.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace SupportEos {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

PerfectGasService::
PerfectGasService(const ServiceBuildInfo& bi)
: PerfectGasServiceBase<PerfectGasService>(bi)
{
	m_sequential_cpt = 0;
	m_item_type_cpt = 0;
	m_parallel_cpt = 0;
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
computeSequential(const Cell cell, PerfectGasComputeSequentialVars& vars, const Real coef)
{
	++m_sequential_cpt;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void PerfectGasService::
computeParallel(const Cell cell, PerfectGasComputeParallelVars& vars, const Real coef)
{
	++m_parallel_cpt;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void PerfectGasService::
computeByItemTypeHexaedron8(ItemVectorView items, PerfectGasComputeByItemTypeVars& vars, const Real coef)
{
	m_item_type_cpt += items.size();
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void PerfectGasService::
computeByMatCell(const MatCell matcell, PerfectGasComputeByMatCellVars& vars, const Real coef)
{
	throw NotImplementedException(A_FUNCINFO);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void PerfectGasService::
computeByEnvCell(const EnvCell envcell, PerfectGasComputeByEnvCellVars& vars, const Real coef)
{
	throw NotImplementedException(A_FUNCINFO);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void PerfectGasService::
computeByComponentCell(const ComponentCell componentcell, PerfectGasComputeByComponentCellVars& vars, const Real coef)
{
	throw NotImplementedException(A_FUNCINFO);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void PerfectGasService::
computeByAllEnvCell(const AllEnvCell allenvcell, PerfectGasComputeByAllEnvCellVars& vars, const Real coef)
{
	throw NotImplementedException(A_FUNCINFO);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void PerfectGasService::
computeByParticle(const Particle particle, PerfectGasComputeByParticleVars& vars, const Real coef)
{
	throw NotImplementedException(A_FUNCINFO);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void PerfectGasService::
computeByDof(const DoF dof, PerfectGasComputeByDofVars& vars, const Real coef)
{
	throw NotImplementedException(A_FUNCINFO);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

Integer PerfectGasService::
getParallelCpt(PerfectGasGetParallelCptVars& vars)
{
	return m_parallel_cpt.value();
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

Integer PerfectGasService::
getSequentialCpt(PerfectGasGetSequentialCptVars& vars)
{
	return m_sequential_cpt;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

Integer PerfectGasService::
getItemTypeCpt(PerfectGasGetItemTypeCptVars& vars)
{
	return m_item_type_cpt;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ARCANE_REGISTER_SERVICE_PERFECTGAS(PerfectGas, PerfectGasService);

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace SupportEos
