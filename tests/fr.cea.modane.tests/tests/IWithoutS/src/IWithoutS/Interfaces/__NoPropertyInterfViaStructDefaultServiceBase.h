#ifndef IWITHOUTS_INTERFACES___NOPROPERTYINTERFVIASTRUCTDEFAULTSERVICEBASE_H
#define IWITHOUTS_INTERFACES___NOPROPERTYINTERFVIASTRUCTDEFAULTSERVICEBASE_H

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
#include "IWithoutS/Interfaces/__INoPropertyInterfViaStruct.h"
#include "IWithoutS/Interfaces/__NoPropertyInterfViaStructDefaultServiceVars.h"
#include "IWithoutS/Interfaces/__NoPropertyInterfViaStructDefaultComputeByItemType.h"
#include "IWithoutS/Interfaces/RefPropertyInterfDefault.h"
#include "IWithoutS/Interfaces/__IRefPropertyInterf.h"
#include "IWithoutS/Interfaces/NoPropertyInterfViaStructDefault_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace IWithoutSInterfaces {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service NoPropertyInterfViaStructDefault : classe de base. 
 * Service par défaut pour l'interface NoPropertyInterfViaStruct
 */
template<class T>
class NoPropertyInterfViaStructDefaultServiceBase
: public ArcaneNoPropertyInterfViaStructDefaultObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit NoPropertyInterfViaStructDefaultServiceBase(const ServiceBuildInfo& bi)
  : ArcaneNoPropertyInterfViaStructDefaultObject(bi)
  , m_mesh_material_mng(IMeshMaterialMng::getReference(bi.mesh()))
  , m_ref_property_interf(new ::IWithoutSInterfaces::RefPropertyInterfDefault(bi.mesh()))
  {
  }

  virtual ~NoPropertyInterfViaStructDefaultServiceBase()
  {
    delete m_ref_property_interf;
  }

 public:  // ***** ACCESSEURS
  IRefPropertyInterf* getRefPropertyInterf() { return m_ref_property_interf; }
  bool hasRefPropertyInterf() const { return true; }
  const String getImplName() const { return "NoPropertyInterfViaStructDefaultService"; }
  IMeshMaterialMng* getMeshMaterialMng() const { return m_mesh_material_mng; }

 public:  // ***** METHODES CONCRETES
  /*!
   \dot
     digraph computeSequentialGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         computeSequential [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="abstract_temperature"];
         inVars -> computeSequential;
         outVars [shape="record", label="abstract_density"];
         computeSequential -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle NoPropertyInterfViaStructDefaultService::computeSequential.
  */
  void computeSequential(const CellVectorView items, const VariableCellReal& abstract_temperature, VariableCellReal& abstract_density, const Real coef) override
  {
    NoPropertyInterfViaStructDefaultComputeSequentialVars vars(abstract_temperature
        , abstract_density);
    T* t = static_cast<T*>(this);
    ENUMERATE_CELL (iitem, items) {
      const Cell item = *iitem;
      t->computeSequential(item, vars, coef);
    }
  }

  /*!
   \dot
     digraph computeParallelGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         computeParallel [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="abstract_temperature"];
         inVars -> computeParallel;
         outVars [shape="record", label="abstract_density"];
         computeParallel -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle NoPropertyInterfViaStructDefaultService::computeParallel.
  */
  void computeParallel(const CellVectorView items, const VariableCellReal& abstract_temperature, VariableCellReal& abstract_density, const Real coef) override
  {
    NoPropertyInterfViaStructDefaultComputeParallelVars vars(abstract_temperature
        , abstract_density);
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
   \dot
     digraph computeByItemTypeGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         computeByItemType [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="abstract_temperature"];
         inVars -> computeByItemType;
         outVars [shape="record", label="abstract_density"];
         computeByItemType -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle NoPropertyInterfViaStructDefaultService::computeByItemType.
  */
  void computeByItemType(const ItemGroup& items, const VariableCellReal& abstract_temperature, VariableCellReal& abstract_density, const Real coef) override
  {
    NoPropertyInterfViaStructDefaultComputeByItemTypeVars vars(abstract_temperature
        , abstract_density);
    T* t = static_cast<T*>(this);
    NoPropertyInterfViaStructDefaultComputeByItemType<T> fclass(t, vars, coef); 
    items.applyOperation(&fclass);
  }

  /*!
   Cette méthode construit les variables et appelle NoPropertyInterfViaStructDefaultService::computeByEnvCell.
  */
  void computeByEnvCell(const EnvCellVectorView items, const Real coef) override
  {
    NoPropertyInterfViaStructDefaultComputeByEnvCellVars vars;
    T* t = static_cast<T*>(this);
    ENUMERATE_ENVCELL (iitem, items) {
      const EnvCell item = *iitem;
      t->computeByEnvCell(item, vars, coef);
    }
  }

  /*!
   Cette méthode construit les variables et appelle NoPropertyInterfViaStructDefaultService::computeByMatCell.
  */
  void computeByMatCell(const MatCellVectorView items, const Real coef) override
  {
    NoPropertyInterfViaStructDefaultComputeByMatCellVars vars;
    T* t = static_cast<T*>(this);
    ENUMERATE_MATCELL (iitem, items) {
      const MatCell item = *iitem;
      t->computeByMatCell(item, vars, coef);
    }
  }

  /*!
   Cette méthode construit les variables et appelle NoPropertyInterfViaStructDefaultService::getSequentialCpt.
  */
  Integer getSequentialCpt() override
  {
    NoPropertyInterfViaStructDefaultGetSequentialCptVars vars;
    return this->getSequentialCpt(vars);
  }

  /*!
   Cette méthode construit les variables et appelle NoPropertyInterfViaStructDefaultService::getParallelCpt.
  */
  Integer getParallelCpt() override
  {
    NoPropertyInterfViaStructDefaultGetParallelCptVars vars;
    return this->getParallelCpt(vars);
  }

  /*!
   Cette méthode construit les variables et appelle NoPropertyInterfViaStructDefaultService::getItemTypeCpt.
  */
  Integer getItemTypeCpt() override
  {
    NoPropertyInterfViaStructDefaultGetItemTypeCptVars vars;
    return this->getItemTypeCpt(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void computeSequential(const Cell cell, NoPropertyInterfViaStructDefaultComputeSequentialVars& vars, const Real coef) = 0;
  virtual void computeParallel(const Cell cell, NoPropertyInterfViaStructDefaultComputeParallelVars& vars, const Real coef) = 0;
  virtual void computeByItemTypeVertex([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeLine2([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeTriangle3([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeQuad4([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypePentagon5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHexagon6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeTetraedron4([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypePyramid5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypePentaedron6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHexaedron8([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHeptaedron10([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeOctaedron12([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHemiHexa7([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHemiHexa6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHemiHexa5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeAntiWedgeLeft6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeAntiWedgeRight6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDiTetra5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDualNode([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDualEdge([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDualFace([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDualCell([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeLink([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByEnvCell(const EnvCell envcell, NoPropertyInterfViaStructDefaultComputeByEnvCellVars& vars, const Real coef) = 0;
  virtual void computeByMatCell(const MatCell matcell, NoPropertyInterfViaStructDefaultComputeByMatCellVars& vars, const Real coef) = 0;
  virtual Integer getSequentialCpt(NoPropertyInterfViaStructDefaultGetSequentialCptVars& vars) = 0;
  virtual Integer getParallelCpt(NoPropertyInterfViaStructDefaultGetParallelCptVars& vars) = 0;
  virtual Integer getItemTypeCpt(NoPropertyInterfViaStructDefaultGetItemTypeCptVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
  IMeshMaterialMng* m_mesh_material_mng;
  IRefPropertyInterf* m_ref_property_interf;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSInterfaces

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_INTERFACES___NOPROPERTYINTERFVIASTRUCTDEFAULTSERVICEBASE_H
