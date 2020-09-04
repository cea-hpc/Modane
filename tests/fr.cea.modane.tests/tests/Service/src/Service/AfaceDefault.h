#ifndef SERVICE_AFACEDEFAULT_H
#define SERVICE_AFACEDEFAULT_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Service/__AfaceDefaultBase.h"
#include "ProjectIncludes.h"
#include "Service/__IDeura.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Aface : implémentation
 * 
 */
class AfaceDefault
: public AfaceDefaultBase<AfaceDefault>
{
 public:
  explicit AfaceDefault(IMesh* mesh);
  ~AfaceDefault();

 public:
  void compute(AfaceDefaultComputeVars& vars, const IDeura* deura) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE_AFACEDEFAULT_H
