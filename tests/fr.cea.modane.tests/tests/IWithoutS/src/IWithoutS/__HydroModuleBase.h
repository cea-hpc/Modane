#ifndef IWITHOUTS___HYDROMODULEBASE_H
#define IWITHOUTS___HYDROMODULEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "IWithoutS/__HydroModuleVars.h"
#include "IWithoutS/Interfaces/NoPropertyInterfDefault.h"
#include "IWithoutS/Interfaces/RefPropertyInterfDefault.h"
#include "IWithoutS/ChildDefault.h"
#include "IWithoutS/Eos/__IEos.h"
#include "IWithoutS/Interfaces/__INoPropertyInterf.h"
#include "IWithoutS/Interfaces/__IRefPropertyInterf.h"
#include "IWithoutS/__IRefNoPropertyStruct.h"
#include "IWithoutS/Interfaces/__IOutsideServiceInterf.h"
#include "IWithoutS/__IChild.h"
#include "IWithoutS/Hydro_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace IWithoutS {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Module Hydro : classe de base. 
 * 
 */
template<class T>
class HydroModuleBase
: public ArcaneHydroObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit HydroModuleBase(const ModuleBuildInfo& bi)
  : ArcaneHydroObject(bi)
  , m_no_property_interf(new ::IWithoutSInterfaces::NoPropertyInterfDefault(bi.mesh()))
  , m_ref_property_interf(new ::IWithoutSInterfaces::RefPropertyInterfDefault(bi.mesh()))
  , m_child(new ::IWithoutS::ChildDefault(bi.mesh()))
  {
  }

  virtual ~HydroModuleBase()
  {
    delete m_no_property_interf;
    delete m_ref_property_interf;
    delete m_child;
  }

 public:  // ***** ACCESSEURS
  ::IWithoutSEos::IEos* getEos() { return options()->getEos(); }
  ::IWithoutSInterfaces::INoPropertyInterf* getNoPropertyInterf() { return m_no_property_interf; }
  ::IWithoutSInterfaces::IRefPropertyInterf* getRefPropertyInterf() { return m_ref_property_interf; }
  IRefNoPropertyStruct* getRefStruct() { return options()->getRefStruct(); }
  bool hasRefStruct() const { return options()->hasRefStruct(); }
  ::IWithoutSInterfaces::IOutsideServiceInterf* getOutsideServiceInterf() { return options()->getOutsideServiceInterf(); }
  IChild* getChild() { return m_child; }
  VersionInfo versionInfo() const { return VersionInfo("1.0"); }

 public:  // ***** METHODES CONCRETES
  /*!
   \dot
     digraph computeEosGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         computeEos [style="rounded, filled", fillcolor="gray"];
       }
   
       subgraph clusterCalledFuncs
       {
         center="true";
         color="navy";
         IEos_computeSequential [label="computeSequential", color="navy", fontcolor="navy", style="rounded", URL="\ref IWithoutSEos::IEos::computeSequential"];
         IEos_computeParallel [label="computeParallel", color="navy", fontcolor="navy", style="rounded", URL="\ref IWithoutSEos::IEos::computeParallel"];
         IEos_computeByItemType [label="computeByItemType", color="navy", fontcolor="navy", style="rounded", URL="\ref IWithoutSEos::IEos::computeByItemType"];
       }
       computeEos -> IEos_computeByItemType [lhead="clusterCalledFuncs", style="dashed", label=" call"];
     }
   \enddot
   Cette méthode construit les variables et appelle HydroModule::computeEos.
  */
  void computeEos()
  {
    HydroComputeEosVars vars;
    this->computeEos(vars);
  }

  /*!
   \dot
     digraph computeNoPropertyInterfGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         computeNoPropertyInterf [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="temperature"];
         inVars -> computeNoPropertyInterf;
         outVars [shape="record", label="density"];
         computeNoPropertyInterf -> outVars;
       }
   
       subgraph clusterCalledFuncs
       {
         center="true";
         color="navy";
         INoPropertyInterf_computeSequential [label="computeSequential", color="navy", fontcolor="navy", style="rounded", URL="\ref IWithoutSInterfaces::INoPropertyInterf::computeSequential"];
         INoPropertyInterf_computeParallel [label="computeParallel", color="navy", fontcolor="navy", style="rounded", URL="\ref IWithoutSInterfaces::INoPropertyInterf::computeParallel"];
         INoPropertyInterf_computeByItemType [label="computeByItemType", color="navy", fontcolor="navy", style="rounded", URL="\ref IWithoutSInterfaces::INoPropertyInterf::computeByItemType"];
       }
       computeNoPropertyInterf -> INoPropertyInterf_computeByItemType [lhead="clusterCalledFuncs", style="dashed", label=" call"];
     }
   \enddot
   Cette méthode construit les variables et appelle HydroModule::computeNoPropertyInterf.
  */
  void computeNoPropertyInterf()
  {
    HydroComputeNoPropertyInterfVars vars(m_temperature
        , m_density);
    this->computeNoPropertyInterf(vars);
  }

  /*!
   \dot
     digraph computeRefPropertyInterfGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         computeRefPropertyInterf [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="temperature"];
         inVars -> computeRefPropertyInterf;
         outVars [shape="record", label="density"];
         computeRefPropertyInterf -> outVars;
       }
   
       subgraph clusterCalledFuncs
       {
         center="true";
         color="navy";
         IRefPropertyInterf_compute [label="compute", color="navy", fontcolor="navy", style="rounded", URL="\ref IWithoutSInterfaces::IRefPropertyInterf::compute"];
       }
       computeRefPropertyInterf -> IRefPropertyInterf_compute [lhead="clusterCalledFuncs", style="dashed", label=" call"];
     }
   \enddot
   Cette méthode construit les variables et appelle HydroModule::computeRefPropertyInterf.
  */
  void computeRefPropertyInterf()
  {
    HydroComputeRefPropertyInterfVars vars(m_temperature
        , m_density);
    this->computeRefPropertyInterf(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void computeEos(HydroComputeEosVars& vars) = 0;
  virtual void computeNoPropertyInterf(HydroComputeNoPropertyInterfVars& vars) = 0;
  virtual void computeRefPropertyInterf(HydroComputeRefPropertyInterfVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
  ::IWithoutSInterfaces::INoPropertyInterf* m_no_property_interf;
  ::IWithoutSInterfaces::IRefPropertyInterf* m_ref_property_interf;
  IChild* m_child;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutS

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS___HYDROMODULEBASE_H
