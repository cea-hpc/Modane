#ifndef IWITHOUTS_INTERFACES___NOPROPERTYINTERFDEFAULTBASE_H
#define IWITHOUTS_INTERFACES___NOPROPERTYINTERFDEFAULTBASE_H

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
#include "arcane/IMesh.h"
#include "arcane/MeshAccessor.h"
#include "arcane/utils/TraceAccessor.h"
#include "IWithoutS/Interfaces/__INoPropertyInterf.h"
#include "IWithoutS/Interfaces/__NoPropertyInterfDefaultVars.h"
#include "IWithoutS/Interfaces/__NoPropertyInterfDefaultComputeByItemType.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace IWithoutSInterfaces {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface NoPropertyInterf : classe de base. 
 * 
 */
template<class T>
class NoPropertyInterfDefaultBase
: public INoPropertyInterf
, public TraceAccessor
, public MeshAccessor
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit NoPropertyInterfDefaultBase(IMesh* mesh) 
  : TraceAccessor(mesh->traceMng())
  , MeshAccessor(mesh)
  , m_mesh_material_mng(IMeshMaterialMng::getReference(mesh))
  {
  }

  virtual ~NoPropertyInterfDefaultBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "NoPropertyInterfDefault"; }
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
   Cette méthode construit les variables et appelle NoPropertyInterfDefault::computeSequential.
  */
  void computeSequential(const CellVectorView items, const VariableCellReal& abstract_temperature, VariableCellReal& abstract_density, const Real coef)
  {
    NoPropertyInterfDefaultComputeSequentialVars vars(abstract_temperature
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
   Cette méthode construit les variables et appelle NoPropertyInterfDefault::computeParallel.
  */
  void computeParallel(const CellVectorView items, const VariableCellReal& abstract_temperature, VariableCellReal& abstract_density, const Real coef)
  {
    NoPropertyInterfDefaultComputeParallelVars vars(abstract_temperature
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
   Cette méthode construit les variables et appelle NoPropertyInterfDefault::computeByItemType.
  */
  void computeByItemType(const ItemGroup& items, const VariableCellReal& abstract_temperature, VariableCellReal& abstract_density, const Real coef)
  {
    NoPropertyInterfDefaultComputeByItemTypeVars vars(abstract_temperature
        , abstract_density);
    T* t = static_cast<T*>(this);
    NoPropertyInterfDefaultComputeByItemType<T> fclass(t, vars, coef); 
    items.applyOperation(&fclass);
  }

  /*!
   Cette méthode construit les variables et appelle NoPropertyInterfDefault::computeByEnvCell.
  */
  void computeByEnvCell(const EnvCellVectorView items, const Real coef)
  {
    NoPropertyInterfDefaultComputeByEnvCellVars vars;
    T* t = static_cast<T*>(this);
    ENUMERATE_ENVCELL (iitem, items) {
      const EnvCell item = *iitem;
      t->computeByEnvCell(item, vars, coef);
    }
  }

  /*!
   Cette méthode construit les variables et appelle NoPropertyInterfDefault::computeByMatCell.
  */
  void computeByMatCell(const MatCellVectorView items, const Real coef)
  {
    NoPropertyInterfDefaultComputeByMatCellVars vars;
    T* t = static_cast<T*>(this);
    ENUMERATE_MATCELL (iitem, items) {
      const MatCell item = *iitem;
      t->computeByMatCell(item, vars, coef);
    }
  }

  /*!
   Cette méthode construit les variables et appelle NoPropertyInterfDefault::getSequentialCpt.
  */
  Integer getSequentialCpt()
  {
    NoPropertyInterfDefaultGetSequentialCptVars vars;
    return this->getSequentialCpt(vars);
  }

  /*!
   Cette méthode construit les variables et appelle NoPropertyInterfDefault::getParallelCpt.
  */
  Integer getParallelCpt()
  {
    NoPropertyInterfDefaultGetParallelCptVars vars;
    return this->getParallelCpt(vars);
  }

  /*!
   Cette méthode construit les variables et appelle NoPropertyInterfDefault::getItemTypeCpt.
  */
  Integer getItemTypeCpt()
  {
    NoPropertyInterfDefaultGetItemTypeCptVars vars;
    return this->getItemTypeCpt(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void computeSequential(const Cell cell, NoPropertyInterfDefaultComputeSequentialVars& vars, const Real coef) = 0;
  virtual void computeParallel(const Cell cell, NoPropertyInterfDefaultComputeParallelVars& vars, const Real coef) = 0;
  virtual void computeByItemTypeVertex([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeLine2([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeTriangle3([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeQuad4([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypePentagon5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHexagon6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeTetraedron4([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypePyramid5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypePentaedron6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHexaedron8([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHeptaedron10([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeOctaedron12([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHemiHexa7([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHemiHexa6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeHemiHexa5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeAntiWedgeLeft6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeAntiWedgeRight6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDiTetra5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDualNode([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDualEdge([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDualFace([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeDualCell([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByItemTypeLink([[maybe_unused]] ItemVectorView items, [[maybe_unused]] NoPropertyInterfDefaultComputeByItemTypeVars& vars, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void computeByEnvCell(const EnvCell envcell, NoPropertyInterfDefaultComputeByEnvCellVars& vars, const Real coef) = 0;
  virtual void computeByMatCell(const MatCell matcell, NoPropertyInterfDefaultComputeByMatCellVars& vars, const Real coef) = 0;
  virtual Integer getSequentialCpt(NoPropertyInterfDefaultGetSequentialCptVars& vars) = 0;
  virtual Integer getParallelCpt(NoPropertyInterfDefaultGetParallelCptVars& vars) = 0;
  virtual Integer getItemTypeCpt(NoPropertyInterfDefaultGetItemTypeCptVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
  IMeshMaterialMng* m_mesh_material_mng;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSInterfaces

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_INTERFACES___NOPROPERTYINTERFDEFAULTBASE_H
