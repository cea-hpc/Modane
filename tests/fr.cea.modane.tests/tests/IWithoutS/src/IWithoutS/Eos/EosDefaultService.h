#ifndef IWITHOUTS_EOS_EOSDEFAULTSERVICE_H
#define IWITHOUTS_EOS_EOSDEFAULTSERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "IWithoutS/Eos/__EosDefaultServiceBase.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace IWithoutSEos {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service IWithoutS.Eos.EosDefault : implémentation
 * Service par défaut pour l'interface IWithoutS.Eos.Eos
 */
class EosDefaultService
: public EosDefaultServiceBase<EosDefaultService>
{
 public:
  explicit EosDefaultService(const ServiceBuildInfo& bi);
  ~EosDefaultService();

 public:
  void computeSequential(const Cell cell, EosDefaultComputeSequentialVars& vars, const Real coef) override;
  void computeParallel(const Cell cell, EosDefaultComputeParallelVars& vars, const Real coef) override;
  //void computeByItemTypeVertex(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypeLine2(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypeTriangle3(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypeQuad4(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypePentagon5(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypeHexagon6(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypeTetraedron4(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypePyramid5(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypePentaedron6(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  void computeByItemTypeHexaedron8(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypeHeptaedron10(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypeOctaedron12(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypeHemiHexa7(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypeHemiHexa6(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypeHemiHexa5(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypeAntiWedgeLeft6(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypeAntiWedgeRight6(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypeDiTetra5(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypeDualNode(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypeDualEdge(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypeDualFace(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypeDualCell(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  //void computeByItemTypeLink(ItemVectorView items, EosDefaultComputeByItemTypeVars& vars, const Real coef) override;
  void computeByEnvCell(const EnvCell envcell, EosDefaultComputeByEnvCellVars& vars, const Real coef) override;
  void computeByMatCell(const MatCell matcell, EosDefaultComputeByMatCellVars& vars, const Real coef) override;
  Integer getSequentialCpt(EosDefaultGetSequentialCptVars& vars) override;
  Integer getParallelCpt(EosDefaultGetParallelCptVars& vars) override;
  Integer getItemTypeCpt(EosDefaultGetItemTypeCptVars& vars) override;

 private:
	Integer m_sequential_cpt;
	Integer m_item_type_cpt;
	AtomicInt32 m_parallel_cpt;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSEos

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_EOS_EOSDEFAULTSERVICE_H
