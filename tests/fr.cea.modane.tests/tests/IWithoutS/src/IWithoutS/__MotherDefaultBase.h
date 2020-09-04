#ifndef IWITHOUTS___MOTHERDEFAULTBASE_H
#define IWITHOUTS___MOTHERDEFAULTBASE_H

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
#include "IWithoutS/__IMother.h"
#include "IWithoutS/__MotherDefaultVars.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace IWithoutS {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Mother : classe de base. 
 * 
 */
template<class T>
class MotherDefaultBase
: public IMother
, public TraceAccessor
, public MeshAccessor
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit MotherDefaultBase(IMesh* mesh) 
  : TraceAccessor(mesh->traceMng())
  , MeshAccessor(mesh)
  {
  }

  virtual ~MotherDefaultBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "MotherDefault"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle MotherDefault::build.
  */
  void build()
  {
    MotherDefaultBuildVars vars;
    this->build(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void build(MotherDefaultBuildVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutS

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS___MOTHERDEFAULTBASE_H
