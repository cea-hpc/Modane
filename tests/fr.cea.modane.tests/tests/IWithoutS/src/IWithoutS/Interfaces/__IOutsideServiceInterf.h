#ifndef IWITHOUTS_INTERFACES___IOUTSIDESERVICEINTERF_H
#define IWITHOUTS_INTERFACES___IOUTSIDESERVICEINTERF_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace IWithoutSInterfaces {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface OutsideServiceInterf
 * 
 */
class IOutsideServiceInterf
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IOutsideServiceInterf() {}
  virtual ~IOutsideServiceInterf() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;
  virtual Real getRealOption() = 0;
  virtual bool hasRealOption() const = 0;

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li OutsideServiceBase::compute
  */
  virtual void compute() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSInterfaces

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_INTERFACES___IOUTSIDESERVICEINTERF_H
