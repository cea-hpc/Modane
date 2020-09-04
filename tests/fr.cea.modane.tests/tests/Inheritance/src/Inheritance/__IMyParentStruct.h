#ifndef INHERITANCE___IMYPARENTSTRUCT_H
#define INHERITANCE___IMYPARENTSTRUCT_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Inheritance {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface représentant la structure MyParentStruct
 * 
 */
class IMyParentStruct
{
 public:
  IMyParentStruct() {}
  virtual ~IMyParentStruct() {}

 public:
  virtual Real getA() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * Classe représentant la structure MyParentStruct
 * 
 */
class MyParentStruct
: public IMyParentStruct
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  MyParentStruct()
  : m_a(Real())
  {}
  virtual ~MyParentStruct() {}

 public:  // ***** ACCESSEURS
  Real getA() override { return m_a; }
  void setA(Real value) { m_a = value; }

 protected:  // ***** ATTRIBUTS
  Real m_a;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Inheritance

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // INHERITANCE___IMYPARENTSTRUCT_H
