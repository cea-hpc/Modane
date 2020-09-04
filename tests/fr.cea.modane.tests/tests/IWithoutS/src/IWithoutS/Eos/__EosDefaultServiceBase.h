#ifndef IWITHOUTS_EOS___EOSDEFAULTSERVICEBASE_H
#define IWITHOUTS_EOS___EOSDEFAULTSERVICEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "arcane/materials/ComponentItemVector.h"
#include "arcane/materials/ComponentItemVectorView.h"
#include "arcane/materials/MeshEnvironmentVariableRef.h"
#include "arcane/materials/MeshMaterialVariableRef.h"
#include "arcane/materials/IMeshMaterialMng.h"
#include "arcane/utils/NotImplementedException.h"
#include "arcane/Concurrency.h"
#include "IWithoutS/Eos/__IEos.h"
#include "IWithoutS/Eos/__EosDefaultServiceVars.h"
#include "IWithoutS/Eos/__EosDefaultComputeByItemType.h"
#include "IWithoutS/Eos/EosDefault_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace IWithoutSEos {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service EosDefault : classe de base. 
 * Service par défaut pour l'interface Eos
 */
template<class T>
class EosDefaultServiceBase
: public ArcaneEosDefaultObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit EosDefaultServiceBase(const ServiceBuildInfo& bi)
  : ArcaneEosDefaultObject(bi)
  , m_mesh_material_mng(IMeshMaterialMng::getReference(bi.mesh()))
  {
  }

  virtual ~EosDefaultServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  Real getMyBidonOption() { return options()->getMyBidonOption(); }
  bool hasMyBidonOption() const { return options()->hasMyBidonOption(); }
  const String getImplName() const { return "EosDefaultService"; }
  IMeshMaterialMng* getMeshMaterialMng() const { return m_mesh_material_mng; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle EosDefaultService::computeSequential.
  */
  void computeSequential(const CellVectorView items, const Real coef) override
  {
    EosDefaultComputeSequentialVars vars;
    T* t = static_cast<T*>(this);
    ENUMERATE_CELL (iitem, items) {
      const Cell item = *iitem;
      t->computeSequential(item, vars, coef);
    }
  }

  /*!
   Cette méthode construit les variables et appelle EosDefaultService::computeParallel.
  */
  void computeParallel(const CellVectorView items, const Real coef) override
  {
    EosDefaultComputeParallelVars vars;
    T* t = static_cast<T*>(this);
    Parallel::Foreach(items, [&](CellVectorView sub_items)
    {
      ENUMERATE_CELL (iitem, sub_items) {
        const Cell item = *iitem;
        t->computeParallel(item, vars, coef);
      }
    });
  }

  /*!
   Cette méthode construit les variables et appelle EosDefaultService::computeByItemType.
  */
  void computeByItemType(const ItemGroup& items, const Real coef) override
  {
    EosDefaultComputeByItemTypeVars vars;
    T* t = static_cast<T*>(this);
    EosDefaultComputeByItemType<T> fclass(t, vars, coef); 
    items.applyOperation(&fclass);
  }

  /*!
   Cette méthode construit les variables et appelle EosDefaultService::computeByEnvCell.
  */
  void computeByEnvCell(const EnvCellVectorView items, const Real coef) override
  {
    EosDefaultComputeByEnvCellVars vars;
    T* t = static_cast<T*>(this);
    ENUMERATE_ENVCELL (iitem, items) {
      const EnvCell item = *iitem;
      t->computeByEnvCell(item, vars, coef);
    }
  }

  /*!
   Cette méthode construit les variables et appelle EosDefaultService::computeByMatCell.
  */
  void computeByMatCell(const MatCellVectorView items, const Real coef) override
  {
    EosDefaultComputeByMatCellVars vars;
    T* t = static_cast<T*>(this);
    ENUMERATE_MATCELL (iitem, items) {
      const MatCell item = *iitem;
      t->computeByMatCell(item, vars, coef);
    }
  }

  /*!
   Cette méthode construit les variables et appelle EosDefaultService::getSequentialCpt.
  */
  Integer getSequentialCpt() override
  {
    EosDefaultGetSequentialCptVars vars;
    return this->getSequentialCpt(vars);
  }

  /*!
   Cette méthode construit les variables et appelle EosDefaultService::getParallelCpt.
  */
  Integer getParallelCpt() override
  {
    EosDefaultGetParallelCptVars vars;
    return this->getParallelCpt(vars);
  }

  /*!
   Cette méthode construit les variables et appelle EosDefaultService::getItemTypeCpt.
  */
  Integer getItemTypeCpt() override
  {
    EosDefaultGetItemTypeCptVars vars;
    return this->getItemTypeCpt(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void computeSequential(const Cell cell, EosDefaultComputeSequentialVars& vars, const Real coef) = 0;
  virtual void computeParallel(const Cell cell, EosDefaultComputeParallelVars& vars, const Real coef) = 0;
  virtual void computeByItemTypeVertex([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeLine2([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeTriangle3([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeQuad4([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypePentagon5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHexagon6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeTetraedron4([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypePyramid5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypePentaedron6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHexaedron8([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHeptaedron10([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeOctaedron12([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHemiHexa7([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHemiHexa6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHemiHexa5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeAntiWedgeLeft6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeAntiWedgeRight6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDiTetra5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDualNode([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDualEdge([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDualFace([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDualCell([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeLink([[maybe_unused]] ItemVectorView items, [[maybe_unused]] EosDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByEnvCell(const EnvCell envcell, EosDefaultComputeByEnvCellVars& vars, const Real coef) = 0;
  virtual void computeByMatCell(const MatCell matcell, EosDefaultComputeByMatCellVars& vars, const Real coef) = 0;
  virtual Integer getSequentialCpt(EosDefaultGetSequentialCptVars& vars) = 0;
  virtual Integer getParallelCpt(EosDefaultGetParallelCptVars& vars) = 0;
  virtual Integer getItemTypeCpt(EosDefaultGetItemTypeCptVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
  IMeshMaterialMng* m_mesh_material_mng;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSEos

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_EOS___EOSDEFAULTSERVICEBASE_H
