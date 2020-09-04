#ifndef IWITHOUTS_INTERFACES___NOPROPERTYINTERFDEFAULTVARS_H
#define IWITHOUTS_INTERFACES___NOPROPERTYINTERFDEFAULTVARS_H

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

//! Classe de variable pour computeSequential
struct NoPropertyInterfDefaultComputeSequentialVars final
{
  NoPropertyInterfDefaultComputeSequentialVars(const VariableCellReal& abstract_temperature,
      VariableCellReal& abstract_density)
  : m_abstract_temperature(abstract_temperature)
  , m_abstract_density(abstract_density)
  {}

  /*!
  [in] abstract_temperature
  */
  const VariableCellReal& m_abstract_temperature;
  /*!
  [out] abstract_density
  */
  VariableCellReal& m_abstract_density;
};

//! Classe de variable pour computeParallel
struct NoPropertyInterfDefaultComputeParallelVars final
{
  NoPropertyInterfDefaultComputeParallelVars(const VariableCellReal& abstract_temperature,
      VariableCellReal& abstract_density)
  : m_abstract_temperature(abstract_temperature)
  , m_abstract_density(abstract_density)
  {}

  /*!
  [in] abstract_temperature
  */
  const VariableCellReal& m_abstract_temperature;
  /*!
  [out] abstract_density
  */
  VariableCellReal& m_abstract_density;
};

//! Classe de variable pour computeByItemType
struct NoPropertyInterfDefaultComputeByItemTypeVars final
{
  NoPropertyInterfDefaultComputeByItemTypeVars(const VariableCellReal& abstract_temperature,
      VariableCellReal& abstract_density)
  : m_abstract_temperature(abstract_temperature)
  , m_abstract_density(abstract_density)
  {}

  /*!
  [in] abstract_temperature
  */
  const VariableCellReal& m_abstract_temperature;
  /*!
  [out] abstract_density
  */
  VariableCellReal& m_abstract_density;
};

//! Classe de variable pour computeByEnvCell
struct NoPropertyInterfDefaultComputeByEnvCellVars final
{
  NoPropertyInterfDefaultComputeByEnvCellVars()
  {}
};

//! Classe de variable pour computeByMatCell
struct NoPropertyInterfDefaultComputeByMatCellVars final
{
  NoPropertyInterfDefaultComputeByMatCellVars()
  {}
};

//! Classe de variable pour getSequentialCpt
struct NoPropertyInterfDefaultGetSequentialCptVars final
{
  NoPropertyInterfDefaultGetSequentialCptVars()
  {}
};

//! Classe de variable pour getParallelCpt
struct NoPropertyInterfDefaultGetParallelCptVars final
{
  NoPropertyInterfDefaultGetParallelCptVars()
  {}
};

//! Classe de variable pour getItemTypeCpt
struct NoPropertyInterfDefaultGetItemTypeCptVars final
{
  NoPropertyInterfDefaultGetItemTypeCptVars()
  {}
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSInterfaces

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_INTERFACES___NOPROPERTYINTERFDEFAULTVARS_H
