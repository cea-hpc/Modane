#ifndef INHERITANCE___HYDROMODULEBASE_H
#define INHERITANCE___HYDROMODULEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Inheritance/__HydroModuleVars.h"
#include "Inheritance/Serv/MyParentInterfDefault.h"
#include "Inheritance/__IMyChildStruct.h"
#include "Inheritance/Serv/__IMyChildInterf.h"
#include "Inheritance/Serv/__IMyParentInterf.h"
#include "Inheritance/Hydro_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Inheritance {

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
  , m_serv2(new ::InheritanceServ::MyParentInterfDefault(bi.mesh()))
  {
  }

  virtual ~HydroModuleBase()
  {
    delete m_serv2;
  }

 public:  // ***** ACCESSEURS
  IMyChildStruct* getChild() { return options()->getChild(); }
  ::InheritanceServ::IMyChildInterf* getServ() { return options()->getServ(); }
  ::InheritanceServ::IMyParentInterf* getServ2() { return m_serv2; }
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
  ::InheritanceServ::IMyParentInterf* m_serv2;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Inheritance

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // INHERITANCE___HYDROMODULEBASE_H
