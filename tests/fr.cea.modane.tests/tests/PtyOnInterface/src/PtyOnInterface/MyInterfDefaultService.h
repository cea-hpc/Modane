#ifndef PTYONINTERFACE_MYINTERFDEFAULTSERVICE_H
#define PTYONINTERFACE_MYINTERFDEFAULTSERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "PtyOnInterface/__MyInterfDefaultServiceBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace PtyOnInterface {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service MyInterfDefault : implémentation
 * Service par défaut pour l'interface MyInterf
 */
class MyInterfDefaultService
: public MyInterfDefaultServiceBase<MyInterfDefaultService>
{
 public:
  explicit MyInterfDefaultService(const ServiceBuildInfo& bi);
  ~MyInterfDefaultService();

 public:
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace PtyOnInterface

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PTYONINTERFACE_MYINTERFDEFAULTSERVICE_H
