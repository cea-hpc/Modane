#ifndef SERVICE___IANOTHERCONCRETEFACE_H
#define SERVICE___IANOTHERCONCRETEFACE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Service/__IDeura.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface AnotherConcreteFace
 * 
 */
class IAnotherConcreteFace
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IAnotherConcreteFace() {}
  virtual ~IAnotherConcreteFace() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;
  virtual Integer getCfl() = 0;

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li AnotherConcreteFaceDefaultServiceBase::compute
  */
  virtual void compute(const IDeura* deura) = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE___IANOTHERCONCRETEFACE_H
