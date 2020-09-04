#ifndef STRUCT_OPERATION___IOPERATION_H
#define STRUCT_OPERATION___IOPERATION_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Struct/Operation/__IOperand.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace StructOperation {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Operation
 * 
 */
class IOperation
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IOperation() {}
  virtual ~IOperation() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li AddServiceBase::apply
  \li SubServiceBase::apply
  */
  virtual void apply(ConstArrayView< IOperand* > op, Array< Integer >& result) = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace StructOperation

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // STRUCT_OPERATION___IOPERATION_H
