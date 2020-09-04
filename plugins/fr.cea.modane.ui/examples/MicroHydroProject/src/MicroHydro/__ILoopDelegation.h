#ifndef MICROHYDRO___ILOOPDELEGATION_H
#define MICROHYDRO___ILOOPDELEGATION_H

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
 * \brief Interface LoopDelegation
 * 
 */
class ILoopDelegation
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  ILoopDelegation() {}
  virtual ~ILoopDelegation() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li DefaultLoopDelegationServiceBase::computeNodeImpulsion
  */
  virtual void computeNodeImpulsion(const NodeVectorView items) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li DefaultLoopDelegationServiceBase::applyBoundaryCondition
  */
  virtual void applyBoundaryCondition(const FaceVectorView items, const Real boundary_condition_value, const BoundaryConditionType boundary_condition_type) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li DefaultLoopDelegationServiceBase::moveNodes
  */
  virtual void moveNodes(const NodeVectorView items) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li DefaultLoopDelegationServiceBase::computeGeometricValues
  */
  virtual void computeGeometricValues(const CellVectorView items) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li DefaultLoopDelegationServiceBase::updateDensity
  */
  virtual void updateDensity(const CellVectorView items) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li DefaultLoopDelegationServiceBase::computeInternalEnergy
  */
  virtual void computeInternalEnergy(const CellVectorView items) = 0;
  /*!
  Cette méthode est implémentée dans :
  \li DefaultLoopDelegationServiceBase::computePressureForce
  */
  virtual void computePressureForce(const CellVectorView items) = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace MicroHydro

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // MICROHYDRO___ILOOPDELEGATION_H
