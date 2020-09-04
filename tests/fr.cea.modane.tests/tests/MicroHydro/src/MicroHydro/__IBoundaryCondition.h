#ifndef MICROHYDRO___IBOUNDARYCONDITION_H
#define MICROHYDRO___IBOUNDARYCONDITION_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "MicroHydro/__BoundaryConditionType.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace MicroHydro {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface représentant la structure BoundaryCondition
 * 
 */
class IBoundaryCondition
{
 public:
  IBoundaryCondition() {}
  virtual ~IBoundaryCondition() {}

 public:
  virtual BoundaryConditionType getType() = 0;
  virtual FaceGroup getSurface() = 0;
  virtual Real getValue() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * Classe représentant la structure BoundaryCondition
 * 
 */
class BoundaryCondition
: public IBoundaryCondition
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  BoundaryCondition()
  : m_type(BoundaryConditionType())
  , m_surface(FaceGroup())
  , m_value(Real())
  {}
  virtual ~BoundaryCondition() {}

 public:  // ***** ACCESSEURS
  BoundaryConditionType getType() override { return m_type; }
  void setType(BoundaryConditionType value) { m_type = value; }

  FaceGroup getSurface() override { return m_surface; }
  void setSurface(FaceGroup value) { m_surface = value; }

  Real getValue() override { return m_value; }
  void setValue(Real value) { m_value = value; }

 protected:  // ***** ATTRIBUTS
  BoundaryConditionType m_type;
  FaceGroup m_surface;
  Real m_value;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace MicroHydro

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // MICROHYDRO___IBOUNDARYCONDITION_H
