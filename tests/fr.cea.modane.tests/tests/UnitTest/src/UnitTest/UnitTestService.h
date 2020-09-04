#ifndef UNITTEST_UNITTESTSERVICE_H
#define UNITTEST_UNITTESTSERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "UnitTest/__UnitTestServiceBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace UnitTest {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service UnitTest : implémentation
 * 
 */
class UnitTestService
: public UnitTestServiceBase<UnitTestService>
{
 public:
  explicit UnitTestService(const ServiceBuildInfo& bi);
  ~UnitTestService();

 public:
  Integer add(UnitTestAddVars& vars, const Integer a, const Integer b) override;
  void testAdd() override;
  void setUpForClass() override;
  void setUp() override;
  void tearDownForClass() override;
  void tearDown() override;

 private:
  Integer m_var;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace UnitTest

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // UNITTEST_UNITTESTSERVICE_H
