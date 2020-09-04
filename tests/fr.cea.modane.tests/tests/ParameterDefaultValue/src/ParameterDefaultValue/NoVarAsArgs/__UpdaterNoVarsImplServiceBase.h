#ifndef PARAMETERDEFAULTVALUE_NOVARASARGS___UPDATERNOVARSIMPLSERVICEBASE_H
#define PARAMETERDEFAULTVALUE_NOVARASARGS___UPDATERNOVARSIMPLSERVICEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "arcane/Concurrency.h"
#include "ParameterDefaultValue/NoVarAsArgs/__IUpdaterNoVars.h"
#include "ParameterDefaultValue/NoVarAsArgs/UpdaterNoVarsImpl_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace ParameterDefaultValueNoVarAsArgs {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service UpdaterNoVarsImpl : classe de base. 
 * 
 */
template<class T>
class UpdaterNoVarsImplServiceBase
: public ArcaneUpdaterNoVarsImplObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit UpdaterNoVarsImplServiceBase(const ServiceBuildInfo& bi)
  : ArcaneUpdaterNoVarsImplObject(bi)
  {
  }

  virtual ~UpdaterNoVarsImplServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "UpdaterNoVarsImplService"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle UpdaterNoVarsImplService::fWithSupport.
  */
  void fWithSupport(const CellVectorView items, const Real a=1.0) override
  {
    T* t = static_cast<T*>(this);
    Parallel::Foreach(items, [&](CellVectorView sub_items)
    {
      ENUMERATE_CELL (iitem, sub_items) {
        const Cell item = *iitem;
        t->fWithSupport(item, a);
      }
    });
  }


 public:  // ***** METHODES ABSTRAITES
  virtual Real fOfService(const Real a=1.0) = 0;
  virtual Real f(const Real a=1.0) = 0;
  virtual void fWithSupport(const Cell cell, const Real a=1.0) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace ParameterDefaultValueNoVarAsArgs

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PARAMETERDEFAULTVALUE_NOVARASARGS___UPDATERNOVARSIMPLSERVICEBASE_H
