#ifndef VAR___PERFECTGASSERVICEBASE_H
#define VAR___PERFECTGASSERVICEBASE_H

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
#include "Var/__PerfectGasServiceVars.h"
#include "Var/NoVarAsArgs/__IEosDelegation.h"
#include "Var/PerfectGas_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace Var {

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
  ::VarNoVarAsArgs::IEosDelegation* getDelegation() { return options()->getDelegation(); }
  const String getImplName() const { return "PerfectGasService"; }
  IMeshMaterialMng* getMeshMaterialMng() const { return m_mesh_material_mng; }

 public:  // ***** METHODES CONCRETES
  /*!
   \dot
     digraph persoFuncGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         persoFunc [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="boolean_var"];
         inVars -> persoFunc;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle PerfectGasService::persoFunc.
  */
  void persoFunc()
  {
    PerfectGasPersoFuncVars vars(m_boolean_var);
    this->persoFunc(vars);
  }

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
         inVars [shape="record", label="pressure | plasticity | abstract_particle_var"];
         inVars -> apply;
         outVars [shape="record", label="temperature | mat_density"];
         apply -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle PerfectGasService::apply.
  */
  void apply(const VariableParticleReal& abstract_particle_var, const Real coef) override
  {
    PerfectGasApplyVars vars(m_pressure
        , m_plasticity
        , m_temperature
        , m_mat_density
        , abstract_particle_var);
    this->apply(vars, coef);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void persoFunc(PerfectGasPersoFuncVars& vars) = 0;
  virtual void apply(PerfectGasApplyVars& vars, const Real coef) = 0;

 protected:  // ***** ATTRIBUTS
  IMeshMaterialMng* m_mesh_material_mng;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Var

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // VAR___PERFECTGASSERVICEBASE_H
