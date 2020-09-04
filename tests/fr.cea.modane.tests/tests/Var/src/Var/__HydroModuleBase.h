#ifndef VAR___HYDROMODULEBASE_H
#define VAR___HYDROMODULEBASE_H

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
#include "Var/__HydroModuleVars.h"
#include "Var/__IEos.h"
#include "Var/Hydro_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace Var {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Module Hydro : classe de base. 
 * 
 */
template<class T>
class HydroModuleBase
: public ArcaneHydroObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit HydroModuleBase(const ModuleBuildInfo& bi)
  : ArcaneHydroObject(bi)
  , m_mesh_material_mng(IMeshMaterialMng::getReference(bi.mesh()))
  {
  }

  virtual ~HydroModuleBase()
  {
  }

 public:  // ***** ACCESSEURS
  IEos* getEos() { return options()->getEos(); }
  String getDivUStrategy() { return options()->getDivUStrategy(); }
  VersionInfo versionInfo() const { return VersionInfo("1.0"); }
  IMeshMaterialMng* getMeshMaterialMng() const { return m_mesh_material_mng; }

 public:  // ***** METHODES CONCRETES
  /*!
   \dot
     digraph computeGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         compute [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="pressure | boolean_var | particle_energy | mat_array_var | dof_energy"];
         inVars -> compute;
         outVars [shape="record", label="temperature | env_elasticity | particle_density"];
         compute -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle HydroModule::compute.
  */
  void compute()
  {
    HydroComputeVars vars(m_pressure
        , m_boolean_var
        , m_particle_energy
        , m_mat_array_var
        , m_dof_energy
        , m_temperature
        , m_env_elasticity
        , m_particle_density);
    this->compute(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void compute(HydroComputeVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
  IMeshMaterialMng* m_mesh_material_mng;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Var

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // VAR___HYDROMODULEBASE_H
