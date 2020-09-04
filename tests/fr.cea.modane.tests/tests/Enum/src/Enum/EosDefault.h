#ifndef ENUM_EOSDEFAULT_H
#define ENUM_EOSDEFAULT_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Enum/__EosDefaultBase.h"
#include "ProjectIncludes.h"
#include "Enum/SubEnum/__PseudoViscosityType.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace Enum {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Eos : implémentation
 * 
 */
class EosDefault
: public EosDefaultBase<EosDefault>
{
 public:
  explicit EosDefault(IMesh* mesh);
  ~EosDefault();

 public:
  void f(EosDefaultFVars& vars, const ::EnumSubEnum::PseudoViscosityType pseudo_type) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Enum

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // ENUM_EOSDEFAULT_H
