#ifndef LEVEL1_LEVEL2_LEVEL3___MYLEVEL3SERVICEBASE_H
#define LEVEL1_LEVEL2_LEVEL3___MYLEVEL3SERVICEBASE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "level1/level2/level3/__IMyLevel3Interface.h"
#include "level1/level2/level3/__MyLevel3ServiceVars.h"
#include "level1/level2/level3/MyLevel3_axl.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Level1Level2Level3 {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service MyLevel3 : classe de base. 
 * 
 */
template<class T>
class MyLevel3ServiceBase
: public ArcaneMyLevel3Object
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  explicit MyLevel3ServiceBase(const ServiceBuildInfo& bi)
  : ArcaneMyLevel3Object(bi)
  {
  }

  virtual ~MyLevel3ServiceBase()
  {
  }

 public:  // ***** ACCESSEURS
  const String getImplName() const { return "MyLevel3Service"; }

 public:  // ***** METHODES CONCRETES
  /*!
   Cette méthode construit les variables et appelle MyLevel3Service::f.
  */
  void f() override
  {
    MyLevel3FVars vars;
    this->f(vars);
  }


 public:  // ***** METHODES ABSTRAITES
  virtual void f(MyLevel3FVars& vars) = 0;

 protected:  // ***** ATTRIBUTS
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Level1Level2Level3

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // LEVEL1_LEVEL2_LEVEL3___MYLEVEL3SERVICEBASE_H
