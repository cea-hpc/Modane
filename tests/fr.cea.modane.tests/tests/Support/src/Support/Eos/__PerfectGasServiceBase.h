#ifndef SUPPORT_EOS___PERFECTGASSERVICEBASE_H
#define SUPPORT_EOS___PERFECTGASSERVICEBASE_H

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
#include "arcane/materials/MatConcurrency.h"
#include "Support/Eos/__IEos.h"
#include "Support/Eos/__PerfectGasServiceVars.h"
#include "Support/Eos/__PerfectGasComputeByItemType.h"
#include "Support/Eos/PerfectGas_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace SupportEos {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service PerfectGas : classe de base. 
 * 
 */
template<class T>
class PerfectGasServiceBase
: public ArcanePerfectGasObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit PerfectGasServiceBase(const ServiceBuildInfo& bi)
  : ArcanePerfectGasObject(bi)
  , m_mesh_material_mng(IMeshMaterialMng::getReference(bi.mesh()))
  {
  }

  virtual ~PerfectGasServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "PerfectGasService"; }
  IMeshMaterialMng* getMeshMaterialMng() const { return m_mesh_material_mng; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle PerfectGasService::computeSequential.
  */
  void computeSequential(const CellVectorView items, const Real coef) override
  {
    PerfectGasComputeSequentialVars vars;
    T* t = static_cast<T*>(this);
    ENUMERATE_CELL (iitem, items) {
      const Cell item = *iitem;
      t->computeSequential(item, vars, coef);
    }
  }

  /*!
   Cette méthode construit les variables et appelle PerfectGasService::computeParallel.
  */
  void computeParallel(const CellVectorView items, const Real coef) override
  {
    PerfectGasComputeParallelVars vars;
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
   Cette méthode construit les variables et appelle PerfectGasService::computeByItemType.
  */
  void computeByItemType(const ItemGroup& items, const Real coef) override
  {
    PerfectGasComputeByItemTypeVars vars;
    T* t = static_cast<T*>(this);
    PerfectGasComputeByItemType<T> fclass(t, vars, coef); 
    items.applyOperation(&fclass);
  }

  /*!
   Cette méthode construit les variables et appelle PerfectGasService::computeByMatCell.
  */
  void computeByMatCell(const MatCellVectorView items, const Real coef) override
  {
    PerfectGasComputeByMatCellVars vars;
    T* t = static_cast<T*>(this);
    Parallel::Foreach(items, [&](MatCellVectorView sub_items)
    {
      ENUMERATE_MATCELL (iitem, sub_items) {
        const MatCell item = *iitem;
        t->computeByMatCell(item, vars, coef);
      }
    });
  }

  /*!
   Cette méthode construit les variables et appelle PerfectGasService::computeByEnvCell.
  */
  void computeByEnvCell(const EnvCellVectorView items, const Real coef) override
  {
    PerfectGasComputeByEnvCellVars vars;
    T* t = static_cast<T*>(this);
    Parallel::Foreach(items, [&](EnvCellVectorView sub_items)
    {
      ENUMERATE_ENVCELL (iitem, sub_items) {
        const EnvCell item = *iitem;
        t->computeByEnvCell(item, vars, coef);
      }
    });
  }

  /*!
   Cette méthode construit les variables et appelle PerfectGasService::computeByComponentCell.
  */
  void computeByComponentCell(const ComponentCellVectorView items, const Real coef) override
  {
    PerfectGasComputeByComponentCellVars vars;
    T* t = static_cast<T*>(this);
    Parallel::Foreach(items, [&](ComponentCellVectorView sub_items)
    {
      ENUMERATE_COMPONENTCELL (iitem, sub_items) {
        const ComponentCell item = *iitem;
        t->computeByComponentCell(item, vars, coef);
      }
    });
  }

  /*!
   Cette méthode construit les variables et appelle PerfectGasService::computeByAllEnvCell.
  */
  void computeByAllEnvCell(const AllEnvCellVectorView items, const Real coef) override
  {
    PerfectGasComputeByAllEnvCellVars vars;
    T* t = static_cast<T*>(this);
    ENUMERATE_ALLENVCELL (iitem, items) {
      const AllEnvCell item = *iitem;
      t->computeByAllEnvCell(item, vars, coef);
    }
  }

  /*!
   Cette méthode construit les variables et appelle PerfectGasService::computeByParticle.
  */
  void computeByParticle(const ParticleVectorView items, const Real coef) override
  {
    PerfectGasComputeByParticleVars vars;
    T* t = static_cast<T*>(this);
    Parallel::Foreach(items, [&](ParticleVectorView sub_items)
    {
      ENUMERATE_PARTICLE (iitem, sub_items) {
        const Particle item = *iitem;
        t->computeByParticle(item, vars, coef);
      }
    });
  }

  /*!
   Cette méthode construit les variables et appelle PerfectGasService::computeByDof.
  */
  void computeByDof(const DoFVectorView items, const Real coef) override
  {
    PerfectGasComputeByDofVars vars;
    T* t = static_cast<T*>(this);
    Parallel::Foreach(items, [&](DoFVectorView sub_items)
    {
      ENUMERATE_DOF (iitem, sub_items) {
        const DoF item = *iitem;
        t->computeByDof(item, vars, coef);
      }
    });
  }

  /*!
   Cette méthode construit les variables et appelle PerfectGasService::getParallelCpt.
  */
  Integer getParallelCpt() override
  {
    PerfectGasGetParallelCptVars vars;
    return this->getParallelCpt(vars);
  }

  /*!
   Cette méthode construit les variables et appelle PerfectGasService::getSequentialCpt.
  */
  Integer getSequentialCpt() override
  {
    PerfectGasGetSequentialCptVars vars;
    return this->getSequentialCpt(vars);
  }

  /*!
   Cette méthode construit les variables et appelle PerfectGasService::getItemTypeCpt.
  */
  Integer getItemTypeCpt() override
  {
    PerfectGasGetItemTypeCptVars vars;
    return this->getItemTypeCpt(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void computeSequential(const Cell cell, PerfectGasComputeSequentialVars& vars, const Real coef) = 0;
  virtual void computeParallel(const Cell cell, PerfectGasComputeParallelVars& vars, const Real coef) = 0;
  virtual void computeByItemTypeVertex([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeLine2([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeTriangle3([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeQuad4([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypePentagon5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHexagon6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeTetraedron4([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypePyramid5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypePentaedron6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHexaedron8([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHeptaedron10([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeOctaedron12([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHemiHexa7([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHemiHexa6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHemiHexa5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeAntiWedgeLeft6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeAntiWedgeRight6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDiTetra5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDualNode([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDualEdge([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDualFace([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDualCell([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeLink([[maybe_unused]] ItemVectorView items, [[maybe_unused]] PerfectGasComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByMatCell(const MatCell matcell, PerfectGasComputeByMatCellVars& vars, const Real coef) = 0;
  virtual void computeByEnvCell(const EnvCell envcell, PerfectGasComputeByEnvCellVars& vars, const Real coef) = 0;
  virtual void computeByComponentCell(const ComponentCell componentcell, PerfectGasComputeByComponentCellVars& vars, const Real coef) = 0;
  virtual void computeByAllEnvCell(const AllEnvCell allenvcell, PerfectGasComputeByAllEnvCellVars& vars, const Real coef) = 0;
  virtual void computeByParticle(const Particle particle, PerfectGasComputeByParticleVars& vars, const Real coef) = 0;
  virtual void computeByDof(const DoF dof, PerfectGasComputeByDofVars& vars, const Real coef) = 0;
  virtual Integer getParallelCpt(PerfectGasGetParallelCptVars& vars) = 0;
  virtual Integer getSequentialCpt(PerfectGasGetSequentialCptVars& vars) = 0;
  virtual Integer getItemTypeCpt(PerfectGasGetItemTypeCptVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
  IMeshMaterialMng* m_mesh_material_mng;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace SupportEos

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SUPPORT_EOS___PERFECTGASSERVICEBASE_H
