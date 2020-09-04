#ifndef SERVICE___ANOTHERCONCRETEFACEDEFAULTSERVICEBASE_H
#define SERVICE___ANOTHERCONCRETEFACEDEFAULTSERVICEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Service/__IAnotherConcreteFace.h"
#include "Service/__AnotherConcreteFaceDefaultServiceVars.h"
#include "Service/__IDeura.h"
#include "Service/AnotherConcreteFaceDefault_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service AnotherConcreteFaceDefault : classe de base. 
 * Service par défaut pour l'interface AnotherConcreteFace
 */
template<class T>
class AnotherConcreteFaceDefaultServiceBase
: public ArcaneAnotherConcreteFaceDefaultObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit AnotherConcreteFaceDefaultServiceBase(const ServiceBuildInfo& bi)
  : ArcaneAnotherConcreteFaceDefaultObject(bi)
  {
  }

  virtual ~AnotherConcreteFaceDefaultServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  Integer getCfl() { return options()->getCfl(); }
  const String getImplName() const { return "AnotherConcreteFaceDefaultService"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle AnotherConcreteFaceDefaultService::compute.
  */
  void compute(const IDeura* deura) override
  {
    AnotherConcreteFaceDefaultComputeVars vars;
    this->compute(vars, deura);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void compute(AnotherConcreteFaceDefaultComputeVars& vars, const IDeura* deura) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE___ANOTHERCONCRETEFACEDEFAULTSERVICEBASE_H
