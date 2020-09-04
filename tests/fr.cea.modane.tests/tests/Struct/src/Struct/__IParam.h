#ifndef STRUCT___IPARAM_H
#define STRUCT___IPARAM_H

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
 * \brief Interface représentant la structure Param
 * 
 */
class IParam
{
 public:
  IParam() {}
  virtual ~IParam() {}

 public:
  virtual String getName() = 0;
  virtual Real getValue() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * Classe représentant la structure Param
 * 
 */
class Param
: public IParam
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  Param()
  : m_name(String())
  , m_value(Real())
  {}
  virtual ~Param() {}

 public:  // ***** ACCESSEURS
  String getName() override { return m_name; }
  void setName(String value) { m_name = value; }

  Real getValue() override { return m_value; }
  void setValue(Real value) { m_value = value; }

 protected:  // ***** ATTRIBUTS
  String m_name;
  Real m_value;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Struct

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // STRUCT___IPARAM_H
