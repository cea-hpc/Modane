#ifndef PARAMETER___INTERFACETYPEDEFAULTBASE_H
#define PARAMETER___INTERFACETYPEDEFAULTBASE_H

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
#include "Parameter/__IInterfaceType.h"
#include "Parameter/__InterfaceTypeDefaultVars.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Parameter {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface InterfaceType : classe de base. 
 * 
 */
template<class T>
class InterfaceTypeDefaultBase
: public IInterfaceType
, public TraceAccessor
, public MeshAccessor
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit InterfaceTypeDefaultBase(IMesh* mesh) 
  : TraceAccessor(mesh->traceMng())
  , MeshAccessor(mesh)
  {
  }

  virtual ~InterfaceTypeDefaultBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "InterfaceTypeDefault"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle InterfaceTypeDefault::f.
  */
  void f()
  {
    InterfaceTypeDefaultFVars vars;
    this->f(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void f(InterfaceTypeDefaultFVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Parameter

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PARAMETER___INTERFACETYPEDEFAULTBASE_H
