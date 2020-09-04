#ifndef SERVICE___COMPRI2SERVICEBASE_H
#define SERVICE___COMPRI2SERVICEBASE_H

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
#include "Service/__Compri2ServiceVars.h"
#include "Service/Legacy.h"
#include "Service/Compri2_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service Compri2 : classe de base. 
 * 
 */
template<class T>
class Compri2ServiceBase
: public ArcaneCompri2Object
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit Compri2ServiceBase(const ServiceBuildInfo& bi)
  : ArcaneCompri2Object(bi)
  {
  }

  virtual ~Compri2ServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "Compri2Service"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle Compri2Service::compute.
  */
  void compute(const ::onf::OnfUtils::Duboi* duboi, Array< Danlacol* >& danlacol) override
  {
    Compri2ComputeVars vars;
    this->compute(vars, duboi, danlacol);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void compute(Compri2ComputeVars& vars, const ::onf::OnfUtils::Duboi* duboi, Array< Danlacol* >& danlacol) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE___COMPRI2SERVICEBASE_H
