#ifndef VAR_NOVARASARGS___MYEOSDELEGATIONAPPLYWITHITEM_H
#define VAR_NOVARASARGS___MYEOSDELEGATIONAPPLYWITHITEM_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/AbstractItemOperationByBasicType.h"
#include "arcane/Item.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace VarNoVarAsArgs {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

//! Classe portant le code de l'opération applyWithItem spécialisée par type d'item.
template <class T>
class MyEosDelegationApplyWithItem
: public AbstractItemOperationByBasicType
{
  public:
    explicit MyEosDelegationApplyWithItem(T* srv, const Real coef)
	: m_srv(srv)
	, m_coef(coef)
	{
	}
    ~MyEosDelegationApplyWithItem() {};

  public:
    void applyVertex(ItemVectorView items) override { m_srv->applyWithItemVertex(items, m_coef); }
    void applyLine2(ItemVectorView items) override { m_srv->applyWithItemLine2(items, m_coef); }
    void applyTriangle3(ItemVectorView items) override { m_srv->applyWithItemTriangle3(items, m_coef); }
    void applyQuad4(ItemVectorView items) override { m_srv->applyWithItemQuad4(items, m_coef); }
    void applyPentagon5(ItemVectorView items) override { m_srv->applyWithItemPentagon5(items, m_coef); }
    void applyHexagon6(ItemVectorView items) override { m_srv->applyWithItemHexagon6(items, m_coef); }
    void applyTetraedron4(ItemVectorView items) override { m_srv->applyWithItemTetraedron4(items, m_coef); }
    void applyPyramid5(ItemVectorView items) override { m_srv->applyWithItemPyramid5(items, m_coef); }
    void applyPentaedron6(ItemVectorView items) override { m_srv->applyWithItemPentaedron6(items, m_coef); }
    void applyHexaedron8(ItemVectorView items) override { m_srv->applyWithItemHexaedron8(items, m_coef); }
    void applyHeptaedron10(ItemVectorView items) override { m_srv->applyWithItemHeptaedron10(items, m_coef); }
    void applyOctaedron12(ItemVectorView items) override { m_srv->applyWithItemOctaedron12(items, m_coef); }
    void applyHemiHexa7(ItemVectorView items) override { m_srv->applyWithItemHemiHexa7(items, m_coef); }
    void applyHemiHexa6(ItemVectorView items) override { m_srv->applyWithItemHemiHexa6(items, m_coef); }
    void applyHemiHexa5(ItemVectorView items) override { m_srv->applyWithItemHemiHexa5(items, m_coef); }
    void applyAntiWedgeLeft6(ItemVectorView items) override { m_srv->applyWithItemAntiWedgeLeft6(items, m_coef); }
    void applyAntiWedgeRight6(ItemVectorView items) override { m_srv->applyWithItemAntiWedgeRight6(items, m_coef); }
    void applyDiTetra5(ItemVectorView items) override { m_srv->applyWithItemDiTetra5(items, m_coef); }
    void applyDualNode(ItemVectorView items) override { m_srv->applyWithItemDualNode(items, m_coef); }
    void applyDualEdge(ItemVectorView items) override { m_srv->applyWithItemDualEdge(items, m_coef); }
    void applyDualFace(ItemVectorView items) override { m_srv->applyWithItemDualFace(items, m_coef); }
    void applyDualCell(ItemVectorView items) override { m_srv->applyWithItemDualCell(items, m_coef); }
    void applyLink(ItemVectorView items) override { m_srv->applyWithItemLink(items, m_coef); }

  private:
    T* m_srv;
    const Real m_coef;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace VarNoVarAsArgs

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // VAR_NOVARASARGS___MYEOSDELEGATIONAPPLYWITHITEM_H
