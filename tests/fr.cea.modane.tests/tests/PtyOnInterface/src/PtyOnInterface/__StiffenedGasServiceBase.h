#ifndef PTYONINTERFACE___STIFFENEDGASSERVICEBASE_H
#define PTYONINTERFACE___STIFFENEDGASSERVICEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "PtyOnInterface/__IEos.h"
#include "PtyOnInterface/__StiffenedGasServiceVars.h"
#include "PtyOnInterface/__IMyStruct.h"
#include "PtyOnInterface/__IMyInterf.h"
#include "PtyOnInterface/StiffenedGas_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace PtyOnInterface {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service StiffenedGas : classe de base. 
 * 
 */
template<class T>
class StiffenedGasServiceBase
: public ArcaneStiffenedGasObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit StiffenedGasServiceBase(const ServiceBuildInfo& bi)
  : ArcaneStiffenedGasObject(bi)
  {
  }

  virtual ~StiffenedGasServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  Real getMyReal() { return options()->getMyReal(); }
  IMyStruct* getMyStruct() { return options()->getMyStruct(); }
  IMyInterf* getMyInterf() { return options()->getMyInterf(); }
  ConstArrayView< IMyStruct* > getMyStructs() { return options()->getMyStructs(); }
  ConstArrayView< Integer > getMyIntegers() { return options()->getMyIntegers(); }
  Integer getMyOptInteger() { return options()->getMyOptInteger(); }
  bool hasMyOptInteger() const { return options()->hasMyOptInteger(); }
  Real getTemperatureCoef() { return options()->getTemperatureCoef(); }
  const String getImplName() const { return "StiffenedGasService"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle StiffenedGasService::compute.
  */
  void compute() override
  {
    StiffenedGasComputeVars vars;
    this->compute(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void compute(StiffenedGasComputeVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace PtyOnInterface

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PTYONINTERFACE___STIFFENEDGASSERVICEBASE_H
