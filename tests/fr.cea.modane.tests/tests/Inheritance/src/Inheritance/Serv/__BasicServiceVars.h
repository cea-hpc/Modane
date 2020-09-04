#ifndef INHERITANCE_SERV___BASICSERVICEVARS_H
#define INHERITANCE_SERV___BASICSERVICEVARS_H

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
namespace InheritanceServ {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

//! Classe de variable pour g
struct BasicGVars final
{
  BasicGVars()
  {}
};

//! Classe de variable pour f
struct BasicFVars final
{
  BasicFVars()
  {}
};

//! Classe de variable pour testAutoInclude
struct BasicTestAutoIncludeVars final
{
  BasicTestAutoIncludeVars()
  {}
};


/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace InheritanceServ

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // INHERITANCE_SERV___BASICSERVICEVARS_H
