#ifndef SERVICE___IMAMMIFERE_H
#define SERVICE___IMAMMIFERE_H

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
namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Mammifere
 * 
 */
class IMammifere
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IMammifere() {}
  virtual ~IMammifere() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;
  virtual Integer getNbMamelles() = 0;

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li OrnythorinqueServiceBase::g
  */
  virtual void g() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE___IMAMMIFERE_H
