#ifndef IWITHOUTS_INTERFACES___NOPROPERTYINTERFVIASTRUCTDEFAULTSERVICEVARS_H
#define IWITHOUTS_INTERFACES___NOPROPERTYINTERFVIASTRUCTDEFAULTSERVICEVARS_H

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
struct NoPropertyInterfViaStructDefaultComputeSequentialVars final
{
  NoPropertyInterfViaStructDefaultComputeSequentialVars(const VariableCellReal& abstract_temperature,
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
struct NoPropertyInterfViaStructDefaultComputeParallelVars final
{
  NoPropertyInterfViaStructDefaultComputeParallelVars(const VariableCellReal& abstract_temperature,
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
struct NoPropertyInterfViaStructDefaultComputeByItemTypeVars final
{
  NoPropertyInterfViaStructDefaultComputeByItemTypeVars(const VariableCellReal& abstract_temperature,
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
struct NoPropertyInterfViaStructDefaultComputeByEnvCellVars final
{
  NoPropertyInterfViaStructDefaultComputeByEnvCellVars()
  {}
};

//! Classe de variable pour computeByMatCell
struct NoPropertyInterfViaStructDefaultComputeByMatCellVars final
{
  NoPropertyInterfViaStructDefaultComputeByMatCellVars()
  {}
};

//! Classe de variable pour getSequentialCpt
struct NoPropertyInterfViaStructDefaultGetSequentialCptVars final
{
  NoPropertyInterfViaStructDefaultGetSequentialCptVars()
  {}
};

//! Classe de variable pour getParallelCpt
struct NoPropertyInterfViaStructDefaultGetParallelCptVars final
{
  NoPropertyInterfViaStructDefaultGetParallelCptVars()
  {}
};

//! Classe de variable pour getItemTypeCpt
struct NoPropertyInterfViaStructDefaultGetItemTypeCptVars final
{
  NoPropertyInterfViaStructDefaultGetItemTypeCptVars()
  {}
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSInterfaces

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_INTERFACES___NOPROPERTYINTERFVIASTRUCTDEFAULTSERVICEVARS_H
