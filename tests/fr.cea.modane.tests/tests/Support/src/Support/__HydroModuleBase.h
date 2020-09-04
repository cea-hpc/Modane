#ifndef SUPPORT___HYDROMODULEBASE_H
#define SUPPORT___HYDROMODULEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Support/__HydroModuleVars.h"
#include "Support/Hydro_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Support {

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
       }
   
       subgraph clusterCalledFuncs
       {
         center="true";
         color="navy";
         IEos_computeSequential [label="computeSequential", color="navy", fontcolor="navy", style="rounded", URL="\ref SupportEos::IEos::computeSequential"];
         IEos_computeParallel [label="computeParallel", color="navy", fontcolor="navy", style="rounded", URL="\ref SupportEos::IEos::computeParallel"];
         IEos_computeByItemType [label="computeByItemType", color="navy", fontcolor="navy", style="rounded", URL="\ref SupportEos::IEos::computeByItemType"];
       }
       compute -> IEos_computeByItemType [lhead="clusterCalledFuncs", style="dashed", label=" call"];
     }
   \enddot
   Cette méthode construit les variables et appelle HydroModule::compute.
  */
  void compute()
  {
    HydroComputeVars vars;
    this->compute(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void compute(HydroComputeVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Support

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SUPPORT___HYDROMODULEBASE_H
