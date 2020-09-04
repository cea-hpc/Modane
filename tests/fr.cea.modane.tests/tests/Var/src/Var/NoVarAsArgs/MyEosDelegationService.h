#ifndef VAR_NOVARASARGS_MYEOSDELEGATIONSERVICE_H
#define VAR_NOVARASARGS_MYEOSDELEGATIONSERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Var/NoVarAsArgs/__MyEosDelegationServiceBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace VarNoVarAsArgs {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service MyEosDelegation : implémentation
 * 
 */
class MyEosDelegationService
: public MyEosDelegationServiceBase<MyEosDelegationService>
{
 public:
  explicit MyEosDelegationService(const ServiceBuildInfo& bi);
  ~MyEosDelegationService();

 public:
  void apply(const Real coef) override;
  void applyWithSupport(const Cell cell, const Real coef) override;
  //void applyWithItemVertex([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemLine2([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemTriangle3([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemQuad4([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemPentagon5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemHexagon6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemTetraedron4([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemPyramid5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemPentaedron6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemHexaedron8([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemHeptaedron10([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemOctaedron12([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemHemiHexa7([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemHemiHexa6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemHemiHexa5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemAntiWedgeLeft6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemAntiWedgeRight6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemDiTetra5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemDualNode([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemDualEdge([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemDualFace([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemDualCell([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
  //void applyWithItemLink([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace VarNoVarAsArgs

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // VAR_NOVARASARGS_MYEOSDELEGATIONSERVICE_H
