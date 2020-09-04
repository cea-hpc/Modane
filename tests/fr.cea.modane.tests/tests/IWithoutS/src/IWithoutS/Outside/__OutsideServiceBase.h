#ifndef IWITHOUTS_OUTSIDE___OUTSIDESERVICEBASE_H
#define IWITHOUTS_OUTSIDE___OUTSIDESERVICEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "IWithoutS/Interfaces/__IOutsideServiceInterf.h"
#include "IWithoutS/Outside/__OutsideServiceVars.h"
#include "IWithoutS/Outside/Outside_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace IWithoutSOutside {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service Outside : classe de base. 
 * 
 */
template<class T>
class OutsideServiceBase
: public ArcaneOutsideObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit OutsideServiceBase(const ServiceBuildInfo& bi)
  : ArcaneOutsideObject(bi)
  {
  }

  virtual ~OutsideServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  Real getRealOption() { return options()->getRealOption(); }
  bool hasRealOption() const { return options()->hasRealOption(); }
  const String getImplName() const { return "OutsideService"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle OutsideService::compute.
  */
  void compute() override
  {
    OutsideComputeVars vars;
    this->compute(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void compute(OutsideComputeVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSOutside

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_OUTSIDE___OUTSIDESERVICEBASE_H
