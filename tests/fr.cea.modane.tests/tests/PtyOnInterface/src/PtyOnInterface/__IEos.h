#ifndef PTYONINTERFACE___IEOS_H
#define PTYONINTERFACE___IEOS_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "PtyOnInterface/__IMyStruct.h"
#include "PtyOnInterface/__IMyInterf.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace PtyOnInterface {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Eos
 * 
 */
class IEos
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IEos() {}
  virtual ~IEos() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;
  virtual Real getMyReal() = 0;
  virtual IMyStruct* getMyStruct() = 0;
  virtual IMyInterf* getMyInterf() = 0;
  virtual ConstArrayView< IMyStruct* > getMyStructs() = 0;
  virtual ConstArrayView< Integer > getMyIntegers() = 0;
  virtual Integer getMyOptInteger() = 0;
  virtual bool hasMyOptInteger() const = 0;

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li PerfectGasServiceBase::compute
  \li StiffenedGasServiceBase::compute
  */
  virtual void compute() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace PtyOnInterface

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PTYONINTERFACE___IEOS_H
