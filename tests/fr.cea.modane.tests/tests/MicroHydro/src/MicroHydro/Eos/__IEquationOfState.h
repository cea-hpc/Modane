#ifndef MICROHYDRO_EOS___IEQUATIONOFSTATE_H
#define MICROHYDRO_EOS___IEQUATIONOFSTATE_H

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
namespace MicroHydroEos {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface EquationOfState
 * 
 */
class IEquationOfState
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IEquationOfState() {}
  virtual ~IEquationOfState() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li PerfectGasServiceBase::initEOS
  \li StiffenedGasServiceBase::initEOS
  */
  virtual void initEOS(const CellVectorView items) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li PerfectGasServiceBase::applyEOS
  \li StiffenedGasServiceBase::applyEOS
  */
  virtual void applyEOS(const CellVectorView items) = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace MicroHydroEos

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // MICROHYDRO_EOS___IEQUATIONOFSTATE_H
