#ifndef STRUCT_OPERATION___ADDSERVICEBASE_H
#define STRUCT_OPERATION___ADDSERVICEBASE_H

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
#include "Struct/Operation/__AddServiceVars.h"
#include "Struct/Operation/__IOperand.h"
#include "Struct/Operation/Add_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace StructOperation {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service Add : classe de base. 
 * 
 */
template<class T>
class AddServiceBase
: public ArcaneAddObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit AddServiceBase(const ServiceBuildInfo& bi)
  : ArcaneAddObject(bi)
  {
  }

  virtual ~AddServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  IOperand* getOpBidon() { return options()->getOpBidon(); }
  bool hasOpBidon() const { return options()->hasOpBidon(); }
  IOperand* getOpRef() { return options()->getOpRef(); }
  bool hasOpRef() const { return options()->hasOpRef(); }
  const String getImplName() const { return "AddService"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle AddService::apply.
  */
  void apply(ConstArrayView< IOperand* > op, Array< Integer >& result) override
  {
    AddApplyVars vars;
    this->apply(vars, op, result);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void apply(AddApplyVars& vars, ConstArrayView< IOperand* > op, Array< Integer >& result) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace StructOperation

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // STRUCT_OPERATION___ADDSERVICEBASE_H
