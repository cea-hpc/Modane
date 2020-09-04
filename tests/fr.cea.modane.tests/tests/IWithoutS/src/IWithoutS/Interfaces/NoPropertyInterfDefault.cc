#include "IWithoutS/Interfaces/NoPropertyInterfDefault.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace IWithoutSInterfaces {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

NoPropertyInterfDefault::
NoPropertyInterfDefault(IMesh* mesh)
: NoPropertyInterfDefaultBase<NoPropertyInterfDefault>(mesh)
{
	m_sequential_cpt = 0;
	m_item_type_cpt = 0;
	m_parallel_cpt = 0;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

NoPropertyInterfDefault::
~NoPropertyInterfDefault()
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void NoPropertyInterfDefault::
computeSequential(const Cell cell, NoPropertyInterfDefaultComputeSequentialVars& vars, const Real coef)
{
	++m_sequential_cpt;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void NoPropertyInterfDefault::
computeParallel(const Cell cell, NoPropertyInterfDefaultComputeParallelVars& vars, const Real coef)
{
	++m_parallel_cpt;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void NoPropertyInterfDefault::
computeByItemTypeHexaedron8(ItemVectorView items, NoPropertyInterfDefaultComputeByItemTypeVars& vars, const Real coef)
{
	m_item_type_cpt += items.size();
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void NoPropertyInterfDefault::
computeByEnvCell(const EnvCell envcell, NoPropertyInterfDefaultComputeByEnvCellVars& vars, const Real coef)
{
	throw NotImplementedException(A_FUNCINFO);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void NoPropertyInterfDefault::
computeByMatCell(const MatCell matcell, NoPropertyInterfDefaultComputeByMatCellVars& vars, const Real coef)
{
	throw NotImplementedException(A_FUNCINFO);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

Integer NoPropertyInterfDefault::
getSequentialCpt(NoPropertyInterfDefaultGetSequentialCptVars& vars)
{
	return m_sequential_cpt;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

Integer NoPropertyInterfDefault::
getParallelCpt(NoPropertyInterfDefaultGetParallelCptVars& vars)
{
	return m_parallel_cpt.value();
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

Integer NoPropertyInterfDefault::
getItemTypeCpt(NoPropertyInterfDefaultGetItemTypeCptVars& vars)
{
	return m_item_type_cpt;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSInterfaces
