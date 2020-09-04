#ifndef VAR_NOVARASARGS___MYEOSDELEGATIONSERVICEBASE_H
#define VAR_NOVARASARGS___MYEOSDELEGATIONSERVICEBASE_H

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
#include "Var/NoVarAsArgs/__IEosDelegation.h"
#include "Var/NoVarAsArgs/__MyEosDelegationApplyWithItem.h"
#include "Var/NoVarAsArgs/MyEosDelegation_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace VarNoVarAsArgs {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service MyEosDelegation : classe de base. 
 * 
 */
template<class T>
class MyEosDelegationServiceBase
: public ArcaneMyEosDelegationObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit MyEosDelegationServiceBase(const ServiceBuildInfo& bi)
  : ArcaneMyEosDelegationObject(bi)
  , m_mesh_material_mng(IMeshMaterialMng::getReference(bi.mesh()))
  {
  }

  virtual ~MyEosDelegationServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "MyEosDelegationService"; }
  IMeshMaterialMng* getMeshMaterialMng() const { return m_mesh_material_mng; }

 public:  // ***** METHODES CONCRETES
  /*!
   \dot
     digraph applyWithSupportGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         applyWithSupport [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="pressure | plasticity"];
         inVars -> applyWithSupport;
         outVars [shape="record", label="temperature | mat_density"];
         applyWithSupport -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle MyEosDelegationService::applyWithSupport.
  */
  void applyWithSupport(const CellVectorView items, const Real coef) override
  {
    T* t = static_cast<T*>(this);
    Parallel::Foreach(items, [&](CellVectorView sub_items)
    {
      ENUMERATE_CELL (iitem, sub_items) {
        const Cell item = *iitem;
        t->applyWithSupport(item, coef);
      }
    });
  }

  /*!
   \dot
     digraph applyWithItemGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         applyWithItem [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="pressure | plasticity"];
         inVars -> applyWithItem;
         outVars [shape="record", label="temperature | mat_density"];
         applyWithItem -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle MyEosDelegationService::applyWithItem.
  */
  void applyWithItem(const ItemGroup& items, const Real coef) override
  {
    T* t = static_cast<T*>(this);
    MyEosDelegationApplyWithItem<T> fclass(t, coef); 
    items.applyOperation(&fclass);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void apply(const Real coef) = 0;
  virtual void applyWithSupport(const Cell cell, const Real coef) = 0;
  virtual void applyWithItemVertex([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemLine2([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemTriangle3([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemQuad4([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemPentagon5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemHexagon6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemTetraedron4([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemPyramid5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemPentaedron6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemHexaedron8([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemHeptaedron10([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemOctaedron12([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemHemiHexa7([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemHemiHexa6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemHemiHexa5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemAntiWedgeLeft6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemAntiWedgeRight6([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemDiTetra5([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemDualNode([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemDualEdge([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemDualFace([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemDualCell([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }
  virtual void applyWithItemLink([[maybe_unused]] ItemVectorView items, [[maybe_unused]] const Real coef) { throw NotImplementedException(A_FUNCINFO); }

 protected:  // ***** ATTRIBUTS
  IMeshMaterialMng* m_mesh_material_mng;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace VarNoVarAsArgs

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // VAR_NOVARASARGS___MYEOSDELEGATIONSERVICEBASE_H
