#ifndef SERVICE___ORNYTHORINQUESERVICEBASE_H
#define SERVICE___ORNYTHORINQUESERVICEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Service/__IMammifere.h"
#include "Service/__IOvipare.h"
#include "Service/__OrnythorinqueServiceVars.h"
#include "Service/Ornythorinque_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service Ornythorinque : classe de base. 
 * 
 */
template<class T>
class OrnythorinqueServiceBase
: public ArcaneOrnythorinqueObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit OrnythorinqueServiceBase(const ServiceBuildInfo& bi)
  : ArcaneOrnythorinqueObject(bi)
  {
  }

  virtual ~OrnythorinqueServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  Integer getNbMamelles() { return options()->getNbMamelles(); }
  Integer getNbOeufs() { return options()->getNbOeufs(); }
  String getNom() { return options()->getNom(); }
  const String getImplName() const { return "OrnythorinqueService"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle OrnythorinqueService::g.
  */
  void g() override
  {
    OrnythorinqueGVars vars;
    this->g(vars);
  }

  /*!
   Cette méthode construit les variables et appelle OrnythorinqueService::f.
  */
  void f() override
  {
    OrnythorinqueFVars vars;
    this->f(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void g(OrnythorinqueGVars& vars) = 0;
  virtual void f(OrnythorinqueFVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE___ORNYTHORINQUESERVICEBASE_H
