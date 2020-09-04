#ifndef PTYONINTERFACE___PERFECTGASSERVICEBASE_H
#define PTYONINTERFACE___PERFECTGASSERVICEBASE_H

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
#include "PtyOnInterface/__PerfectGasServiceVars.h"
#include "PtyOnInterface/__IMyStruct.h"
#include "PtyOnInterface/__IMyInterf.h"
#include "PtyOnInterface/PerfectGas_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace PtyOnInterface {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service PerfectGas : classe de base. 
 * 
 */
template<class T>
class PerfectGasServiceBase
: public ArcanePerfectGasObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit PerfectGasServiceBase(const ServiceBuildInfo& bi)
  : ArcanePerfectGasObject(bi)
  {
  }

  virtual ~PerfectGasServiceBase()
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
  Real getPressureCoef() { return options()->getPressureCoef(); }
  const String getImplName() const { return "PerfectGasService"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle PerfectGasService::compute.
  */
  void compute() override
  {
    PerfectGasComputeVars vars;
    this->compute(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void compute(PerfectGasComputeVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace PtyOnInterface

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PTYONINTERFACE___PERFECTGASSERVICEBASE_H
