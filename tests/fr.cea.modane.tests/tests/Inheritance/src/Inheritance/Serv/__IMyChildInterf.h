#ifndef INHERITANCE_SERV___IMYCHILDINTERF_H
#define INHERITANCE_SERV___IMYCHILDINTERF_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Inheritance/Serv/__IMyParentInterf.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace InheritanceServ {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface MyChildInterf
 * 
 */
class IMyChildInterf
: public IMyParentInterf
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IMyChildInterf() {}
  virtual ~IMyChildInterf() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li BasicServiceBase::g
  */
  virtual void g() = 0;
  /*!
  Cette méthode est implémentée dans :
  \li BasicServiceBase::testAutoInclude
  */
  virtual void testAutoInclude(const IMyChildInterf* my_child_interf) = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace InheritanceServ

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // INHERITANCE_SERV___IMYCHILDINTERF_H
