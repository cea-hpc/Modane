#include "Var/NoVarAsArgs/MyEosDelegationService.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace VarNoVarAsArgs {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

MyEosDelegationService::
MyEosDelegationService(const ServiceBuildInfo& bi)
: MyEosDelegationServiceBase<MyEosDelegationService>(bi)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

MyEosDelegationService::
~MyEosDelegationService()
{
}
	

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void MyEosDelegationService::
apply(const Real coef)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void MyEosDelegationService::
applyWithSupport(const Cell cell, const Real coef)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

//void MyEosDelegationService::applyWithItemVertex(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemLine2(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemTriangle3(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemQuad4(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemPentagon5(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemHexagon6(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemTetraedron4(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemPyramid5(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemPentaedron6(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemHexaedron8(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemHeptaedron10(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemOctaedron12(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemHemiHexa7(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemHemiHexa6(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemHemiHexa5(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemAntiWedgeLeft6(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemAntiWedgeRight6(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemDiTetra5(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemDualNode(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemDualEdge(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemDualFace(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemDualCell(ItemVectorView items, const Real coef) {}
//void MyEosDelegationService::applyWithItemLink(ItemVectorView items, const Real coef) {}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ARCANE_REGISTER_SERVICE_MYEOSDELEGATION(MyEosDelegation, MyEosDelegationService);

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace VarNoVarAsArgs
