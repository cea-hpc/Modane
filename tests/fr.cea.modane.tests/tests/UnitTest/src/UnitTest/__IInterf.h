#ifndef UNITTEST___IINTERF_H
#define UNITTEST___IINTERF_H

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
namespace UnitTest {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Interf
 * 
 */
class IInterf
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IInterf() {}
  virtual ~IInterf() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li UnitTestServiceBase::add
  */
  virtual Integer add(const Integer a, const Integer b) = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace UnitTest

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // UNITTEST___IINTERF_H
