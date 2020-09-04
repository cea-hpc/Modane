#ifndef PTYONINTERFACE___IMYSTRUCT_H
#define PTYONINTERFACE___IMYSTRUCT_H

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
namespace PtyOnInterface {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface représentant la structure MyStruct
 * 
 */
class IMyStruct
{
 public:
  IMyStruct() {}
  virtual ~IMyStruct() {}

 public:
  virtual Real getR() = 0;
  virtual Integer getOptI() = 0;
  virtual bool hasOptI() const = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * Classe représentant la structure MyStruct
 * 
 */
class MyStruct
: public IMyStruct
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  MyStruct()
  : m_r(Real())
  , m_opt_i(Integer())
  {}
  virtual ~MyStruct() {}

 public:  // ***** ACCESSEURS
  Real getR() override { return m_r; }
  void setR(Real value) { m_r = value; }

  Integer getOptI() override { return m_opt_i; }
  void setOptI(Integer value) { m_opt_i = value; }
bool hasOptI() const override { return true; }

 protected:  // ***** ATTRIBUTS
  Real m_r;
  Integer m_opt_i;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace PtyOnInterface

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PTYONINTERFACE___IMYSTRUCT_H
