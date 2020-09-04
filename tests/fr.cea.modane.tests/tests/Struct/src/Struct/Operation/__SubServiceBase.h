#ifndef STRUCT_OPERATION___SUBSERVICEBASE_H
#define STRUCT_OPERATION___SUBSERVICEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Struct/Operation/__IOperation.h"
#include "Struct/Operation/__SubServiceVars.h"
#include "Struct/Operation/__IOperand.h"
#include "Struct/Operation/Sub_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace StructOperation {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service Sub : classe de base. 
 * 
 */
template<class T>
class SubServiceBase
: public ArcaneSubObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit SubServiceBase(const ServiceBuildInfo& bi)
  : ArcaneSubObject(bi)
  {
  }

  virtual ~SubServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "SubService"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle SubService::apply.
  */
  void apply(ConstArrayView< IOperand* > op, Array< Integer >& result) override
  {
    SubApplyVars vars;
    this->apply(vars, op, result);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void apply(SubApplyVars& vars, ConstArrayView< IOperand* > op, Array< Integer >& result) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace StructOperation

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // STRUCT_OPERATION___SUBSERVICEBASE_H
