#ifndef ENUM___IPSEUDOVISCOSITY_H
#define ENUM___IPSEUDOVISCOSITY_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Enum/SubEnum/__PseudoViscosityType.h"
#include "Enum/__PseudoViscosityLimiter.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Enum {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface représentant la structure PseudoViscosity
 * Pseudo Viscosité
 */
class IPseudoViscosity
{
 public:
  IPseudoViscosity() {}
  virtual ~IPseudoViscosity() {}

 public:
  virtual ::EnumSubEnum::PseudoViscosityType getType() = 0;
  virtual PseudoViscosityLimiter getLimiterTvd() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * Classe représentant la structure PseudoViscosity
 * Pseudo Viscosité
 */
class PseudoViscosity
: public IPseudoViscosity
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  PseudoViscosity()
  : m_type(::EnumSubEnum::PseudoViscosityType())
  , m_limiter_tvd(PseudoViscosityLimiter())
  {}
  virtual ~PseudoViscosity() {}

 public:  // ***** ACCESSEURS
  ::EnumSubEnum::PseudoViscosityType getType() override { return m_type; }
  void setType(::EnumSubEnum::PseudoViscosityType value) { m_type = value; }

  PseudoViscosityLimiter getLimiterTvd() override { return m_limiter_tvd; }
  void setLimiterTvd(PseudoViscosityLimiter value) { m_limiter_tvd = value; }

 protected:  // ***** ATTRIBUTS
  ::EnumSubEnum::PseudoViscosityType m_type;
  PseudoViscosityLimiter m_limiter_tvd;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Enum

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // ENUM___IPSEUDOVISCOSITY_H
