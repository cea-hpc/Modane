#ifndef PTYONINTERFACE___MYINTERFDEFAULTSERVICEBASE_H
#define PTYONINTERFACE___MYINTERFDEFAULTSERVICEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "PtyOnInterface/__IMyInterf.h"
#include "PtyOnInterface/__MyInterfDefaultServiceVars.h"
#include "PtyOnInterface/__IMyStruct.h"
#include "PtyOnInterface/MyInterfDefault_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace PtyOnInterface {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service MyInterfDefault : classe de base. 
 * Service par défaut pour l'interface MyInterf
 */
template<class T>
class MyInterfDefaultServiceBase
: public ArcaneMyInterfDefaultObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit MyInterfDefaultServiceBase(const ServiceBuildInfo& bi)
  : ArcaneMyInterfDefaultObject(bi)
  {
  }

  virtual ~MyInterfDefaultServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  Real getR() { return options()->getR(); }
  IMyStruct* getS() { return options()->getS(); }
  const String getImplName() const { return "MyInterfDefaultService"; }

 public:  // ***** METHODES CONCRETES

 public:  // ***** METHODES ABSTRAITES

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace PtyOnInterface

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PTYONINTERFACE___MYINTERFDEFAULTSERVICEBASE_H
