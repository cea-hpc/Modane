#ifndef PARAMETER___ICOMPLEXTYPE_H
#define PARAMETER___ICOMPLEXTYPE_H

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
namespace Parameter {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface représentant la structure ComplexType
 * 
 */
class IComplexType
{
 public:
  IComplexType() {}
  virtual ~IComplexType() {}

 public:
  virtual Real getOptionReal() = 0;
  virtual ConstArrayView< Real > getOptionReals() = 0;
  virtual ItemGroup getOptionItemGroup() = 0;
  virtual ConstArrayView< ItemGroup > getOptionItemGroups() = 0;
  virtual Int32 getOptionInt32() = 0;
  virtual Int64 getOptionInt64() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * Classe représentant la structure ComplexType
 * 
 */
class ComplexType
: public IComplexType
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  ComplexType()
  : m_option_real(Real())
  , m_option_reals(UniqueArray< Real >())
  , m_option_item_group(ItemGroup())
  , m_option_item_groups(UniqueArray< ItemGroup >())
  , m_option_int32(Int32())
  , m_option_int64(Int64())
  {}
  virtual ~ComplexType() {}

 public:  // ***** ACCESSEURS
  Real getOptionReal() override { return m_option_real; }
  void setOptionReal(Real value) { m_option_real = value; }

  ConstArrayView< Real > getOptionReals() override { return m_option_reals; }
  void setOptionReals(Array< Real >& value) { m_option_reals = value; }

  ItemGroup getOptionItemGroup() override { return m_option_item_group; }
  void setOptionItemGroup(ItemGroup value) { m_option_item_group = value; }

  ConstArrayView< ItemGroup > getOptionItemGroups() override { return m_option_item_groups; }
  void setOptionItemGroups(Array< ItemGroup >& value) { m_option_item_groups = value; }

  Int32 getOptionInt32() override { return m_option_int32; }
  void setOptionInt32(Int32 value) { m_option_int32 = value; }

  Int64 getOptionInt64() override { return m_option_int64; }
  void setOptionInt64(Int64 value) { m_option_int64 = value; }

 protected:  // ***** ATTRIBUTS
  Real m_option_real;
  UniqueArray< Real > m_option_reals;
  ItemGroup m_option_item_group;
  UniqueArray< ItemGroup > m_option_item_groups;
  Int32 m_option_int32;
  Int64 m_option_int64;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Parameter

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // PARAMETER___ICOMPLEXTYPE_H
