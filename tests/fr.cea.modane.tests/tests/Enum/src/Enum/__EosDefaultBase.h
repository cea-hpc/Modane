#ifndef ENUM___EOSDEFAULTBASE_H
#define ENUM___EOSDEFAULTBASE_H

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
#include "Enum/__IEos.h"
#include "Enum/__EosDefaultVars.h"
#include "Enum/SubEnum/__PseudoViscosityType.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Enum {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Eos : classe de base. 
 * 
 */
template<class T>
class EosDefaultBase
: public IEos
, public TraceAccessor
, public MeshAccessor
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit EosDefaultBase(IMesh* mesh) 
  : TraceAccessor(mesh->traceMng())
  , MeshAccessor(mesh)
  {
  }

  virtual ~EosDefaultBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "EosDefault"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle EosDefault::f.
  */
  void f(const ::EnumSubEnum::PseudoViscosityType pseudo_type)
  {
    EosDefaultFVars vars;
    this->f(vars, pseudo_type);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void f(EosDefaultFVars& vars, const ::EnumSubEnum::PseudoViscosityType pseudo_type) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Enum

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // ENUM___EOSDEFAULTBASE_H
