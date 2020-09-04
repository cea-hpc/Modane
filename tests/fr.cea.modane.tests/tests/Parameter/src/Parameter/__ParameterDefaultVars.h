#ifndef PARAMETER___PARAMETERDEFAULTVARS_H
#define PARAMETER___PARAMETERDEFAULTVARS_H

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
namespace Parameter {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

//! Classe de variable pour compute
struct ParameterDefaultComputeVars final
{
  ParameterDefaultComputeVars()
  {}
};

//! Classe de variable pour computeParticles
struct ParameterDefaultComputeParticlesVars final
{
  ParameterDefaultComputeParticlesVars()
  {}
};

//! Classe de variable pour computeComponentCells
struct ParameterDefaultComputeComponentCellsVars final
{
  ParameterDefaultComputeComponentCellsVars()
  {}
};

//! Classe de variable pour getReal
struct ParameterDefaultGetRealVars final
{
  ParameterDefaultGetRealVars()
  {}
};

//! Classe de variable pour getReals
struct ParameterDefaultGetRealsVars final
{
  ParameterDefaultGetRealsVars()
  {}
};

//! Classe de variable pour getNode
struct ParameterDefaultGetNodeVars final
{
  ParameterDefaultGetNodeVars()
  {}
};

//! Classe de variable pour getNodes
struct ParameterDefaultGetNodesVars final
{
  ParameterDefaultGetNodesVars()
  {}
};

//! Classe de variable pour getComplex
struct ParameterDefaultGetComplexVars final
{
  ParameterDefaultGetComplexVars()
  {}
};

//! Classe de variable pour getComplexes
struct ParameterDefaultGetComplexesVars final
{
  ParameterDefaultGetComplexesVars()
  {}
};

//! Classe de variable pour getInterface
struct ParameterDefaultGetInterfaceVars final
{
  ParameterDefaultGetInterfaceVars()
  {}
};

//! Classe de variable pour getItemGroup
struct ParameterDefaultGetItemGroupVars final
{
  ParameterDefaultGetItemGroupVars()
  {}
};

//! Classe de variable pour getItemGroups
struct ParameterDefaultGetItemGroupsVars final
{
  ParameterDefaultGetItemGroupsVars()
  {}
};

//! Classe de variable pour getEnum
struct ParameterDefaultGetEnumVars final
{
  ParameterDefaultGetEnumVars()
  {}
};

//! Classe de variable pour getEnums
struct ParameterDefaultGetEnumsVars final
{
  ParameterDefaultGetEnumsVars()
  {}
};

//! Classe de variable pour getParticle
struct ParameterDefaultGetParticleVars final
{
  ParameterDefaultGetParticleVars()
  {}
};

//! Classe de variable pour getParticles
struct ParameterDefaultGetParticlesVars final
{
  ParameterDefaultGetParticlesVars()
  {}
};

//! Classe de variable pour getParticleGroup
struct ParameterDefaultGetParticleGroupVars final
{
  ParameterDefaultGetParticleGroupVars()
  {}
};

//! Classe de variable pour getParticleGroups
struct ParameterDefaultGetParticleGroupsVars final
{
  ParameterDefaultGetParticleGroupsVars()
  {}
};

//! Classe de variable pour getComponentCell
struct ParameterDefaultGetComponentCellVars final
{
  ParameterDefaultGetComponentCellVars()
  {}
};

//! Classe de variable pour getComponentCells
struct ParameterDefaultGetComponentCellsVars final
{
  ParameterDefaultGetComponentCellsVars()
  {}
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Parameter

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PARAMETER___PARAMETERDEFAULTVARS_H
