#include "IWithoutS/Eos/EosDefaultService.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace IWithoutSEos {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

EosDefaultService::
EosDefaultService(const ServiceBuildInfo & sbi)
: EosDefaultServiceBase<EosDefaultService>(sbi)
{
	m_sequential_cpt = 0;
	m_item_type_cpt = 0;
	m_parallel_cpt = 0;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

EosDefaultService::
~EosDefaultService()
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void EosDefaultService::
computeSequential(const Cell cell, EosDefaultComputeSequentialVars& vars, const Real coef)
{
	++m_sequential_cpt;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void EosDefaultService::
computeParallel(const Cell cell, EosDefaultComputeParallelVars& vars, const Real coef)
{
	++m_parallel_cpt;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

//void EosDefaultService::computeByItemTypeVertex(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypeLine2(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypeTriangle3(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypeQuad4(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypePentagon5(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypeHexagon6(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypeTetraedron4(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypePyramid5(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypePentaedron6(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}

void EosDefaultService::
computeByItemTypeHexaedron8(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef)
{
	m_item_type_cpt += items.size();
}

//void EosDefaultService::computeByItemTypeHeptaedron10(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypeOctaedron12(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypeHemiHexa7(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypeHemiHexa6(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypeHemiHexa5(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypeAntiWedgeLeft6(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypeAntiWedgeRight6(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypeDiTetra5(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypeDualNode(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypeDualEdge(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypeDualFace(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypeDualCell(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}
//void EosDefaultService::computeByItemTypeLink(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) {}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void EosDefaultService::
computeByEnvCell(const EnvCell envcell, EosDefaultComputeByEnvCellVars& vars, const Real coef)
{
	throw NotImplementedException(A_FUNCINFO);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void EosDefaultService::
computeByMatCell(const MatCell matcell, EosDefaultComputeByMatCellVars& vars, const Real coef)
{
	throw NotImplementedException(A_FUNCINFO);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

Integer EosDefaultService::
getParallelCpt(EosDefaultGetParallelCptVars& vars)
{
	return m_parallel_cpt.value();
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

Integer EosDefaultService::
getSequentialCpt(EosDefaultGetSequentialCptVars& vars)
{
	return m_sequential_cpt;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

Integer EosDefaultService::
getItemTypeCpt(EosDefaultGetItemTypeCptVars& vars)
{
	return m_item_type_cpt;
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ARCANE_REGISTER_SERVICE_EOSDEFAULT(EosDefault, EosDefaultService);

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace IWithoutSEos
