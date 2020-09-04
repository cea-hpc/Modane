#ifndef PARAMETERDEFAULTVALUE___HYDROMODULEBASE_H
#define PARAMETERDEFAULTVALUE___HYDROMODULEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "ParameterDefaultValue/__HydroModuleVars.h"
#include "ParameterDefaultValue/VarAsArgs/__IUpdater.h"
#include "ParameterDefaultValue/NoVarAsArgs/__IUpdaterNoVars.h"
#include "ParameterDefaultValue/__IMyStruct.h"
#include "ParameterDefaultValue/Hydro_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace ParameterDefaultValue {

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
  ::ParameterDefaultValueVarAsArgs::IUpdater* getVarAsArgs() { return options()->getVarAsArgs(); }
  ::ParameterDefaultValueNoVarAsArgs::IUpdaterNoVars* getNoVarAsArgs() { return options()->getNoVarAsArgs(); }
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

  /*!
   Cette méthode construit les variables et appelle HydroModule::computeWithMyStruct.
  */
  void computeWithMyStruct(const IMyStruct* my_struct=nullptr)
  {
    HydroComputeWithMyStructVars vars;
    this->computeWithMyStruct(vars, my_struct);
  }

  /*!
   Cette méthode construit les variables et appelle HydroModule::computeWithString.
  */
  void computeWithString(const String my_string="ficelle")
  {
    HydroComputeWithStringVars vars;
    this->computeWithString(vars, my_string);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void compute(HydroComputeVars& vars) = 0;
  virtual void computeWithMyStruct(HydroComputeWithMyStructVars& vars, const IMyStruct* my_struct=nullptr) = 0;
  virtual void computeWithString(HydroComputeWithStringVars& vars, const String my_string="ficelle") = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace ParameterDefaultValue

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PARAMETERDEFAULTVALUE___HYDROMODULEBASE_H
