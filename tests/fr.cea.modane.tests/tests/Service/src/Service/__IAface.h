#ifndef SERVICE___IAFACE_H
#define SERVICE___IAFACE_H

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
 * \brief Interface Aface
 * 
 */
class IAface
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IAface() {}
  virtual ~IAface() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;

 public:  // ***** METHODES ABSTRAITES
  virtual void compute(const IDeura* deura) = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE___IAFACE_H
