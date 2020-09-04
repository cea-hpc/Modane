#ifndef STRUCT___ITEST_H
#define STRUCT___ITEST_H

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
namespace Struct {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface représentant la structure Test
 * 
 */
class ITest
{
 public:
  ITest() {}
  virtual ~ITest() {}

 public:
  virtual String getA() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * Classe représentant la structure Test
 * 
 */
class Test
: public ITest
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  Test()
  : m_a(String())
  {}
  virtual ~Test() {}

 public:  // ***** ACCESSEURS
  String getA() override { return m_a; }
  void setA(String value) { m_a = value; }

 protected:  // ***** ATTRIBUTS
  String m_a;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Struct

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // STRUCT___ITEST_H
