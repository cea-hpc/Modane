#ifndef IWITHOUTS___ICHILD_H
#define IWITHOUTS___ICHILD_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "IWithoutS/__IMother.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace IWithoutS {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Child
 * 
 */
class IChild
: public IMother
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IChild() {}
  virtual ~IChild() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;

 public:  // ***** METHODES ABSTRAITES
  virtual void compute() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutS

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS___ICHILD_H
