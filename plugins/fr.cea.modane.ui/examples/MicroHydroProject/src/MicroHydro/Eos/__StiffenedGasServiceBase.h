#ifndef MICROHYDRO_EOS___STIFFENEDGASSERVICEBASE_H
#define MICROHYDRO_EOS___STIFFENEDGASSERVICEBASE_H

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
#include "MicroHydro/Eos/__IEquationOfState.h"
#include "MicroHydro/Eos/__StiffenedGasServiceVars.h"
#include "MicroHydro/Eos/StiffenedGas_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace MicroHydroEos {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service StiffenedGas : classe de base. 
 * 
 */
template<class T>
class StiffenedGasServiceBase
: public ArcaneStiffenedGasObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit StiffenedGasServiceBase(const ServiceBuildInfo& bi)
  : ArcaneStiffenedGasObject(bi)
  {
  }

  virtual ~StiffenedGasServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  Real getLimitTension() { return options()->getLimitTension(); }
  const String getImplName() const { return "StiffenedGasService"; }

 public:  // ***** METHODES CONCRETES
  /*!
   \dot
     digraph initEOSGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         initEOS [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="adiabatic_cst | density | pressure"];
         inVars -> initEOS;
         outVars [shape="record", label="internal_energy | sound_speed"];
         initEOS -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle StiffenedGasService::initEOS.
  */
  void initEOS(const CellVectorView items) override
  {
    StiffenedGasInitEOSVars vars(m_adiabatic_cst
        , m_density
        , m_pressure
        , m_internal_energy
        , m_sound_speed);
    T* t = static_cast<T*>(this);
    arcaneParallelForeach(items, [&](CellVectorView sub_items)
    {
      ENUMERATE_CELL (iitem, sub_items) {
        const Cell item = *iitem;
        t->initEOS(item, vars);
      }
    });
  }

  /*!
   \dot
     digraph applyEOSGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         applyEOS [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="internal_energy | density | adiabatic_cst"];
         inVars -> applyEOS;
         outVars [shape="record", label="pressure | sound_speed"];
         applyEOS -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle StiffenedGasService::applyEOS.
  */
  void applyEOS(const CellVectorView items) override
  {
    StiffenedGasApplyEOSVars vars(m_internal_energy
        , m_density
        , m_adiabatic_cst
        , m_pressure
        , m_sound_speed);
    T* t = static_cast<T*>(this);
    arcaneParallelForeach(items, [&](CellVectorView sub_items)
    {
      ENUMERATE_CELL (iitem, sub_items) {
        const Cell item = *iitem;
        t->applyEOS(item, vars);
      }
    });
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void initEOS(const Cell cell, StiffenedGasInitEOSVars& vars) = 0;
  virtual void applyEOS(const Cell cell, StiffenedGasApplyEOSVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace MicroHydroEos

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // MICROHYDRO_EOS___STIFFENEDGASSERVICEBASE_H
