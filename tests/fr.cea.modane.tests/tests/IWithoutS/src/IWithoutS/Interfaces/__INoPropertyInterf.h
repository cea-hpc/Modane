#ifndef IWITHOUTS_INTERFACES___INOPROPERTYINTERF_H
#define IWITHOUTS_INTERFACES___INOPROPERTYINTERF_H

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

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace IWithoutSInterfaces {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface NoPropertyInterf
 * 
 */
class INoPropertyInterf
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  INoPropertyInterf() {}
  virtual ~INoPropertyInterf() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;

 public:  // ***** METHODES ABSTRAITES
  virtual void computeSequential(const CellVectorView items, const VariableCellReal& abstract_temperature, VariableCellReal& abstract_density, const Real coef) = 0;
  virtual void computeParallel(const CellVectorView items, const VariableCellReal& abstract_temperature, VariableCellReal& abstract_density, const Real coef) = 0;
  virtual void computeByItemType(const ItemGroup& items, const VariableCellReal& abstract_temperature, VariableCellReal& abstract_density, const Real coef) = 0;
  virtual void computeByEnvCell(const EnvCellVectorView items, const Real coef) = 0;
  virtual void computeByMatCell(const MatCellVectorView items, const Real coef) = 0;
  virtual Integer getSequentialCpt() = 0;
  virtual Integer getParallelCpt() = 0;
  virtual Integer getItemTypeCpt() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSInterfaces

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_INTERFACES___INOPROPERTYINTERF_H
