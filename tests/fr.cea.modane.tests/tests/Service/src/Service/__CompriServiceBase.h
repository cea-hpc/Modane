#ifndef SERVICE___COMPRISERVICEBASE_H
#define SERVICE___COMPRISERVICEBASE_H

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
#include "Service/__CompriServiceVars.h"
#include "Service/Legacy.h"
#include "Service/Compri_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service Compri : classe de base. 
 * 
 */
template<class T>
class CompriServiceBase
: public ArcaneCompriObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit CompriServiceBase(const ServiceBuildInfo& bi)
  : ArcaneCompriObject(bi)
  {
  }

  virtual ~CompriServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "CompriService"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle CompriService::compute.
  */
  void compute(const ::onf::OnfUtils::Duboi* duboi, Array< Danlacol* >& danlacol) override
  {
    CompriComputeVars vars;
    this->compute(vars, duboi, danlacol);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void compute(CompriComputeVars& vars, const ::onf::OnfUtils::Duboi* duboi, Array< Danlacol* >& danlacol) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE___COMPRISERVICEBASE_H
