#ifndef INHERITANCE_SERV___BASICSERVICEBASE_H
#define INHERITANCE_SERV___BASICSERVICEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Inheritance/Serv/__IMyChildInterf.h"
#include "Inheritance/Serv/__BasicServiceVars.h"
#include "Inheritance/Serv/Basic_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace InheritanceServ {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service Basic : classe de base. 
 * 
 */
template<class T>
class BasicServiceBase
: public ArcaneBasicObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit BasicServiceBase(const ServiceBuildInfo& bi)
  : ArcaneBasicObject(bi)
  {
  }

  virtual ~BasicServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "BasicService"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle BasicService::g.
  */
  void g() override
  {
    BasicGVars vars;
    this->g(vars);
  }

  /*!
   Cette méthode construit les variables et appelle BasicService::f.
  */
  void f() override
  {
    BasicFVars vars;
    this->f(vars);
  }

  /*!
   Cette méthode construit les variables et appelle BasicService::testAutoInclude.
  */
  void testAutoInclude(const IMyChildInterf* my_child_interf) override
  {
    BasicTestAutoIncludeVars vars;
    this->testAutoInclude(vars, my_child_interf);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void g(BasicGVars& vars) = 0;
  virtual void f(BasicFVars& vars) = 0;
  virtual void testAutoInclude(BasicTestAutoIncludeVars& vars, const IMyChildInterf* my_child_interf) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace InheritanceServ

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // INHERITANCE_SERV___BASICSERVICEBASE_H
