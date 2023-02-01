#include "ParameterDefaultValue/HydroModule.h"
#include "ParameterDefaultValue/VarAsArgs/__IUpdater.h"
#include "ParameterDefaultValue/NoVarAsArgs/UpdaterNoVarsImplService.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace ParameterDefaultValueVarAsArgs;
using namespace ParameterDefaultValueNoVarAsArgs;

namespace ParameterDefaultValue {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

HydroModule::
HydroModule(const ModuleBuildInfo& bi)
: HydroModuleBase<HydroModule>(bi)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

HydroModule::
~HydroModule()
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void HydroModule::
compute(HydroComputeVars& vars)
{
	// appel des fonctions
	// VarAsArgs
	IUpdater* varAsArgs = getVarAsArgs();

	Real expected = 2.0;
	Real actual = varAsArgs->f1(expected);
	compare(expected, actual);

	expected = 1.0;
	actual = varAsArgs->f1();
	compare(expected, actual);

	Real a = 2.0;
	Integer b = 10;
	expected = a * b;
	actual = varAsArgs->f2(a, b);
	compare(expected, actual);

	expected = 1.0 * 25;
	actual = varAsArgs->f2();
	compare(expected, actual);

	expected = a * b;
	actual = varAsArgs->f3(a, b, true);
	compare(expected, actual);

	actual = varAsArgs->f3(a, b);
	compare(expected, actual);

	// NoVarAsArgs
	UpdaterNoVarsImplService* noVarAsArgs =  dynamic_cast<UpdaterNoVarsImplService*>(getNoVarAsArgs());

	expected = 2.0;
	actual = noVarAsArgs->f(expected);
	compare(expected, actual);

	actual = noVarAsArgs->fOfService(expected);
	compare(expected, actual);

	expected = 1.0;
	actual = noVarAsArgs->f();
	compare(expected, actual);

	actual = noVarAsArgs->fOfService();
	compare(expected, actual);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void HydroModule::
computeWithMyStruct(HydroComputeWithMyStructVars& vars, const IMyStruct* my_struct)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void HydroModule::
computeWithString(HydroComputeWithStringVars& vars, const String my_string)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ARCANE_REGISTER_MODULE_HYDRO(HydroModule);

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace ParameterDefaultValue
