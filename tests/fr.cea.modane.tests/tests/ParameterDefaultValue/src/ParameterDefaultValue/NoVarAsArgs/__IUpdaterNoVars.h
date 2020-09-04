#ifndef PARAMETERDEFAULTVALUE_NOVARASARGS___IUPDATERNOVARS_H
#define PARAMETERDEFAULTVALUE_NOVARASARGS___IUPDATERNOVARS_H

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
namespace ParameterDefaultValueNoVarAsArgs {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface UpdaterNoVars
 * 
 */
class IUpdaterNoVars
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IUpdaterNoVars() {}
  virtual ~IUpdaterNoVars() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li UpdaterNoVarsImplServiceBase::f
  */
  virtual Real f(const Real a=1.0) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li UpdaterNoVarsImplServiceBase::fWithSupport
  */
  virtual void fWithSupport(const CellVectorView items, const Real a=1.0) = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace ParameterDefaultValueNoVarAsArgs

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PARAMETERDEFAULTVALUE_NOVARASARGS___IUPDATERNOVARS_H
