#ifndef SERVICE___SINGLETONDEFAULTSERVICEBASE_H
#define SERVICE___SINGLETONDEFAULTSERVICEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Service/__ISingletonInterf.h"
#include "Service/__SingletonDefaultServiceVars.h"
#include "Service/SingletonDefault_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service SingletonDefault : classe de base. 
 * 
 */
template<class T>
class SingletonDefaultServiceBase
: public ArcaneSingletonDefaultObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit SingletonDefaultServiceBase(const ServiceBuildInfo& bi)
  : ArcaneSingletonDefaultObject(bi)
  {
  }

  virtual ~SingletonDefaultServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "SingletonDefaultService"; }

 public:  // ***** METHODES CONCRETES

 public:  // ***** METHODES ABSTRAITES

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE___SINGLETONDEFAULTSERVICEBASE_H
