#ifndef IWITHOUTS_INTERFACES_REFPROPERTYINTERFDEFAULT_H
#define IWITHOUTS_INTERFACES_REFPROPERTYINTERFDEFAULT_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "IWithoutS/Interfaces/__RefPropertyInterfDefaultBase.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace IWithoutSInterfaces {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface IWithoutS.Interfaces.RefPropertyInterf : implémentation
 * 
 */
class RefPropertyInterfDefault
: public RefPropertyInterfDefaultBase<RefPropertyInterfDefault>
{
 public:
  explicit RefPropertyInterfDefault(IMesh* mesh);
  ~RefPropertyInterfDefault();

 public:
  void compute(RefPropertyInterfDefaultComputeVars& vars) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSInterfaces

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_INTERFACES_REFPROPERTYINTERFDEFAULT_H
