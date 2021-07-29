#ifndef MICROHYDRO___DEFAULTLOOPDELEGATIONSERVICEBASE_H
#define MICROHYDRO___DEFAULTLOOPDELEGATIONSERVICEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "arcane/Concurrency.h"
#include "MicroHydro/__ILoopDelegation.h"
#include "MicroHydro/__DefaultLoopDelegationServiceVars.h"
#include "MicroHydro/__BoundaryConditionType.h"
#include "MicroHydro/DefaultLoopDelegation_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace MicroHydro {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service DefaultLoopDelegation : classe de base. 
 * 
 */
template<class T>
class DefaultLoopDelegationServiceBase
: public ArcaneDefaultLoopDelegationObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit DefaultLoopDelegationServiceBase(const ServiceBuildInfo& bi)
  : ArcaneDefaultLoopDelegationObject(bi)
  {
  }

  virtual ~DefaultLoopDelegationServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "DefaultLoopDelegationService"; }

 public:  // ***** METHODES CONCRETES
  /*!
   \dot
     digraph computeNodeImpulsionGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         computeNodeImpulsion [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="node_mass | force | velocity"];
         inVars -> computeNodeImpulsion;
         outVars [shape="record", label="velocity"];
         computeNodeImpulsion -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle DefaultLoopDelegationService::computeNodeImpulsion.
  */
  void computeNodeImpulsion(const NodeVectorView items) override
  {
    DefaultLoopDelegationComputeNodeImpulsionVars vars(m_node_mass
        , m_force
        , m_velocity);
    T* t = static_cast<T*>(this);
    arcaneParallelForeach(items, [&](NodeVectorView sub_items)
    {
      ENUMERATE_NODE (iitem, sub_items) {
        const Node item = *iitem;
        t->computeNodeImpulsion(item, vars);
      }
    });
  }

  /*!
   \dot
     digraph applyBoundaryConditionGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         applyBoundaryCondition [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="velocity"];
         inVars -> applyBoundaryCondition;
         outVars [shape="record", label="velocity"];
         applyBoundaryCondition -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle DefaultLoopDelegationService::applyBoundaryCondition.
  */
  void applyBoundaryCondition(const FaceVectorView items, const Real boundary_condition_value, const BoundaryConditionType boundary_condition_type) override
  {
    DefaultLoopDelegationApplyBoundaryConditionVars vars(m_velocity);
    T* t = static_cast<T*>(this);
    arcaneParallelForeach(items, [&](FaceVectorView sub_items)
    {
      ENUMERATE_FACE (iitem, sub_items) {
        const Face item = *iitem;
        t->applyBoundaryCondition(item, vars, boundary_condition_value, boundary_condition_type);
      }
    });
  }

  /*!
   \dot
     digraph moveNodesGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         moveNodes [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="velocity"];
         inVars -> moveNodes;
         outVars [shape="record", label="node_coord"];
         moveNodes -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle DefaultLoopDelegationService::moveNodes.
  */
  void moveNodes(const NodeVectorView items) override
  {
    DefaultLoopDelegationMoveNodesVars vars(m_velocity
        , m_node_coord);
    T* t = static_cast<T*>(this);
    arcaneParallelForeach(items, [&](NodeVectorView sub_items)
    {
      ENUMERATE_NODE (iitem, sub_items) {
        const Node item = *iitem;
        t->moveNodes(item, vars);
      }
    });
  }

  /*!
   \dot
     digraph computeGeometricValuesGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         computeGeometricValues [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="node_coord | old_cell_volume | cell_volume | cell_cqs"];
         inVars -> computeGeometricValues;
         outVars [shape="record", label="old_cell_volume | cell_volume | caracteristic_length | cell_cqs"];
         computeGeometricValues -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle DefaultLoopDelegationService::computeGeometricValues.
  */
  void computeGeometricValues(const CellVectorView items) override
  {
    DefaultLoopDelegationComputeGeometricValuesVars vars(m_node_coord
        , m_old_cell_volume
        , m_cell_volume
        , m_caracteristic_length
        , m_cell_cqs);
    T* t = static_cast<T*>(this);
    arcaneParallelForeach(items, [&](CellVectorView sub_items)
    {
      ENUMERATE_CELL (iitem, sub_items) {
        const Cell item = *iitem;
        t->computeGeometricValues(item, vars);
      }
    });
  }

  /*!
   \dot
     digraph updateDensityGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         updateDensity [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="cell_mass | cell_volume"];
         inVars -> updateDensity;
         outVars [shape="record", label="density"];
         updateDensity -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle DefaultLoopDelegationService::updateDensity.
  */
  void updateDensity(const CellVectorView items) override
  {
    DefaultLoopDelegationUpdateDensityVars vars(m_cell_mass
        , m_cell_volume
        , m_density);
    T* t = static_cast<T*>(this);
    arcaneParallelForeach(items, [&](CellVectorView sub_items)
    {
      ENUMERATE_CELL (iitem, sub_items) {
        const Cell item = *iitem;
        t->updateDensity(item, vars);
      }
    });
  }

  /*!
   \dot
     digraph computeInternalEnergyGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         computeInternalEnergy [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="cell_volume | old_cell_volume | adiabatic_cst"];
         inVars -> computeInternalEnergy;
         outVars [shape="record", label="internal_energy"];
         computeInternalEnergy -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle DefaultLoopDelegationService::computeInternalEnergy.
  */
  void computeInternalEnergy(const CellVectorView items) override
  {
    DefaultLoopDelegationComputeInternalEnergyVars vars(m_cell_volume
        , m_old_cell_volume
        , m_adiabatic_cst
        , m_internal_energy);
    T* t = static_cast<T*>(this);
    arcaneParallelForeach(items, [&](CellVectorView sub_items)
    {
      ENUMERATE_CELL (iitem, sub_items) {
        const Cell item = *iitem;
        t->computeInternalEnergy(item, vars);
      }
    });
  }

  /*!
   \dot
     digraph computePressureForceGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         computePressureForce [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="pressure | cell_cqs"];
         inVars -> computePressureForce;
         outVars [shape="record", label="force"];
         computePressureForce -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle DefaultLoopDelegationService::computePressureForce.
  */
  void computePressureForce(const CellVectorView items) override
  {
    DefaultLoopDelegationComputePressureForceVars vars(m_pressure
        , m_cell_cqs
        , m_force);
    T* t = static_cast<T*>(this);
    ENUMERATE_CELL (iitem, items) {
      const Cell item = *iitem;
      t->computePressureForce(item, vars);
    }
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void computeNodeImpulsion(const Node node, DefaultLoopDelegationComputeNodeImpulsionVars& vars) = 0;
  virtual void applyBoundaryCondition(const Face face, DefaultLoopDelegationApplyBoundaryConditionVars& vars, const Real boundary_condition_value, const BoundaryConditionType boundary_condition_type) = 0;
  virtual void moveNodes(const Node node, DefaultLoopDelegationMoveNodesVars& vars) = 0;
  virtual void computeGeometricValues(const Cell cell, DefaultLoopDelegationComputeGeometricValuesVars& vars) = 0;
  virtual void updateDensity(const Cell cell, DefaultLoopDelegationUpdateDensityVars& vars) = 0;
  virtual void computeInternalEnergy(const Cell cell, DefaultLoopDelegationComputeInternalEnergyVars& vars) = 0;
  virtual void computePressureForce(const Cell cell, DefaultLoopDelegationComputePressureForceVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace MicroHydro

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // MICROHYDRO___DEFAULTLOOPDELEGATIONSERVICEBASE_H
