#include "Parameter/ParameterDefault.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace Parameter {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ParameterDefault::
ParameterDefault(IMesh* mesh)
: ParameterDefaultBase<ParameterDefault>(mesh)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ParameterDefault::
~ParameterDefault()
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void ParameterDefault::
compute(ParameterDefaultComputeVars& vars, const Real in_simple, ConstArrayView< Real > in_simples, Real& out_simple, Array< Real >& out_simples, const IComplexType* in_complex, ConstArrayView< IComplexType* > in_complexes, IComplexType* out_complex, Array< IComplexType* >& out_complexes, const Node in_item, CellVectorView in_items, Node& out_item, CellVector& out_items, const ItemGroup in_item_group, ConstArrayView< ItemGroup > in_item_groups, ItemGroup& out_item_group, Array< ItemGroup >& out_item_groups, const EnumType in_enum, EnumType& out_enum, ConstArrayView< EnumType > in_enums, Array< EnumType >& out_enums)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void ParameterDefault::
computeParticles(ParameterDefaultComputeParticlesVars& vars, const Particle in_particle, ParticleVectorView in_particles, Particle& out_particle, ParticleVector& out_particles)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void ParameterDefault::
computeComponentCells(ParameterDefaultComputeComponentCellsVars& vars, const ComponentCell in_component_cell, ComponentCellVectorView in_component_cells, ComponentCell& out_component_cell, ComponentCellVector& out_component_cells)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

Real ParameterDefault::
getReal(ParameterDefaultGetRealVars& vars)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

SharedArray< Real > ParameterDefault::
getReals(ParameterDefaultGetRealsVars& vars)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

Node ParameterDefault::
getNode(ParameterDefaultGetNodeVars& vars)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

NodeVector ParameterDefault::
getNodes(ParameterDefaultGetNodesVars& vars)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

IComplexType* ParameterDefault::
getComplex(ParameterDefaultGetComplexVars& vars)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

SharedArray< IComplexType* > ParameterDefault::
getComplexes(ParameterDefaultGetComplexesVars& vars)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

IInterfaceType* ParameterDefault::
getInterface(ParameterDefaultGetInterfaceVars& vars)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ItemGroup ParameterDefault::
getItemGroup(ParameterDefaultGetItemGroupVars& vars)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

SharedArray< ItemGroup > ParameterDefault::
getItemGroups(ParameterDefaultGetItemGroupsVars& vars)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

EnumType ParameterDefault::
getEnum(ParameterDefaultGetEnumVars& vars)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

SharedArray< EnumType > ParameterDefault::
getEnums(ParameterDefaultGetEnumsVars& vars)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

Particle ParameterDefault::
getParticle(ParameterDefaultGetParticleVars& vars)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ParticleVector ParameterDefault::
getParticles(ParameterDefaultGetParticlesVars& vars)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ParticleGroup ParameterDefault::
getParticleGroup(ParameterDefaultGetParticleGroupVars& vars)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

SharedArray< ParticleGroup > ParameterDefault::
getParticleGroups(ParameterDefaultGetParticleGroupsVars& vars)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ComponentCell ParameterDefault::
getComponentCell(ParameterDefaultGetComponentCellVars& vars)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ComponentCellVector ParameterDefault::
getComponentCells(ParameterDefaultGetComponentCellsVars& vars)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} /* namespace Parameter */
