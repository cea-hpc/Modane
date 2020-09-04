#ifndef ___HYDROMODULEVARS_H
#define ___HYDROMODULEVARS_H

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

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

//! Classe de variable pour compute
struct HydroComputeVars final
{
  explicit HydroComputeVars(VariableScalarReal& var)
  : m_var(var)
  {}

  /*!
  [out] var
  */
  VariableScalarReal& m_var;
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // ___HYDROMODULEVARS_H
