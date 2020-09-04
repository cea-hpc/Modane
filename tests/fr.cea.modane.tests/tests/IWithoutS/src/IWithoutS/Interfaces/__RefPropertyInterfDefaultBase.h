#ifndef IWITHOUTS_INTERFACES___REFPROPERTYINTERFDEFAULTBASE_H
#define IWITHOUTS_INTERFACES___REFPROPERTYINTERFDEFAULTBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "arcane/IMesh.h"
#include "arcane/MeshAccessor.h"
#include "arcane/utils/TraceAccessor.h"
#include "IWithoutS/Interfaces/__IRefPropertyInterf.h"
#include "IWithoutS/Interfaces/__RefPropertyInterfDefaultVars.h"
#include "IWithoutS/Interfaces/NoPropertyInterfDefault.h"
#include "IWithoutS/Interfaces/__INoPropertyInterf.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace IWithoutSInterfaces {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface RefPropertyInterf : classe de base. 
 * 
 */
template<class T>
class RefPropertyInterfDefaultBase
: public IRefPropertyInterf
, public TraceAccessor
, public MeshAccessor
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit RefPropertyInterfDefaultBase(IMesh* mesh) 
  : TraceAccessor(mesh->traceMng())
  , MeshAccessor(mesh)
  , m_no_property_interf(new ::IWithoutSInterfaces::NoPropertyInterfDefault(mesh))
  {
  }

  virtual ~RefPropertyInterfDefaultBase()
  {
    delete m_no_property_interf;
  }

 public:  // ***** ACCESSEURS
  INoPropertyInterf* getNoPropertyInterf() { return m_no_property_interf; }
  const String getImplName() const { return "RefPropertyInterfDefault"; }

 public:  // ***** METHODES CONCRETES
  /*!
   \dot
     digraph computeGraph
     {
       compound="true";
       edge [arrowsize="0.5", fontsize="8"];
       node [shape="box", fontname="Arial", fontsize="10"];
       {
         rank=same;
         compute [style="rounded, filled", fillcolor="gray"];
         inVars [shape="record", label="abstract_temperature"];
         inVars -> compute;
         outVars [shape="record", label="abstract_density"];
         compute -> outVars;
       }
   
     }
   \enddot
   Cette méthode construit les variables et appelle RefPropertyInterfDefault::compute.
  */
  void compute(const VariableCellReal& abstract_temperature, VariableCellReal& abstract_density)
  {
    RefPropertyInterfDefaultComputeVars vars(abstract_temperature
        , abstract_density);
    this->compute(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void compute(RefPropertyInterfDefaultComputeVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
  INoPropertyInterf* m_no_property_interf;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSInterfaces

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_INTERFACES___REFPROPERTYINTERFDEFAULTBASE_H
