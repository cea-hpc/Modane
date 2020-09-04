#ifndef IWITHOUTS_MOTHERDEFAULT_H
#define IWITHOUTS_MOTHERDEFAULT_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "IWithoutS/__MotherDefaultBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace IWithoutS {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Mother : implémentation
 * 
 */
class MotherDefault
: public MotherDefaultBase<MotherDefault>
{
 public:
  explicit MotherDefault(IMesh* mesh);
  ~MotherDefault();

 public:
  void build(MotherDefaultBuildVars& vars) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutS

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_MOTHERDEFAULT_H
