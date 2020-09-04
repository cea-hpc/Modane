#ifndef LEVEL1_LEVEL2_LEVEL3___IMYLEVEL3INTERFACE_H
#define LEVEL1_LEVEL2_LEVEL3___IMYLEVEL3INTERFACE_H

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
namespace Level1Level2Level3 {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface MyLevel3Interface
 * 
 */
class IMyLevel3Interface
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IMyLevel3Interface() {}
  virtual ~IMyLevel3Interface() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li MyLevel3ServiceBase::f
  */
  virtual void f() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Level1Level2Level3

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // LEVEL1_LEVEL2_LEVEL3___IMYLEVEL3INTERFACE_H
