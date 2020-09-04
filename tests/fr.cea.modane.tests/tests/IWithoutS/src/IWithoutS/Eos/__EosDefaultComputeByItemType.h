#ifndef IWITHOUTS_EOS___EOSDEFAULTCOMPUTEBYITEMTYPE_H
#define IWITHOUTS_EOS___EOSDEFAULTCOMPUTEBYITEMTYPE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/AbstractItemOperationByBasicType.h"
#include "arcane/Item.h"
#include "IWithoutS/Eos/__EosDefaultServiceVars.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace IWithoutSEos {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

//! Classe portant le code de l'opération computeByItemType spécialisée par type d'item.
template <class T>
class EosDefaultComputeByItemType
: public AbstractItemOperationByBasicType
{
  public:
    explicit EosDefaultComputeByItemType(T* srv, EosDefaultComputeByItemTypeVars& vars, const Real coef)
	: m_srv(srv)
	, m_vars(vars)
	, m_coef(coef)
	{
	}
    ~EosDefaultComputeByItemType() {};

  public:
    void applyVertex(ItemVectorView items) override { m_srv->computeByItemTypeVertex(items, m_vars, m_coef); }
    void applyLine2(ItemVectorView items) override { m_srv->computeByItemTypeLine2(items, m_vars, m_coef); }
    void applyTriangle3(ItemVectorView items) override { m_srv->computeByItemTypeTriangle3(items, m_vars, m_coef); }
    void applyQuad4(ItemVectorView items) override { m_srv->computeByItemTypeQuad4(items, m_vars, m_coef); }
    void applyPentagon5(ItemVectorView items) override { m_srv->computeByItemTypePentagon5(items, m_vars, m_coef); }
    void applyHexagon6(ItemVectorView items) override { m_srv->computeByItemTypeHexagon6(items, m_vars, m_coef); }
    void applyTetraedron4(ItemVectorView items) override { m_srv->computeByItemTypeTetraedron4(items, m_vars, m_coef); }
    void applyPyramid5(ItemVectorView items) override { m_srv->computeByItemTypePyramid5(items, m_vars, m_coef); }
    void applyPentaedron6(ItemVectorView items) override { m_srv->computeByItemTypePentaedron6(items, m_vars, m_coef); }
    void applyHexaedron8(ItemVectorView items) override { m_srv->computeByItemTypeHexaedron8(items, m_vars, m_coef); }
    void applyHeptaedron10(ItemVectorView items) override { m_srv->computeByItemTypeHeptaedron10(items, m_vars, m_coef); }
    void applyOctaedron12(ItemVectorView items) override { m_srv->computeByItemTypeOctaedron12(items, m_vars, m_coef); }
    void applyHemiHexa7(ItemVectorView items) override { m_srv->computeByItemTypeHemiHexa7(items, m_vars, m_coef); }
    void applyHemiHexa6(ItemVectorView items) override { m_srv->computeByItemTypeHemiHexa6(items, m_vars, m_coef); }
    void applyHemiHexa5(ItemVectorView items) override { m_srv->computeByItemTypeHemiHexa5(items, m_vars, m_coef); }
    void applyAntiWedgeLeft6(ItemVectorView items) override { m_srv->computeByItemTypeAntiWedgeLeft6(items, m_vars, m_coef); }
    void applyAntiWedgeRight6(ItemVectorView items) override { m_srv->computeByItemTypeAntiWedgeRight6(items, m_vars, m_coef); }
    void applyDiTetra5(ItemVectorView items) override { m_srv->computeByItemTypeDiTetra5(items, m_vars, m_coef); }
    void applyDualNode(ItemVectorView items) override { m_srv->computeByItemTypeDualNode(items, m_vars, m_coef); }
    void applyDualEdge(ItemVectorView items) override { m_srv->computeByItemTypeDualEdge(items, m_vars, m_coef); }
    void applyDualFace(ItemVectorView items) override { m_srv->computeByItemTypeDualFace(items, m_vars, m_coef); }
    void applyDualCell(ItemVectorView items) override { m_srv->computeByItemTypeDualCell(items, m_vars, m_coef); }
    void applyLink(ItemVectorView items) override { m_srv->computeByItemTypeLink(items, m_vars, m_coef); }

  private:
    T* m_srv;
    EosDefaultComputeByItemTypeVars m_vars;
    const Real m_coef;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSEos

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_EOS___EOSDEFAULTCOMPUTEBYITEMTYPE_H
