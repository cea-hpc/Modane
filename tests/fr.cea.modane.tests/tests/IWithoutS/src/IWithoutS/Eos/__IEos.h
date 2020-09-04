#ifndef IWITHOUTS_EOS___IEOS_H
#define IWITHOUTS_EOS___IEOS_H

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
namespace IWithoutSEos {

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
  virtual Real getMyBidonOption() = 0;
  virtual bool hasMyBidonOption() const = 0;

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li EosDefaultServiceBase::computeSequential
  */
  virtual void computeSequential(const CellVectorView items, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li EosDefaultServiceBase::computeParallel
  */
  virtual void computeParallel(const CellVectorView items, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li EosDefaultServiceBase::computeByItemType
  */
  virtual void computeByItemType(const ItemGroup& items, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li EosDefaultServiceBase::computeByEnvCell
  */
  virtual void computeByEnvCell(const EnvCellVectorView items, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li EosDefaultServiceBase::computeByMatCell
  */
  virtual void computeByMatCell(const MatCellVectorView items, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li EosDefaultServiceBase::getSequentialCpt
  */
  virtual Integer getSequentialCpt() = 0;
  /*!
  Cette méthode est implémentée dans :
  \li EosDefaultServiceBase::getParallelCpt
  */
  virtual Integer getParallelCpt() = 0;
  /*!
  Cette méthode est implémentée dans :
  \li EosDefaultServiceBase::getItemTypeCpt
  */
  virtual Integer getItemTypeCpt() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSEos

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_EOS___IEOS_H
