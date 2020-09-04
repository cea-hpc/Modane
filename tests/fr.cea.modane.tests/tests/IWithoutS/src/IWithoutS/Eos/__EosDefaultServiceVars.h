#ifndef IWITHOUTS_EOS___EOSDEFAULTSERVICEVARS_H
#define IWITHOUTS_EOS___EOSDEFAULTSERVICEVARS_H

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

//! Classe de variable pour computeSequential
struct EosDefaultComputeSequentialVars final
{
  EosDefaultComputeSequentialVars()
  {}
};

//! Classe de variable pour computeParallel
struct EosDefaultComputeParallelVars final
{
  EosDefaultComputeParallelVars()
  {}
};

//! Classe de variable pour computeByItemType
struct EosDefaultComputeByItemTypeVars final
{
  EosDefaultComputeByItemTypeVars()
  {}
};

//! Classe de variable pour computeByEnvCell
struct EosDefaultComputeByEnvCellVars final
{
  EosDefaultComputeByEnvCellVars()
  {}
};

//! Classe de variable pour computeByMatCell
struct EosDefaultComputeByMatCellVars final
{
  EosDefaultComputeByMatCellVars()
  {}
};

//! Classe de variable pour getSequentialCpt
struct EosDefaultGetSequentialCptVars final
{
  EosDefaultGetSequentialCptVars()
  {}
};

//! Classe de variable pour getParallelCpt
struct EosDefaultGetParallelCptVars final
{
  EosDefaultGetParallelCptVars()
  {}
};

//! Classe de variable pour getItemTypeCpt
struct EosDefaultGetItemTypeCptVars final
{
  EosDefaultGetItemTypeCptVars()
  {}
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSEos

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_EOS___EOSDEFAULTSERVICEVARS_H
