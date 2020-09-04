#ifndef SUPPORT_EOS___IEOS_H
#define SUPPORT_EOS___IEOS_H

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
namespace SupportEos {

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

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li PerfectGasServiceBase::computeSequential
  */
  virtual void computeSequential(const CellVectorView items, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li PerfectGasServiceBase::computeParallel
  */
  virtual void computeParallel(const CellVectorView items, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li PerfectGasServiceBase::computeByItemType
  */
  virtual void computeByItemType(const ItemGroup& items, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li PerfectGasServiceBase::computeByMatCell
  */
  virtual void computeByMatCell(const MatCellVectorView items, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li PerfectGasServiceBase::computeByEnvCell
  */
  virtual void computeByEnvCell(const EnvCellVectorView items, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li PerfectGasServiceBase::computeByComponentCell
  */
  virtual void computeByComponentCell(const ComponentCellVectorView items, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li PerfectGasServiceBase::computeByAllEnvCell
  */
  virtual void computeByAllEnvCell(const AllEnvCellVectorView items, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li PerfectGasServiceBase::computeByParticle
  */
  virtual void computeByParticle(const ParticleVectorView items, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li PerfectGasServiceBase::computeByDof
  */
  virtual void computeByDof(const DoFVectorView items, const Real coef) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li PerfectGasServiceBase::getSequentialCpt
  */
  virtual Integer getSequentialCpt() = 0;
  /*!
  Cette méthode est implémentée dans :
  \li PerfectGasServiceBase::getParallelCpt
  */
  virtual Integer getParallelCpt() = 0;
  /*!
  Cette méthode est implémentée dans :
  \li PerfectGasServiceBase::getItemTypeCpt
  */
  virtual Integer getItemTypeCpt() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace SupportEos

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SUPPORT_EOS___IEOS_H
