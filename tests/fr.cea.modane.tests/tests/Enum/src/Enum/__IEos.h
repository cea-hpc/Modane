#ifndef ENUM___IEOS_H
#define ENUM___IEOS_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Enum/SubEnum/__PseudoViscosityType.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Enum {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Eos
 * 
 */
class IEos
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IEos() {}
  virtual ~IEos() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;

 public:  // ***** METHODES ABSTRAITES
  virtual void f(const ::EnumSubEnum::PseudoViscosityType pseudo_type) = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Enum

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // ENUM___IEOS_H
