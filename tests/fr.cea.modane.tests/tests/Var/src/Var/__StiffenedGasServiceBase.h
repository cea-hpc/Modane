#ifndef VAR___STIFFENEDGASSERVICEBASE_H
#define VAR___STIFFENEDGASSERVICEBASE_H

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
#include "Var/__IEos.h"
#include "Var/__StiffenedGasServiceVars.h"
#include "Var/NoVarAsArgs/__IEosDelegation.h"
#include "Var/StiffenedGas_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace Var {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service StiffenedGas : classe de base. 
 * 
 */
template<class T>
class StiffenedGasServiceBase
: public ArcaneStiffenedGasObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit StiffenedGasServiceBase(const ServiceBuildInfo& bi)
  : ArcaneStiffenedGasObject(bi)
  , m_mesh_material_mng(IMeshMaterialMng::getReference(bi.mesh()))
  {
  }

  virtual ~StiffenedGasServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  ::VarNoVarAsArgs::IEosDelegation* getDelegation() { return options()->getDelegation(); }
  const String getImplName() const { return "StiffenedGasService"; }
  IMeshMaterialMng* getMeshMaterialMng() const { return m_mesh_material_mng; }

 public:  // ***** METHODES CONCRETES
  /*!
   \dot
     digraph applyGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         apply [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="pressure | plasticity | particle_density | abstract_particle_var"];
         inVars -> apply;
         outVars [shape="record", label="temperature | mat_density"];
         apply -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle StiffenedGasService::apply.
  */
  void apply(const VariableParticleReal& abstract_particle_var, const Real coef) override
  {
    StiffenedGasApplyVars vars(m_pressure
        , m_plasticity
        , m_particle_density
        , m_temperature
        , m_mat_density
        , abstract_particle_var);
    this->apply(vars, coef);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void apply(StiffenedGasApplyVars& vars, const Real coef) = 0;

 protected:  // ***** ATTRIBUTS
  IMeshMaterialMng* m_mesh_material_mng;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Var

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // VAR___STIFFENEDGASSERVICEBASE_H
