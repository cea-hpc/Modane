#ifndef IWITHOUTS_INTERFACES___IREFPROPERTYINTERF_H
#define IWITHOUTS_INTERFACES___IREFPROPERTYINTERF_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "IWithoutS/Interfaces/__INoPropertyInterf.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace IWithoutSInterfaces {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface RefPropertyInterf
 * 
 */
class IRefPropertyInterf
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IRefPropertyInterf() {}
  virtual ~IRefPropertyInterf() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;
  virtual INoPropertyInterf* getNoPropertyInterf() = 0;

 public:  // ***** METHODES ABSTRAITES
  virtual void compute(const VariableCellReal& abstract_temperature, VariableCellReal& abstract_density) = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSInterfaces

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_INTERFACES___IREFPROPERTYINTERF_H
