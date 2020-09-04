#ifndef ABSTRACTVAR___HYDROMODULEBASE_H
#define ABSTRACTVAR___HYDROMODULEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "AbstractVar/__HydroModuleVars.h"
#include "AbstractVar/Updater/__IUpdater.h"
#include "AbstractVar/Hydro_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace AbstractVar {

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
  ::AbstractVarUpdater::IUpdater* getUpdater() { return options()->getUpdater(); }
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
         inVars [shape="record", label="new_pressure | old_pressure"];
         inVars -> compute;
         outVars [shape="record", label="new_pressure | old_pressure"];
         compute -> outVars;
       }
   
       subgraph clusterCalledFuncs
       {
         center="true";
         color="navy";
         IUpdater_updatePressure [label="updatePressure", color="navy", fontcolor="navy", style="rounded", URL="\ref AbstractVarUpdater::IUpdater::updatePressure"];
         IUpdater_updatePressureWithParam [label="updatePressureWithParam", color="navy", fontcolor="navy", style="rounded", URL="\ref AbstractVarUpdater::IUpdater::updatePressureWithParam"];
         IUpdater_updateOldPressure [label="updateOldPressure", color="navy", fontcolor="navy", style="rounded", URL="\ref AbstractVarUpdater::IUpdater::updateOldPressure"];
       }
       compute -> IUpdater_updateOldPressure [lhead="clusterCalledFuncs", style="dashed", label=" call"];
     }
   \enddot
   Cette méthode construit les variables et appelle HydroModule::compute.
  */
  void compute()
  {
    HydroComputeVars vars(m_new_pressure
        , m_old_pressure);
    this->compute(vars);
  }

  /*!
   \dot
     digraph initGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         init [style="rounded, filled", fillcolor="gray"];
         outVars [shape="record", label="new_pressure | old_pressure"];
         init -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle HydroModule::init.
  */
  void init()
  {
    HydroInitVars vars(m_new_pressure
        , m_old_pressure);
    this->init(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void compute(HydroComputeVars& vars) = 0;
  virtual void init(HydroInitVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace AbstractVar

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // ABSTRACTVAR___HYDROMODULEBASE_H
