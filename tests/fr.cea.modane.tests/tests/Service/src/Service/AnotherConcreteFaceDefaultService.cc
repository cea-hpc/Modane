#include "Service/AnotherConcreteFaceDefaultService.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

AnotherConcreteFaceDefaultService::
AnotherConcreteFaceDefaultService(const ServiceBuildInfo& bi)
: AnotherConcreteFaceDefaultServiceBase<AnotherConcreteFaceDefaultService>(bi)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

AnotherConcreteFaceDefaultService::
~AnotherConcreteFaceDefaultService()
{
}
	

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void AnotherConcreteFaceDefaultService::
compute(AnotherConcreteFaceDefaultComputeVars& vars, const IDeura* deura)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

ARCANE_REGISTER_SERVICE_ANOTHERCONCRETEFACEDEFAULT(AnotherConcreteFaceDefault, AnotherConcreteFaceDefaultService);

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service
