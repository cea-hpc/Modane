#ifndef INHERITANCE_SERV_BASICSERVICE_H
#define INHERITANCE_SERV_BASICSERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Inheritance/Serv/__BasicServiceBase.h"
#include "ProjectIncludes.h"
#include "Inheritance/Serv/__IMyChildInterf.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace InheritanceServ {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service Basic : implémentation
 * 
 */
class BasicService
: public BasicServiceBase<BasicService>
{
 public:
  explicit BasicService(const ServiceBuildInfo& bi);
  ~BasicService();

 public:
  void g(BasicGVars& vars) override;
  void f(BasicFVars& vars) override;
  void testAutoInclude(BasicTestAutoIncludeVars& vars, const IMyChildInterf* my_child_interf) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace InheritanceServ

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // INHERITANCE_SERV_BASICSERVICE_H
