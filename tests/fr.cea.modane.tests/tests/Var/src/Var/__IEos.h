#ifndef VAR___IEOS_H
#define VAR___IEOS_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Var/NoVarAsArgs/__IEosDelegation.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Var {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface Eos
 * 
 */
class IEos
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  IEos() {}
  virtual ~IEos() {}

 public:  // ***** ACCESSEURS ABSTRAITS
  virtual const String getImplName() const = 0;
  virtual ::VarNoVarAsArgs::IEosDelegation* getDelegation() = 0;

 public:  // ***** METHODES ABSTRAITES
  /*!
  Cette méthode est implémentée dans :
  \li PerfectGasServiceBase::apply
  \li StiffenedGasServiceBase::apply
  */
  virtual void apply(const VariableParticleReal& abstract_particle_var, const Real coef) = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Var

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // VAR___IEOS_H
