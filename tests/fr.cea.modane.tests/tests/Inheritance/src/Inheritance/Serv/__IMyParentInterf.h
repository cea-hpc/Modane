#ifndef INHERITANCE_SERV___IMYPARENTINTERF_H
#define INHERITANCE_SERV___IMYPARENTINTERF_H

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
namespace InheritanceServ {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface MyParentInterf
 * 
 */
class IMyParentInterf
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IMyParentInterf() {}
  virtual ~IMyParentInterf() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;

 public:  // ***** METHODES ABSTRAITES
  virtual void f() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace InheritanceServ

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // INHERITANCE_SERV___IMYPARENTINTERF_H
