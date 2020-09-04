#ifndef ENUM___HYDROMODULEVARS_H
#define ENUM___HYDROMODULEVARS_H

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
namespace Enum {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

//! Classe de variable pour compute
struct HydroComputeVars final
{
  explicit HydroComputeVars(const VariableScalarReal& old_cell_volume)
  : m_old_cell_volume(old_cell_volume)
  {}

  /*!
  [in] old_cell_volume
  Vieux volume
  */
  const VariableScalarReal& m_old_cell_volume;
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Enum

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // ENUM___HYDROMODULEVARS_H
