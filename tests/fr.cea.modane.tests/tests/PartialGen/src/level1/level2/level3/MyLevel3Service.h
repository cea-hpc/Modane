#ifndef LEVEL1_LEVEL2_LEVEL3_MYLEVEL3SERVICE_H
#define LEVEL1_LEVEL2_LEVEL3_MYLEVEL3SERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "level1/level2/level3/__MyLevel3ServiceBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace Level1Level2Level3 {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service MyLevel3 : implémentation
 * 
 */
class MyLevel3Service
: public MyLevel3ServiceBase<MyLevel3Service>
{
 public:
  explicit MyLevel3Service(const ServiceBuildInfo& bi);
  ~MyLevel3Service();

 public:
  void f(MyLevel3FVars& vars) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Level1Level2Level3

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // LEVEL1_LEVEL2_LEVEL3_MYLEVEL3SERVICE_H
