#ifndef INHERITANCE_SERV_MYPARENTINTERFDEFAULT_H
#define INHERITANCE_SERV_MYPARENTINTERFDEFAULT_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Inheritance/Serv/__MyParentInterfDefaultBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace InheritanceServ {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface MyParentInterf : implémentation
 * 
 */
class MyParentInterfDefault
: public MyParentInterfDefaultBase<MyParentInterfDefault>
{
 public:
  explicit MyParentInterfDefault(IMesh* mesh);
  ~MyParentInterfDefault();

 public:
  void f(MyParentInterfDefaultFVars& vars) override;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace InheritanceServ

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // INHERITANCE_SERV_MYPARENTINTERFDEFAULT_H
