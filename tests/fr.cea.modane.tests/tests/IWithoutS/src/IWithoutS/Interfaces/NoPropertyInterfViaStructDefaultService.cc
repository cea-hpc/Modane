#include "IWithoutS/Interfaces/NoPropertyInterfViaStructDefaultService.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace IWithoutSInterfaces {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

NoPropertyInterfViaStructDefaultService::
NoPropertyInterfViaStructDefaultService(const ServiceBuildInfo& bi)
: NoPropertyInterfViaStructDefaultServiceBase<NoPropertyInterfViaStructDefaultService>(bi)
{
	m_sequential_cpt = 0;
	m_item_type_cpt = 0;
	m_parallel_cpt = 0;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

NoPropertyInterfViaStructDefaultService::
~NoPropertyInterfViaStructDefaultService()
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void NoPropertyInterfViaStructDefaultService::
computeSequential(const Cell cell, NoPropertyInterfViaStructDefaultComputeSequentialVars& vars, const Real coef)
{
	++m_sequential_cpt;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void NoPropertyInterfViaStructDefaultService::
computeParallel(const Cell cell, NoPropertyInterfViaStructDefaultComputeParallelVars& vars, const Real coef)
{
	++m_parallel_cpt;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void NoPropertyInterfViaStructDefaultService::
computeByItemTypeHexaedron8(ItemVectorView items, NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, const Real coef)
{
	m_item_type_cpt += items.size();
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void NoPropertyInterfViaStructDefaultService::
computeByEnvCell(const EnvCell envcell, NoPropertyInterfViaStructDefaultComputeByEnvCellVars& vars, const Real coef)
{
	throw NotImplementedException(A_FUNCINFO);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void NoPropertyInterfViaStructDefaultService::
computeByMatCell(const MatCell matcell, NoPropertyInterfViaStructDefaultComputeByMatCellVars& vars, const Real coef)
{
	throw NotImplementedException(A_FUNCINFO);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

Integer NoPropertyInterfViaStructDefaultService::
getSequentialCpt(NoPropertyInterfViaStructDefaultGetSequentialCptVars& vars)
{
	return m_sequential_cpt;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

Integer NoPropertyInterfViaStructDefaultService::
getParallelCpt(NoPropertyInterfViaStructDefaultGetParallelCptVars& vars)
{
	return m_parallel_cpt.value();
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

Integer NoPropertyInterfViaStructDefaultService::
getItemTypeCpt(NoPropertyInterfViaStructDefaultGetItemTypeCptVars& vars)
{
	return m_item_type_cpt;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ARCANE_REGISTER_SERVICE_NOPROPERTYINTERFVIASTRUCTDEFAULT(NoPropertyInterfViaStructDefault, NoPropertyInterfViaStructDefaultService);

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSInterfaces
