#ifndef PARAMETER___PARAMETERDEFAULTBASE_H
#define PARAMETER___PARAMETERDEFAULTBASE_H

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
#include "arcane/IMesh.h"
#include "arcane/MeshAccessor.h"
#include "arcane/utils/TraceAccessor.h"
#include "Parameter/__IParameter.h"
#include "Parameter/__ParameterDefaultVars.h"
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
 * \brief Interface Parameter : classe de base. 
 * 
 */
template<class T>
class ParameterDefaultBase
: public IParameter
, public TraceAccessor
, public MeshAccessor
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit ParameterDefaultBase(IMesh* mesh) 
  : TraceAccessor(mesh->traceMng())
  , MeshAccessor(mesh)
  , m_mesh_material_mng(IMeshMaterialMng::getReference(mesh))
  {
  }

  virtual ~ParameterDefaultBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "ParameterDefault"; }
  IMeshMaterialMng* getMeshMaterialMng() const { return m_mesh_material_mng; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle ParameterDefault::compute.
  */
  void compute(const Real in_simple, ConstArrayView< Real > in_simples, Real& out_simple, Array< Real >& out_simples, const IComplexType* in_complex, ConstArrayView< IComplexType* > in_complexes, IComplexType* out_complex, Array< IComplexType* >& out_complexes, const Node in_item, CellVectorView in_items, Node& out_item, CellVector& out_items, const ItemGroup in_item_group, ConstArrayView< ItemGroup > in_item_groups, ItemGroup& out_item_group, Array< ItemGroup >& out_item_groups, const EnumType in_enum, EnumType& out_enum, ConstArrayView< EnumType > in_enums, Array< EnumType >& out_enums)
  {
    ParameterDefaultComputeVars vars;
    this->compute(vars, in_simple, in_simples, out_simple, out_simples, in_complex, in_complexes, out_complex, out_complexes, in_item, in_items, out_item, out_items, in_item_group, in_item_groups, out_item_group, out_item_groups, in_enum, out_enum, in_enums, out_enums);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::computeParticles.
  */
  void computeParticles(const Particle in_particle, ParticleVectorView in_particles, Particle& out_particle, ParticleVector& out_particles)
  {
    ParameterDefaultComputeParticlesVars vars;
    this->computeParticles(vars, in_particle, in_particles, out_particle, out_particles);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::computeComponentCells.
  */
  void computeComponentCells(const ComponentCell in_component_cell, ComponentCellVectorView in_component_cells, ComponentCell& out_component_cell, ComponentCellVector& out_component_cells)
  {
    ParameterDefaultComputeComponentCellsVars vars;
    this->computeComponentCells(vars, in_component_cell, in_component_cells, out_component_cell, out_component_cells);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::getReal.
  */
  Real getReal()
  {
    ParameterDefaultGetRealVars vars;
    return this->getReal(vars);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::getReals.
  */
  SharedArray< Real > getReals()
  {
    ParameterDefaultGetRealsVars vars;
    return this->getReals(vars);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::getNode.
  */
  Node getNode()
  {
    ParameterDefaultGetNodeVars vars;
    return this->getNode(vars);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::getNodes.
  */
  NodeVector getNodes()
  {
    ParameterDefaultGetNodesVars vars;
    return this->getNodes(vars);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::getComplex.
  */
  IComplexType* getComplex()
  {
    ParameterDefaultGetComplexVars vars;
    return this->getComplex(vars);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::getComplexes.
  */
  SharedArray< IComplexType* > getComplexes()
  {
    ParameterDefaultGetComplexesVars vars;
    return this->getComplexes(vars);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::getInterface.
  */
  IInterfaceType* getInterface()
  {
    ParameterDefaultGetInterfaceVars vars;
    return this->getInterface(vars);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::getItemGroup.
  */
  ItemGroup getItemGroup()
  {
    ParameterDefaultGetItemGroupVars vars;
    return this->getItemGroup(vars);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::getItemGroups.
  */
  SharedArray< ItemGroup > getItemGroups()
  {
    ParameterDefaultGetItemGroupsVars vars;
    return this->getItemGroups(vars);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::getEnum.
  */
  EnumType getEnum()
  {
    ParameterDefaultGetEnumVars vars;
    return this->getEnum(vars);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::getEnums.
  */
  SharedArray< EnumType > getEnums()
  {
    ParameterDefaultGetEnumsVars vars;
    return this->getEnums(vars);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::getParticle.
  */
  Particle getParticle()
  {
    ParameterDefaultGetParticleVars vars;
    return this->getParticle(vars);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::getParticles.
  */
  ParticleVector getParticles()
  {
    ParameterDefaultGetParticlesVars vars;
    return this->getParticles(vars);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::getParticleGroup.
  */
  ParticleGroup getParticleGroup()
  {
    ParameterDefaultGetParticleGroupVars vars;
    return this->getParticleGroup(vars);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::getParticleGroups.
  */
  SharedArray< ParticleGroup > getParticleGroups()
  {
    ParameterDefaultGetParticleGroupsVars vars;
    return this->getParticleGroups(vars);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::getComponentCell.
  */
  ComponentCell getComponentCell()
  {
    ParameterDefaultGetComponentCellVars vars;
    return this->getComponentCell(vars);
  }

  /*!
   Cette méthode construit les variables et appelle ParameterDefault::getComponentCells.
  */
  ComponentCellVector getComponentCells()
  {
    ParameterDefaultGetComponentCellsVars vars;
    return this->getComponentCells(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void compute(ParameterDefaultComputeVars& vars, const Real in_simple, ConstArrayView< Real > in_simples, Real& out_simple, Array< Real >& out_simples, const IComplexType* in_complex, ConstArrayView< IComplexType* > in_complexes, IComplexType* out_complex, Array< IComplexType* >& out_complexes, const Node in_item, CellVectorView in_items, Node& out_item, CellVector& out_items, const ItemGroup in_item_group, ConstArrayView< ItemGroup > in_item_groups, ItemGroup& out_item_group, Array< ItemGroup >& out_item_groups, const EnumType in_enum, EnumType& out_enum, ConstArrayView< EnumType > in_enums, Array< EnumType >& out_enums) = 0;
  virtual void computeParticles(ParameterDefaultComputeParticlesVars& vars, const Particle in_particle, ParticleVectorView in_particles, Particle& out_particle, ParticleVector& out_particles) = 0;
  virtual void computeComponentCells(ParameterDefaultComputeComponentCellsVars& vars, const ComponentCell in_component_cell, ComponentCellVectorView in_component_cells, ComponentCell& out_component_cell, ComponentCellVector& out_component_cells) = 0;
  virtual Real getReal(ParameterDefaultGetRealVars& vars) = 0;
  virtual SharedArray< Real > getReals(ParameterDefaultGetRealsVars& vars) = 0;
  virtual Node getNode(ParameterDefaultGetNodeVars& vars) = 0;
  virtual NodeVector getNodes(ParameterDefaultGetNodesVars& vars) = 0;
  virtual IComplexType* getComplex(ParameterDefaultGetComplexVars& vars) = 0;
  virtual SharedArray< IComplexType* > getComplexes(ParameterDefaultGetComplexesVars& vars) = 0;
  virtual IInterfaceType* getInterface(ParameterDefaultGetInterfaceVars& vars) = 0;
  virtual ItemGroup getItemGroup(ParameterDefaultGetItemGroupVars& vars) = 0;
  virtual SharedArray< ItemGroup > getItemGroups(ParameterDefaultGetItemGroupsVars& vars) = 0;
  virtual EnumType getEnum(ParameterDefaultGetEnumVars& vars) = 0;
  virtual SharedArray< EnumType > getEnums(ParameterDefaultGetEnumsVars& vars) = 0;
  virtual Particle getParticle(ParameterDefaultGetParticleVars& vars) = 0;
  virtual ParticleVector getParticles(ParameterDefaultGetParticlesVars& vars) = 0;
  virtual ParticleGroup getParticleGroup(ParameterDefaultGetParticleGroupVars& vars) = 0;
  virtual SharedArray< ParticleGroup > getParticleGroups(ParameterDefaultGetParticleGroupsVars& vars) = 0;
  virtual ComponentCell getComponentCell(ParameterDefaultGetComponentCellVars& vars) = 0;
  virtual ComponentCellVector getComponentCells(ParameterDefaultGetComponentCellsVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
  IMeshMaterialMng* m_mesh_material_mng;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Parameter

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PARAMETER___PARAMETERDEFAULTBASE_H
