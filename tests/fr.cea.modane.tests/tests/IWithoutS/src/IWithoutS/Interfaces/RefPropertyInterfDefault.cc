#include "IWithoutS/Interfaces/RefPropertyInterfDefault.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace IWithoutSInterfaces {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

RefPropertyInterfDefault::
RefPropertyInterfDefault(IMesh* mesh)
: RefPropertyInterfDefaultBase<RefPropertyInterfDefault>(mesh)
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

RefPropertyInterfDefault::
~RefPropertyInterfDefault()
{
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

void RefPropertyInterfDefault::
compute(RefPropertyInterfDefaultComputeVars& vars)
{
	m_no_property_interf->computeSequential(allCells().view(), vars.m_abstract_temperature, vars.m_abstract_density, 4.);
	m_no_property_interf->computeParallel(allCells().view(), vars.m_abstract_temperature, vars.m_abstract_density, 4.);
	m_no_property_interf->computeByItemType(allCells(), vars.m_abstract_temperature, vars.m_abstract_density, 4.);

	info() << "RefPropertyInterfDefault.compute()";
	info() << "Valeur sequentielle " << m_no_property_interf->getSequentialCpt();
	info() << "Valeur par item " << m_no_property_interf->getItemTypeCpt();
	info() << "Valeur parallele " << m_no_property_interf->getParallelCpt();
	if (m_no_property_interf->getSequentialCpt() != m_no_property_interf->getItemTypeCpt()
			|| m_no_property_interf->getItemTypeCpt() != m_no_property_interf->getParallelCpt())
		exit(4444);
}

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace IWithoutSInterfaces
