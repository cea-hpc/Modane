#ifndef VAR_NOVARASARGS___IEOSDELEGATION_H
#define VAR_NOVARASARGS___IEOSDELEGATION_H

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
namespace VarNoVarAsArgs {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface EosDelegation
 * 
 */
class IEosDelegation
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IEosDelegation() {}
  virtual ~IEosDelegation() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li MyEosDelegationServiceBase::apply
  */
  virtual void apply(const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li MyEosDelegationServiceBase::applyWithSupport
  */
  virtual void applyWithSupport(const CellVectorView items, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li MyEosDelegationServiceBase::applyWithItem
  */
  virtual void applyWithItem(const ItemGroup& items, const Real coef) = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace VarNoVarAsArgs

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // VAR_NOVARASARGS___IEOSDELEGATION_H
