#ifndef PARAMETERDEFAULTVALUE___IMYSTRUCT_H
#define PARAMETERDEFAULTVALUE___IMYSTRUCT_H

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
namespace ParameterDefaultValue {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface représentant la structure MyStruct
 * 
 */
class IMyStruct
{
 public:
  IMyStruct() {}
  virtual ~IMyStruct() {}

 public:
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * Classe représentant la structure MyStruct
 * 
 */
class MyStruct
: public IMyStruct
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  MyStruct()
  {}
  virtual ~MyStruct() {}

 public:  // ***** ACCESSEURS

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace ParameterDefaultValue

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PARAMETERDEFAULTVALUE___IMYSTRUCT_H
