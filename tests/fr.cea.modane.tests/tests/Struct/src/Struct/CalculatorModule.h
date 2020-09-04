#ifndef CALCULATOR_MODULE_H
#define CALCULATOR_MODULE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Struct/__CalculatorModuleBase.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Struct {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Classe d'implémentation du module Calculator
 *
 * 
 */
class CalculatorModule
: public CalculatorModuleBase<CalculatorModule>
{
 public:
	CalculatorModule(const ModuleBuildInfo& mbi);
	~CalculatorModule();

 protected:
	void compute(CalculatorComputeVars& vars);
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

} // namespace Struct

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif /* CALCULATOR_MODULE_H */
