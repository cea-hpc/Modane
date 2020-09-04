#ifndef PARAMETERDEFAULTVALUE_VARASARGS___UPDATERIMPLSERVICEBASE_H
#define PARAMETERDEFAULTVALUE_VARASARGS___UPDATERIMPLSERVICEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "ParameterDefaultValue/VarAsArgs/__IUpdater.h"
#include "ParameterDefaultValue/VarAsArgs/__UpdaterImplServiceVars.h"
#include "ParameterDefaultValue/VarAsArgs/UpdaterImpl_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace ParameterDefaultValueVarAsArgs {

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
   Cette méthode construit les variables et appelle UpdaterImplService::f1.
  */
  Real f1(const Real a=1.0) override
  {
    UpdaterImplF1Vars vars;
    return this->f1(vars, a);
  }

  /*!
   Cette méthode construit les variables et appelle UpdaterImplService::f2.
  */
  Real f2(const Real a=1.0, const Integer b=25) override
  {
    UpdaterImplF2Vars vars;
    return this->f2(vars, a, b);
  }

  /*!
   Cette méthode construit les variables et appelle UpdaterImplService::f3.
  */
  Real f3(const Real a, const Integer b, const bool c=true) override
  {
    UpdaterImplF3Vars vars;
    return this->f3(vars, a, b, c);
  }

  /*!
   Cette méthode construit les variables et appelle UpdaterImplService::fWithReturn.
  */
  Real fWithReturn() override
  {
    UpdaterImplFWithReturnVars vars;
    return this->fWithReturn(vars);
  }

  /*!
   Cette méthode construit les variables et appelle UpdaterImplService::fWithOut.
  */
  void fWithOut(Real& a) override
  {
    UpdaterImplFWithOutVars vars;
    this->fWithOut(vars, a);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual Real f1(UpdaterImplF1Vars& vars, const Real a=1.0) = 0;
  virtual Real f2(UpdaterImplF2Vars& vars, const Real a=1.0, const Integer b=25) = 0;
  virtual Real f3(UpdaterImplF3Vars& vars, const Real a, const Integer b, const bool c=true) = 0;
  virtual Real fWithReturn(UpdaterImplFWithReturnVars& vars) = 0;
  virtual void fWithOut(UpdaterImplFWithOutVars& vars, Real& a) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace ParameterDefaultValueVarAsArgs

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PARAMETERDEFAULTVALUE_VARASARGS___UPDATERIMPLSERVICEBASE_H
