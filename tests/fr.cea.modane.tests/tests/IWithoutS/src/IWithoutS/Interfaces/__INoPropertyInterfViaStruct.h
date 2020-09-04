#ifndef IWITHOUTS_INTERFACES___INOPROPERTYINTERFVIASTRUCT_H
#define IWITHOUTS_INTERFACES___INOPROPERTYINTERFVIASTRUCT_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "arcane/materials/ComponentItemVector.h"
#include "arcane/materials/ComponentItemVectorView.h"
#include "arcane/materials/MeshEnvironmentVariableRef.h"
#include "arcane/materials/MeshMaterialVariableRef.h"
#include "arcane/materials/IMeshMaterialMng.h"
#include "IWithoutS/Interfaces/__IRefPropertyInterf.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace IWithoutSInterfaces {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface NoPropertyInterfViaStruct
 * 
 */
class INoPropertyInterfViaStruct
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  INoPropertyInterfViaStruct() {}
  virtual ~INoPropertyInterfViaStruct() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;
  virtual IRefPropertyInterf* getRefPropertyInterf() = 0;
  virtual bool hasRefPropertyInterf() const = 0;

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li NoPropertyInterfViaStructDefaultServiceBase::computeSequential
  */
  virtual void computeSequential(const CellVectorView items, const VariableCellReal& abstract_temperature, VariableCellReal& abstract_density, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li NoPropertyInterfViaStructDefaultServiceBase::computeParallel
  */
  virtual void computeParallel(const CellVectorView items, const VariableCellReal& abstract_temperature, VariableCellReal& abstract_density, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li NoPropertyInterfViaStructDefaultServiceBase::computeByItemType
  */
  virtual void computeByItemType(const ItemGroup& items, const VariableCellReal& abstract_temperature, VariableCellReal& abstract_density, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li NoPropertyInterfViaStructDefaultServiceBase::computeByEnvCell
  */
  virtual void computeByEnvCell(const EnvCellVectorView items, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li NoPropertyInterfViaStructDefaultServiceBase::computeByMatCell
  */
  virtual void computeByMatCell(const MatCellVectorView items, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li NoPropertyInterfViaStructDefaultServiceBase::getSequentialCpt
  */
  virtual Integer getSequentialCpt() = 0;
  /*!
  Cette méthode est implémentée dans :
  \li NoPropertyInterfViaStructDefaultServiceBase::getParallelCpt
  */
  virtual Integer getParallelCpt() = 0;
  /*!
  Cette méthode est implémentée dans :
  \li NoPropertyInterfViaStructDefaultServiceBase::getItemTypeCpt
  */
  virtual Integer getItemTypeCpt() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSInterfaces

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_INTERFACES___INOPROPERTYINTERFVIASTRUCT_H
