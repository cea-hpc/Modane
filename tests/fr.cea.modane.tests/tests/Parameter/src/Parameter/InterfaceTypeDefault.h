#ifndef PARAMETER_INTERFACETYPEDEFAULT_H
#define PARAMETER_INTERFACETYPEDEFAULT_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Parameter/__InterfaceTypeDefaultBase.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
using namespace Arcane::Materials;
namespace Parameter {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Parameter.InterfaceType : implémentation
 * 
 */
class InterfaceTypeDefault
: public InterfaceTypeDefaultBase<InterfaceTypeDefault>
{
 public:
	InterfaceTypeDefault(IMesh* mesh);
	~InterfaceTypeDefault();

 public:
	void f(InterfaceTypeDefaultFVars& vars);
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} /* namespace Parameter */

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif /* PARAMETER_INTERFACETYPEDEFAULT_H */
