#ifndef STRUCT___CALCULATORMODULEBASE_H
#define STRUCT___CALCULATORMODULEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Struct/__CalculatorModuleVars.h"
#include "Struct/Operation/__IOperation.h"
#include "Struct/__IMethod.h"
#include "Struct/Operation/__IOperand.h"
#include "Struct/Calculator_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Struct {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Module Calculator : classe de base. 
 * 
 */
template<class T>
class CalculatorModuleBase
: public ArcaneCalculatorObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit CalculatorModuleBase(const ModuleBuildInfo& bi)
  : ArcaneCalculatorObject(bi)
  {
  }

  virtual ~CalculatorModuleBase()
  {
  }

 public:  // ***** ACCESSEURS
  ::StructOperation::IOperation* getOperation() { return options()->getOperation(); }
  IMethod* getMethod() { return options()->getMethod(); }
  ConstArrayView< ::StructOperation::IOperand* > getOperands() { return options()->getOperands(); }
  VersionInfo versionInfo() const { return VersionInfo("1.0"); }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle CalculatorModule::compute.
  */
  void compute()
  {
    CalculatorComputeVars vars;
    this->compute(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void compute(CalculatorComputeVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Struct

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // STRUCT___CALCULATORMODULEBASE_H
