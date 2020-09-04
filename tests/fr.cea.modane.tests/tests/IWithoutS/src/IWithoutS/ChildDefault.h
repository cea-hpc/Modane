#ifndef IWITHOUTS_CHILDDEFAULT_H
#define IWITHOUTS_CHILDDEFAULT_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "IWithoutS/__ChildDefaultBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace IWithoutS {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Child : implémentation
 * 
 */
class ChildDefault
: public ChildDefaultBase<ChildDefault>
{
 public:
  explicit ChildDefault(IMesh* mesh);
  ~ChildDefault();

 public:
  void build(ChildDefaultBuildVars& vars) override;
  void compute(ChildDefaultComputeVars& vars) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutS

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_CHILDDEFAULT_H
