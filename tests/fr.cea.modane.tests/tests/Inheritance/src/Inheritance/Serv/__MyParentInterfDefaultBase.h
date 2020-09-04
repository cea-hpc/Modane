#ifndef INHERITANCE_SERV___MYPARENTINTERFDEFAULTBASE_H
#define INHERITANCE_SERV___MYPARENTINTERFDEFAULTBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "arcane/IMesh.h"
#include "arcane/MeshAccessor.h"
#include "arcane/utils/TraceAccessor.h"
#include "Inheritance/Serv/__IMyParentInterf.h"
#include "Inheritance/Serv/__MyParentInterfDefaultVars.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace InheritanceServ {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface MyParentInterf : classe de base. 
 * 
 */
template<class T>
class MyParentInterfDefaultBase
: public IMyParentInterf
, public TraceAccessor
, public MeshAccessor
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit MyParentInterfDefaultBase(IMesh* mesh) 
  : TraceAccessor(mesh->traceMng())
  , MeshAccessor(mesh)
  {
  }

  virtual ~MyParentInterfDefaultBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "MyParentInterfDefault"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle MyParentInterfDefault::f.
  */
  void f()
  {
    MyParentInterfDefaultFVars vars;
    this->f(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void f(MyParentInterfDefaultFVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace InheritanceServ

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // INHERITANCE_SERV___MYPARENTINTERFDEFAULTBASE_H
