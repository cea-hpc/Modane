#ifndef ABSTRACTVAR_UPDATER___UPDATERIMPLSERVICEBASE_H
#define ABSTRACTVAR_UPDATER___UPDATERIMPLSERVICEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "AbstractVar/Updater/__IUpdater.h"
#include "AbstractVar/Updater/__UpdaterImplServiceVars.h"
#include "AbstractVar/Updater/UpdaterImpl_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace AbstractVarUpdater {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service UpdaterImpl : classe de base. 
 * 
 */
template<class T>
class UpdaterImplServiceBase
: public ArcaneUpdaterImplObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit UpdaterImplServiceBase(const ServiceBuildInfo& bi)
  : ArcaneUpdaterImplObject(bi)
  {
  }

  virtual ~UpdaterImplServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "UpdaterImplService"; }

 public:  // ***** METHODES CONCRETES
  /*!
   \dot
     digraph updateGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         update [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="temperature | abstract_pressure"];
         inVars -> update;
         outVars [shape="record", label="abstract_pressure"];
         update -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle UpdaterImplService::update.
  */
  void update(VariableCellReal& abstract_pressure, const Real alpha)
  {
    UpdaterImplUpdateVars vars(m_temperature
        , abstract_pressure);
    this->update(vars, alpha);
  }

  /*!
   \dot
     digraph updatePressureGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         updatePressure [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="temperature | abstract_pressure"];
         inVars -> updatePressure;
         outVars [shape="record", label="abstract_pressure"];
         updatePressure -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle UpdaterImplService::updatePressure.
  */
  void updatePressure(VariableCellReal& abstract_pressure) override
  {
    UpdaterImplUpdatePressureVars vars(m_temperature
        , abstract_pressure);
    this->updatePressure(vars);
  }

  /*!
   \dot
     digraph updatePressureWithParamGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         updatePressureWithParam [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="temperature | abstract_pressure"];
         inVars -> updatePressureWithParam;
         outVars [shape="record", label="abstract_pressure"];
         updatePressureWithParam -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle UpdaterImplService::updatePressureWithParam.
  */
  void updatePressureWithParam(VariableCellReal& abstract_pressure, const Real alpha) override
  {
    UpdaterImplUpdatePressureWithParamVars vars(m_temperature
        , abstract_pressure);
    this->updatePressureWithParam(vars, alpha);
  }

  /*!
   \dot
     digraph updateOldPressureGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         updateOldPressure [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="temperature | old_pressure"];
         inVars -> updateOldPressure;
         outVars [shape="record", label="old_pressure"];
         updateOldPressure -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle UpdaterImplService::updateOldPressure.
  */
  void updateOldPressure() override
  {
    UpdaterImplUpdateOldPressureVars vars(m_temperature
        , m_old_pressure);
    this->updateOldPressure(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void update(UpdaterImplUpdateVars& vars, const Real alpha) = 0;
  virtual void updatePressure(UpdaterImplUpdatePressureVars& vars) = 0;
  virtual void updatePressureWithParam(UpdaterImplUpdatePressureWithParamVars& vars, const Real alpha) = 0;
  virtual void updateOldPressure(UpdaterImplUpdateOldPressureVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace AbstractVarUpdater

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // ABSTRACTVAR_UPDATER___UPDATERIMPLSERVICEBASE_H
