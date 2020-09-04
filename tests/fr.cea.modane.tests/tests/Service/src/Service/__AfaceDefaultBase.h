#ifndef SERVICE___AFACEDEFAULTBASE_H
#define SERVICE___AFACEDEFAULTBASE_H

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
#include "Service/__IAface.h"
#include "Service/__AfaceDefaultVars.h"
#include "Service/__IDeura.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Aface : classe de base. 
 * 
 */
template<class T>
class AfaceDefaultBase
: public IAface
, public TraceAccessor
, public MeshAccessor
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit AfaceDefaultBase(IMesh* mesh) 
  : TraceAccessor(mesh->traceMng())
  , MeshAccessor(mesh)
  {
  }

  virtual ~AfaceDefaultBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "AfaceDefault"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle AfaceDefault::compute.
  */
  void compute(const IDeura* deura)
  {
    AfaceDefaultComputeVars vars;
    this->compute(vars, deura);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void compute(AfaceDefaultComputeVars& vars, const IDeura* deura) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE___AFACEDEFAULTBASE_H
