#ifndef STRUCT_OPERATION___IOPERAND_H
#define STRUCT_OPERATION___IOPERAND_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Struct/__ITest.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace StructOperation {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface représentant la structure Operand
 * 
 */
class IOperand
{
 public:
  IOperand() {}
  virtual ~IOperand() {}

 public:
  virtual Integer getY() = 0;
  virtual Integer getX() = 0;
  virtual bool getB() = 0;
  virtual bool hasB() const = 0;
  virtual CellGroup getCG() = 0;
  virtual bool hasCG() const = 0;
  virtual Real getR() = 0;
  virtual bool hasR() const = 0;
  virtual Real2 getR2() = 0;
  virtual bool hasR2() const = 0;
  virtual Real2x2 getR22() = 0;
  virtual bool hasR22() const = 0;
  virtual String getS() = 0;
  virtual bool hasS() const = 0;
  virtual ::Struct::ITest* getT() = 0;
  virtual bool hasT() const = 0;
  virtual ConstArrayView< String > getSs() = 0;
  virtual ConstArrayView< ::Struct::ITest* > getTs() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * Classe représentant la structure Operand
 * 
 */
class Operand
: public IOperand
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  Operand()
  : m_y(Integer())
  , m_x(Integer())
  , m_b(bool())
  , m_c_g(CellGroup())
  , m_r(Real())
  , m_r2(Real2())
  , m_r22(Real2x2())
  , m_s(String())
  , m_t(0)
  , m_ss(UniqueArray< String >())
  , m_ts(UniqueArray< ::Struct::ITest* >())
  {}
  virtual ~Operand() {}

 public:  // ***** ACCESSEURS
  Integer getY() override { return m_y; }
  void setY(Integer value) { m_y = value; }

  Integer getX() override { return m_x; }
  void setX(Integer value) { m_x = value; }

  bool getB() override { return m_b; }
  void setB(bool value) { m_b = value; }
bool hasB() const override { return true; }

  CellGroup getCG() override { return m_c_g; }
  void setCG(CellGroup value) { m_c_g = value; }
bool hasCG() const override { return true; }

  Real getR() override { return m_r; }
  void setR(Real value) { m_r = value; }
bool hasR() const override { return true; }

  Real2 getR2() override { return m_r2; }
  void setR2(Real2 value) { m_r2 = value; }
bool hasR2() const override { return true; }

  Real2x2 getR22() override { return m_r22; }
  void setR22(Real2x2 value) { m_r22 = value; }
bool hasR22() const override { return true; }

  String getS() override { return m_s; }
  void setS(String value) { m_s = value; }
bool hasS() const override { return true; }

  ::Struct::ITest* getT() override { return m_t; }
  void setT(::Struct::ITest* value) { m_t = value; }
bool hasT() const override { return true; }

  ConstArrayView< String > getSs() override { return m_ss; }
  void setSs(Array< String >& value) { m_ss = value; }

  ConstArrayView< ::Struct::ITest* > getTs() override { return m_ts; }
  void setTs(Array< ::Struct::ITest* >& value) { m_ts = value; }

 protected:  // ***** ATTRIBUTS
  Integer m_y;
  Integer m_x;
  bool m_b;
  CellGroup m_c_g;
  Real m_r;
  Real2 m_r2;
  Real2x2 m_r22;
  String m_s;
  ::Struct::ITest* m_t;
  UniqueArray< String > m_ss;
  UniqueArray< ::Struct::ITest* > m_ts;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace StructOperation

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // STRUCT_OPERATION___IOPERAND_H
