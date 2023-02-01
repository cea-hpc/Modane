#ifndef MICROHYDRO___MICROHYDROMODULEBASE_H
#define MICROHYDRO___MICROHYDROMODULEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "MicroHydro/__MicroHydroModuleVars.h"
#include "MicroHydro/__IBoundaryCondition.h"
#include "MicroHydro/Eos/__IEquationOfState.h"
#include "MicroHydro/__ILoopDelegation.h"
#include "MicroHydro/MicroHydro_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace MicroHydro {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Module MicroHydro : classe de base. 
 * 
 */
template<class T>
class MicroHydroModuleBase
: public ArcaneMicroHydroObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit MicroHydroModuleBase(const ModuleBuildInfo& bi)
  : ArcaneMicroHydroObject(bi)
  {
  }

  virtual ~MicroHydroModuleBase()
  {
  }

 public:  // ***** ACCESSEURS
  Real getDeltatMin() { return options()->getDeltatMin(); }
  Real getDeltatMax() { return options()->getDeltatMax(); }
  Real getDeltatInit() { return options()->getDeltatInit(); }
  Real getFinalTime() { return options()->getFinalTime(); }
  Real getCfl() { return options()->getCfl(); }
  ConstArrayView< IBoundaryCondition* > getBoundaryCondition() { return options()->getBoundaryCondition(); }
  ::MicroHydroEos::IEquationOfState* getEosModel() { return options()->getEosModel(); }
  ILoopDelegation* getLoopDelegation() { return options()->getLoopDelegation(); }
  VersionInfo versionInfo() const { return VersionInfo("1.0"); }

 public:  // ***** METHODES CONCRETES
  /*!
   \dot
     digraph hydroStartInitGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         hydroStartInit [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="density | cell_cqs"];
         inVars -> hydroStartInit;
         outVars [shape="record", label="cell_cqs | cell_mass | node_mass | old_cell_volume | caracteristic_length | cell_volume | node_coord"];
         hydroStartInit -> outVars;
       }
   
       subgraph clusterCalledFuncs
       {
         center="true";
         color="navy";
         IEquationOfState_initEOS [label="initEOS", color="navy", fontcolor="navy", style="rounded", URL="\ref MicroHydroEos::IEquationOfState::initEOS"];
       }
       hydroStartInit -> IEquationOfState_initEOS [lhead="clusterCalledFuncs", style="dashed", label=" call"];
     }
   \enddot
   Cette méthode construit les variables et appelle MicroHydroModule::hydroStartInit.
  */
  void hydroStartInit()
  {
    MicroHydroHydroStartInitVars vars(m_density
        , m_cell_cqs
        , m_cell_mass
        , m_node_mass
        , m_old_cell_volume
        , m_caracteristic_length
        , m_cell_volume
        , m_node_coord);
    this->hydroStartInit(vars);
  }

  /*!
   \dot
     digraph hydroContinueInitGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         hydroContinueInit [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="node_coord | cell_cqs"];
         inVars -> hydroContinueInit;
         outVars [shape="record", label="cell_volume"];
         hydroContinueInit -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle MicroHydroModule::hydroContinueInit.
  */
  void hydroContinueInit()
  {
    MicroHydroHydroContinueInitVars vars(m_node_coord
        , m_cell_cqs
        , m_cell_volume);
    this->hydroContinueInit(vars);
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
         outVars [shape="record", label="force"];
         computePressureForce -> outVars;
       }
   
       subgraph clusterCalledFuncs
       {
         center="true";
         color="navy";
         ILoopDelegation_computePressureForce [label="computePressureForce", color="navy", fontcolor="navy", style="rounded", URL="\ref MicroHydro::ILoopDelegation::computePressureForce"];
       }
       computePressureForce -> ILoopDelegation_computePressureForce [lhead="clusterCalledFuncs", style="dashed", label=" call"];
     }
   \enddot
   Cette méthode construit les variables et appelle MicroHydroModule::computePressureForce.
  */
  void computePressureForce()
  {
    MicroHydroComputePressureForceVars vars(m_force);
    this->computePressureForce(vars);
  }

  /*!
   \dot
     digraph computeVelocityGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         computeVelocity [style="rounded, filled", fillcolor="gray"];
         outVars [shape="record", label="velocity"];
         computeVelocity -> outVars;
       }
   
       subgraph clusterCalledFuncs
       {
         center="true";
         color="navy";
         ILoopDelegation_computeNodeImpulsion [label="computeNodeImpulsion", color="navy", fontcolor="navy", style="rounded", URL="\ref MicroHydro::ILoopDelegation::computeNodeImpulsion"];
       }
       computeVelocity -> ILoopDelegation_computeNodeImpulsion [lhead="clusterCalledFuncs", style="dashed", label=" call"];
     }
   \enddot
   Cette méthode construit les variables et appelle MicroHydroModule::computeVelocity.
  */
  void computeVelocity()
  {
    MicroHydroComputeVelocityVars vars(m_velocity);
    this->computeVelocity(vars);
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
       }
   
       subgraph clusterCalledFuncs
       {
         center="true";
         color="navy";
         ILoopDelegation_applyBoundaryCondition [label="applyBoundaryCondition", color="navy", fontcolor="navy", style="rounded", URL="\ref MicroHydro::ILoopDelegation::applyBoundaryCondition"];
       }
       applyBoundaryCondition -> ILoopDelegation_applyBoundaryCondition [lhead="clusterCalledFuncs", style="dashed", label=" call"];
     }
   \enddot
   Cette méthode construit les variables et appelle MicroHydroModule::applyBoundaryCondition.
  */
  void applyBoundaryCondition()
  {
    MicroHydroApplyBoundaryConditionVars vars;
    this->applyBoundaryCondition(vars);
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
       }
   
       subgraph clusterCalledFuncs
       {
         center="true";
         color="navy";
         ILoopDelegation_moveNodes [label="moveNodes", color="navy", fontcolor="navy", style="rounded", URL="\ref MicroHydro::ILoopDelegation::moveNodes"];
       }
       moveNodes -> ILoopDelegation_moveNodes [lhead="clusterCalledFuncs", style="dashed", label=" call"];
     }
   \enddot
   Cette méthode construit les variables et appelle MicroHydroModule::moveNodes.
  */
  void moveNodes()
  {
    MicroHydroMoveNodesVars vars;
    this->moveNodes(vars);
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
         inVars [shape="record", label="cell_volume"];
         inVars -> computeGeometricValues;
         outVars [shape="record", label="old_cell_volume"];
         computeGeometricValues -> outVars;
       }
   
       subgraph clusterCalledFuncs
       {
         center="true";
         color="navy";
         ILoopDelegation_computeGeometricValues [label="computeGeometricValues", color="navy", fontcolor="navy", style="rounded", URL="\ref MicroHydro::ILoopDelegation::computeGeometricValues"];
       }
       computeGeometricValues -> ILoopDelegation_computeGeometricValues [lhead="clusterCalledFuncs", style="dashed", label=" call"];
     }
   \enddot
   Cette méthode construit les variables et appelle MicroHydroModule::computeGeometricValues.
  */
  void computeGeometricValues()
  {
    MicroHydroComputeGeometricValuesVars vars(m_cell_volume
        , m_old_cell_volume);
    this->computeGeometricValues(vars);
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
         outVars [shape="record", label="density"];
         updateDensity -> outVars;
       }
   
       subgraph clusterCalledFuncs
       {
         center="true";
         color="navy";
         ILoopDelegation_updateDensity [label="updateDensity", color="navy", fontcolor="navy", style="rounded", URL="\ref MicroHydro::ILoopDelegation::updateDensity"];
       }
       updateDensity -> ILoopDelegation_updateDensity [lhead="clusterCalledFuncs", style="dashed", label=" call"];
     }
   \enddot
   Cette méthode construit les variables et appelle MicroHydroModule::updateDensity.
  */
  void updateDensity()
  {
    MicroHydroUpdateDensityVars vars(m_density);
    this->updateDensity(vars);
  }

  /*!
   \dot
     digraph applyEquationOfStateGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         applyEquationOfState [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="cell_volume | old_cell_volume | adiabatic_cst"];
         inVars -> applyEquationOfState;
         outVars [shape="record", label="internal_energy"];
         applyEquationOfState -> outVars;
       }
   
       subgraph clusterCalledFuncs
       {
         center="true";
         color="navy";
         IEquationOfState_applyEOS [label="applyEOS", color="navy", fontcolor="navy", style="rounded", URL="\ref MicroHydroEos::IEquationOfState::applyEOS"];
       }
       applyEquationOfState -> IEquationOfState_applyEOS [lhead="clusterCalledFuncs", style="dashed", label=" call"];
     }
   \enddot
   Cette méthode construit les variables et appelle MicroHydroModule::applyEquationOfState.
  */
  void applyEquationOfState()
  {
    MicroHydroApplyEquationOfStateVars vars(m_cell_volume
        , m_old_cell_volume
        , m_adiabatic_cst
        , m_internal_energy);
    this->applyEquationOfState(vars);
  }

  /*!
   \dot
     digraph computeDeltaTGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         computeDeltaT [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="caracteristic_length | sound_speed"];
         inVars -> computeDeltaT;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle MicroHydroModule::computeDeltaT.
  */
  void computeDeltaT()
  {
    MicroHydroComputeDeltaTVars vars(m_caracteristic_length
        , m_sound_speed);
    this->computeDeltaT(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void hydroStartInit(MicroHydroHydroStartInitVars& vars) = 0;
  virtual void hydroContinueInit(MicroHydroHydroContinueInitVars& vars) = 0;
  virtual void computePressureForce(MicroHydroComputePressureForceVars& vars) = 0;
  virtual void computeVelocity(MicroHydroComputeVelocityVars& vars) = 0;
  virtual void applyBoundaryCondition(MicroHydroApplyBoundaryConditionVars& vars) = 0;
  virtual void moveNodes(MicroHydroMoveNodesVars& vars) = 0;
  virtual void computeGeometricValues(MicroHydroComputeGeometricValuesVars& vars) = 0;
  virtual void updateDensity(MicroHydroUpdateDensityVars& vars) = 0;
  virtual void applyEquationOfState(MicroHydroApplyEquationOfStateVars& vars) = 0;
  virtual void computeDeltaT(MicroHydroComputeDeltaTVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace MicroHydro

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // MICROHYDRO___MICROHYDROMODULEBASE_H
