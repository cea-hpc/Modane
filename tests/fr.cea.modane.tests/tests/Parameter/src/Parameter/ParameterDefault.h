#ifndef PARAMETER_PARAMETERDEFAULT_H
#define PARAMETER_PARAMETERDEFAULT_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Parameter/__ParameterDefaultBase.h"
#include "Parameter/__IComplexType.h"
#include "Parameter/__EnumType.h"
#include "Parameter/__IInterfaceType.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace Parameter {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Parameter.Parameter : implémentation
 * 
 */
class ParameterDefault
: public ParameterDefaultBase<ParameterDefault>
{
 public:
	ParameterDefault(IMesh* mesh);
	~ParameterDefault();

 public:
	void compute(ParameterDefaultComputeVars& vars, const Real in_simple, ConstArrayView< Real > in_simples, Real& out_simple, Array< Real >& out_simples, const IComplexType* in_complex, ConstArrayView< IComplexType* > in_complexes, IComplexType* out_complex, Array< IComplexType* >& out_complexes, const Node in_item, CellVectorView in_items, Node& out_item, CellVector& out_items, const ItemGroup in_item_group, ConstArrayView< ItemGroup > in_item_groups, ItemGroup& out_item_group, Array< ItemGroup >& out_item_groups, const EnumType in_enum, EnumType& out_enum, ConstArrayView< EnumType > in_enums, Array< EnumType >& out_enums);
    void computeParticles(ParameterDefaultComputeParticlesVars& vars, const Particle in_particle, ParticleVectorView in_particles, Particle& out_particle, ParticleVector& out_particles);
    void computeComponentCells(ParameterDefaultComputeComponentCellsVars& vars, const ComponentCell in_component_cell, ComponentCellVectorView in_component_cells, ComponentCell& out_component_cell, ComponentCellVector& out_component_cells);
	Real getReal(ParameterDefaultGetRealVars& vars);
	SharedArray< Real > getReals(ParameterDefaultGetRealsVars& vars);
	Node getNode(ParameterDefaultGetNodeVars& vars);
	NodeVector getNodes(ParameterDefaultGetNodesVars& vars);
	IComplexType* getComplex(ParameterDefaultGetComplexVars& vars);
	SharedArray< IComplexType* > getComplexes(ParameterDefaultGetComplexesVars& vars);
	IInterfaceType* getInterface(ParameterDefaultGetInterfaceVars& vars);
	ItemGroup getItemGroup(ParameterDefaultGetItemGroupVars& vars);
	SharedArray< ItemGroup > getItemGroups(ParameterDefaultGetItemGroupsVars& vars);
	EnumType getEnum(ParameterDefaultGetEnumVars& vars);
	SharedArray< EnumType > getEnums(ParameterDefaultGetEnumsVars& vars);
	Particle getParticle(ParameterDefaultGetParticleVars& vars);
	ParticleVector getParticles(ParameterDefaultGetParticlesVars& vars);
	ParticleGroup getParticleGroup(ParameterDefaultGetParticleGroupVars& vars);
	SharedArray< ParticleGroup > getParticleGroups(ParameterDefaultGetParticleGroupsVars& vars);
	ComponentCell getComponentCell(ParameterDefaultGetComponentCellVars& vars);
	ComponentCellVector getComponentCells(ParameterDefaultGetComponentCellsVars& vars);
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} /* namespace Parameter */

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif /* PARAMETER_PARAMETERDEFAULT_H */
