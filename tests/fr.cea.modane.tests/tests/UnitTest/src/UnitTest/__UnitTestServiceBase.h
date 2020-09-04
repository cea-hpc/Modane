#ifndef UNITTEST___UNITTESTSERVICEBASE_H
#define UNITTEST___UNITTESTSERVICEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "UnitTest/__IInterf.h"
#include "UnitTest/__UnitTestServiceVars.h"
#include "UnitTest/UnitTest_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace UnitTest {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service UnitTest : classe de base. 
 * 
 */
template<class T>
class UnitTestServiceBase
: public ArcaneUnitTestObject
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit UnitTestServiceBase(const ServiceBuildInfo& bi)
  : ArcaneUnitTestObject(bi)
  {
  }

  virtual ~UnitTestServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "UnitTestService"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle UnitTestService::add.
  */
  Integer add(const Integer a, const Integer b) override
  {
    UnitTestAddVars vars;
    return this->add(vars, a, b);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual Integer add(UnitTestAddVars& vars, const Integer a, const Integer b) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace UnitTest

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // UNITTEST___UNITTESTSERVICEBASE_H
