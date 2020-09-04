#ifndef ___HYDROMODULEBASE_H
#define ___HYDROMODULEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "__HydroModuleVars.h"
#include "Hydro_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;

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
  {
  }

  virtual ~HydroModuleBase()
  {
  }

 public:  // ***** ACCESSEURS
  VersionInfo versionInfo() const { return VersionInfo("1.0"); }

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
         outVars [shape="record", label="var"];
         compute -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle HydroModule::compute.
  */
  void compute()
  {
    HydroComputeVars vars(m_var);
    this->compute(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void compute(HydroComputeVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // ___HYDROMODULEBASE_H
