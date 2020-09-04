#ifndef SUPPORT_EOS___PERFECTGASSERVICEVARS_H
#define SUPPORT_EOS___PERFECTGASSERVICEVARS_H

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

//! Classe de variable pour computeSequential
struct PerfectGasComputeSequentialVars final
{
  PerfectGasComputeSequentialVars()
  {}
};

//! Classe de variable pour computeParallel
struct PerfectGasComputeParallelVars final
{
  PerfectGasComputeParallelVars()
  {}
};

//! Classe de variable pour computeByItemType
struct PerfectGasComputeByItemTypeVars final
{
  PerfectGasComputeByItemTypeVars()
  {}
};

//! Classe de variable pour computeByMatCell
struct PerfectGasComputeByMatCellVars final
{
  PerfectGasComputeByMatCellVars()
  {}
};

//! Classe de variable pour computeByEnvCell
struct PerfectGasComputeByEnvCellVars final
{
  PerfectGasComputeByEnvCellVars()
  {}
};

//! Classe de variable pour computeByComponentCell
struct PerfectGasComputeByComponentCellVars final
{
  PerfectGasComputeByComponentCellVars()
  {}
};

//! Classe de variable pour computeByAllEnvCell
struct PerfectGasComputeByAllEnvCellVars final
{
  PerfectGasComputeByAllEnvCellVars()
  {}
};

//! Classe de variable pour computeByParticle
struct PerfectGasComputeByParticleVars final
{
  PerfectGasComputeByParticleVars()
  {}
};

//! Classe de variable pour computeByDof
struct PerfectGasComputeByDofVars final
{
  PerfectGasComputeByDofVars()
  {}
};

//! Classe de variable pour getParallelCpt
struct PerfectGasGetParallelCptVars final
{
  PerfectGasGetParallelCptVars()
  {}
};

//! Classe de variable pour getSequentialCpt
struct PerfectGasGetSequentialCptVars final
{
  PerfectGasGetSequentialCptVars()
  {}
};

//! Classe de variable pour getItemTypeCpt
struct PerfectGasGetItemTypeCptVars final
{
  PerfectGasGetItemTypeCptVars()
  {}
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace SupportEos

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SUPPORT_EOS___PERFECTGASSERVICEVARS_H
