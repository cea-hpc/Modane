#ifndef SERVICE___HYDROMODULEBASE_H
#define SERVICE___HYDROMODULEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Service/__ITrackingable.h"
#include "Service/__HydroModuleVars.h"
#include "Service/AfaceDefault.h"
#include "Service/__IDeura.h"
#include "Service/Legacy.h"
#include "Service/__IBidon.h"
#include "Service/__IAface.h"
#include "Service/__IAnotherConcreteFace.h"
#include "Service/__ITracking.h"
#include "Service/Hydro_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Service {

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
  , m_aface(new ::Service::AfaceDefault(bi.mesh()))
  {
  }

  virtual ~HydroModuleBase()
  {
    delete m_aface;
  }

 public:  // ***** ACCESSEURS
  IDeura* getDeura() { return options()->getDeura(); }
  ::onf::OnfUtils::Duboi* getDuboi() { return options()->getDuboi(); }
  Danlacol* getDanlacol() { return options()->getDanlacol(); }
  IBidon* getBid() { return options()->getBid(); }
  IAface* getAface() { return m_aface; }
  IAnotherConcreteFace* getAConcreteFace() { return options()->getAConcreteFace(); }
  ITracking* getMyTracking() { return options()->getMyTracking(); }
  VersionInfo versionInfo() const { return VersionInfo("1.0"); }
  const String getImplName() const { return "HydroModule"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle HydroModule::compute.
  */
  void compute()
  {
    HydroComputeVars vars;
    this->compute(vars);
  }

  /*!
   Cette méthode construit les variables et appelle HydroModule::autoLoadCompute.
  */
  void autoLoadCompute()
  {
    HydroAutoLoadComputeVars vars;
    this->autoLoadCompute(vars);
  }

  /*!
   Cette méthode construit les variables et appelle HydroModule::giveContribution.
  */
  void giveContribution() override
  {
    HydroGiveContributionVars vars;
    this->giveContribution(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void compute(HydroComputeVars& vars) = 0;
  virtual void autoLoadCompute(HydroAutoLoadComputeVars& vars) = 0;
  virtual void giveContribution(HydroGiveContributionVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
  IAface* m_aface;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE___HYDROMODULEBASE_H
