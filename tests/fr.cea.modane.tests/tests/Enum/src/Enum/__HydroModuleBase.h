#ifndef ENUM___HYDROMODULEBASE_H
#define ENUM___HYDROMODULEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Enum/__HydroModuleVars.h"
#include "Enum/__CQsComputingMethod.h"
#include "Enum/__IPseudoViscosity.h"
#include "Enum/Hydro_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Enum {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Module Hydro : classe de base. 
 * Mon module Hydro
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
  CQsComputingMethod getCQsComputingMethod() { return options()->getCQsComputingMethod(); }
  bool getFineNodeMassComputing() { return options()->getFineNodeMassComputing(); }
  IPseudoViscosity* getPseudoViscosity() { return options()->getPseudoViscosity(); }
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
         inVars [shape="record", label="old_cell_volume"];
         inVars -> compute;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle HydroModule::compute.
  */
  void compute()
  {
    HydroComputeVars vars(m_old_cell_volume);
    this->compute(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void compute(HydroComputeVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Enum

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // ENUM___HYDROMODULEBASE_H
