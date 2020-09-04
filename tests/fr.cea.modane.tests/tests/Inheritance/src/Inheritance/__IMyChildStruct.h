#ifndef INHERITANCE___IMYCHILDSTRUCT_H
#define INHERITANCE___IMYCHILDSTRUCT_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Inheritance/__IMyParentStruct.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Inheritance {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface représentant la structure MyChildStruct
 * 
 */
class IMyChildStruct
: public IMyParentStruct
{
 public:
  IMyChildStruct() {}
  virtual ~IMyChildStruct() {}

 public:
  virtual Integer getB() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * Classe représentant la structure MyChildStruct
 * 
 */
class MyChildStruct
: public IMyChildStruct
, public MyParentStruct
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  MyChildStruct()
  : m_b(Integer())
  {}
  virtual ~MyChildStruct() {}

 public:  // ***** ACCESSEURS
  Integer getB() override { return m_b; }
  void setB(Integer value) { m_b = value; }
  Real getA() override { return MyParentStruct::getA(); }
  void setA(Real value) { MyParentStruct::setA(value) ; }

 protected:  // ***** ATTRIBUTS
  Integer m_b;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Inheritance

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // INHERITANCE___IMYCHILDSTRUCT_H
