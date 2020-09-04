#ifndef IWITHOUTS___CHILDDEFAULTBASE_H
#define IWITHOUTS___CHILDDEFAULTBASE_H

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
#include "IWithoutS/__IChild.h"
#include "IWithoutS/__ChildDefaultVars.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace IWithoutS {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Child : classe de base. 
 * 
 */
template<class T>
class ChildDefaultBase
: public IChild
, public TraceAccessor
, public MeshAccessor
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit ChildDefaultBase(IMesh* mesh) 
  : TraceAccessor(mesh->traceMng())
  , MeshAccessor(mesh)
  {
  }

  virtual ~ChildDefaultBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "ChildDefault"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle ChildDefault::build.
  */
  void build()
  {
    ChildDefaultBuildVars vars;
    this->build(vars);
  }

  /*!
   Cette méthode construit les variables et appelle ChildDefault::compute.
  */
  void compute()
  {
    ChildDefaultComputeVars vars;
    this->compute(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void build(ChildDefaultBuildVars& vars) = 0;
  virtual void compute(ChildDefaultComputeVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutS

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS___CHILDDEFAULTBASE_H
