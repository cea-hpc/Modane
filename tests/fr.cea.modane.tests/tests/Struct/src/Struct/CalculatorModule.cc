#include "Struct/Operation/__IOperation.h"
#include "Struct/Operation/__IOperand.h"
#include "Struct/__IParam.h"
#include "Struct/__IMethod.h"
#include "Struct/__ITest.h"
#include "Struct/CalculatorModule.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace StructOperation;
namespace Struct {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

CalculatorModule::
CalculatorModule(const ModuleBuildInfo & mbi)
: CalculatorModuleBase<CalculatorModule>(mbi)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

CalculatorModule::
~CalculatorModule()
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void CalculatorModule::
compute(CalculatorComputeVars& vars)
{
	UniqueArray<Integer> result;
	IOperation* operation = options()->operation();
	ConstArrayView<IOperand*> operands = options()->operands._interface();

	/*
	Operand op1;
	op1.setX(4);
	op1.setY(2);
	Operand op2;
	op2.setX(8);
	op2.setY(3);
	Array<Operand*> operands(2);
	operands[0]=&op1;
	operands[1]=&op2;
	options()->operands()->_interface->getX();
	*/
	operation->apply(operands, result);

	info() << "Resultat du compute :";
	for (Integer i=0 ; i<result.size() ; i++)
		info() << "   result[" << i << "] = " << result[i];
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ARCANE_REGISTER_MODULE_CALCULATOR(CalculatorModule);

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace Struct
