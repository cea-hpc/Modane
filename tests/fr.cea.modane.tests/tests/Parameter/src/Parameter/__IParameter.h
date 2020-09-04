#ifndef PARAMETER___IPARAMETER_H
#define PARAMETER___IPARAMETER_H

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
#include "Parameter/__EnumType.h"
#include "Parameter/__IComplexType.h"
#include "Parameter/__IInterfaceType.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace Parameter {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Parameter
 * 
 */
class IParameter
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IParameter() {}
  virtual ~IParameter() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;

 public:  // ***** METHODES ABSTRAITES
  virtual void compute(const Real in_simple, ConstArrayView< Real > in_simples, Real& out_simple, Array< Real >& out_simples, const IComplexType* in_complex, ConstArrayView< IComplexType* > in_complexes, IComplexType* out_complex, Array< IComplexType* >& out_complexes, const Node in_item, CellVectorView in_items, Node& out_item, CellVector& out_items, const ItemGroup in_item_group, ConstArrayView< ItemGroup > in_item_groups, ItemGroup& out_item_group, Array< ItemGroup >& out_item_groups, const EnumType in_enum, EnumType& out_enum, ConstArrayView< EnumType > in_enums, Array< EnumType >& out_enums) = 0;
  virtual void computeParticles(const Particle in_particle, ParticleVectorView in_particles, Particle& out_particle, ParticleVector& out_particles) = 0;
  virtual void computeComponentCells(const ComponentCell in_component_cell, ComponentCellVectorView in_component_cells, ComponentCell& out_component_cell, ComponentCellVector& out_component_cells) = 0;
  virtual Real getReal() = 0;
  virtual SharedArray< Real > getReals() = 0;
  virtual Node getNode() = 0;
  virtual NodeVector getNodes() = 0;
  virtual IComplexType* getComplex() = 0;
  virtual SharedArray< IComplexType* > getComplexes() = 0;
  virtual IInterfaceType* getInterface() = 0;
  virtual ItemGroup getItemGroup() = 0;
  virtual SharedArray< ItemGroup > getItemGroups() = 0;
  virtual EnumType getEnum() = 0;
  virtual SharedArray< EnumType > getEnums() = 0;
  virtual Particle getParticle() = 0;
  virtual ParticleVector getParticles() = 0;
  virtual ParticleGroup getParticleGroup() = 0;
  virtual SharedArray< ParticleGroup > getParticleGroups() = 0;
  virtual ComponentCell getComponentCell() = 0;
  virtual ComponentCellVector getComponentCells() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Parameter

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PARAMETER___IPARAMETER_H
