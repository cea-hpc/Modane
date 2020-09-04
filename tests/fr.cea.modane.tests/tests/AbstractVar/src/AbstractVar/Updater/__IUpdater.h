#ifndef ABSTRACTVAR_UPDATER___IUPDATER_H
#define ABSTRACTVAR_UPDATER___IUPDATER_H

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
namespace AbstractVarUpdater {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Updater
 * 
 */
class IUpdater
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IUpdater() {}
  virtual ~IUpdater() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li UpdaterImplServiceBase::updatePressure
  */
  virtual void updatePressure(VariableCellReal& abstract_pressure) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li UpdaterImplServiceBase::updatePressureWithParam
  */
  virtual void updatePressureWithParam(VariableCellReal& abstract_pressure, const Real alpha) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li UpdaterImplServiceBase::updateOldPressure
  */
  virtual void updateOldPressure() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace AbstractVarUpdater

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // ABSTRACTVAR_UPDATER___IUPDATER_H
