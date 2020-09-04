#ifndef STRUCT___IMETHOD_H
#define STRUCT___IMETHOD_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Struct/__IParam.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Struct {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface représentant la structure Method
 * 
 */
class IMethod
{
 public:
  IMethod() {}
  virtual ~IMethod() {}

 public:
  virtual String getName() = 0;
  virtual ConstArrayView< IParam* > getParams() = 0;
  virtual IParam* getAnotherParam() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * Classe représentant la structure Method
 * 
 */
class Method
: public IMethod
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  Method()
  : m_name(String())
  , m_params(UniqueArray< IParam* >())
  , m_another_param(0)
  {}
  virtual ~Method() {}

 public:  // ***** ACCESSEURS
  String getName() override { return m_name; }
  void setName(String value) { m_name = value; }

  ConstArrayView< IParam* > getParams() override { return m_params; }
  void setParams(Array< IParam* >& value) { m_params = value; }

  IParam* getAnotherParam() override { return m_another_param; }
  void setAnotherParam(IParam* value) { m_another_param = value; }

 protected:  // ***** ATTRIBUTS
  String m_name;
  UniqueArray< IParam* > m_params;
  IParam* m_another_param;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Struct

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // STRUCT___IMETHOD_H
