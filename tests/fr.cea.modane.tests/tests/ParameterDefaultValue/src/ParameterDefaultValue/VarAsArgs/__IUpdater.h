#ifndef PARAMETERDEFAULTVALUE_VARASARGS___IUPDATER_H
#define PARAMETERDEFAULTVALUE_VARASARGS___IUPDATER_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace ParameterDefaultValueVarAsArgs {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Updater
 * 
 */
class IUpdater
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IUpdater() {}
  virtual ~IUpdater() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li UpdaterImplServiceBase::f1
  */
  virtual Real f1(const Real a=1.0) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li UpdaterImplServiceBase::f2
  */
  virtual Real f2(const Real a=1.0, const Integer b=25) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li UpdaterImplServiceBase::f3
  */
  virtual Real f3(const Real a, const Integer b, const bool c=true) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li UpdaterImplServiceBase::fWithReturn
  */
  virtual Real fWithReturn() = 0;
  /*!
  Cette méthode est implémentée dans :
  \li UpdaterImplServiceBase::fWithOut
  */
  virtual void fWithOut(Real& a) = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace ParameterDefaultValueVarAsArgs

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PARAMETERDEFAULTVALUE_VARASARGS___IUPDATER_H
