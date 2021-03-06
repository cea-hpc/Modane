#include "Struct/Operation/AddService.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace StructOperation {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

AddService::
AddService(const ServiceBuildInfo & sbi)
: AddServiceBase<AddService>(sbi)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

AddService::
~AddService()
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void AddService::
apply(AddApplyVars& vars, ConstArrayView<IOperand*> op, Array<Integer>& result)
{
	result.resize(op.size());
	for (Integer i=0 ; i<op.size() ; ++i)
	{
		result[i] = op[i]->getX() + op[i]->getY();
	}
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ARCANE_REGISTER_SERVICE_ADD(Add, AddService);

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace StructOperation
