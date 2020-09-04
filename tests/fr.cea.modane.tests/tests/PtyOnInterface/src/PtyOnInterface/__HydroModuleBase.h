#ifndef PTYONINTERFACE___HYDROMODULEBASE_H
#define PTYONINTERFACE___HYDROMODULEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "PtyOnInterface/__HydroModuleVars.h"
#include "PtyOnInterface/__IEos.h"
#include "PtyOnInterface/Hydro_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace PtyOnInterface {

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
  IEos* getEos() { return options()->getEos(); }
  VersionInfo versionInfo() const { return VersionInfo("1.0"); }

 public:  // ***** METHODES CONCRETES
  /*!
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

}  // namespace PtyOnInterface

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PTYONINTERFACE___HYDROMODULEBASE_H
