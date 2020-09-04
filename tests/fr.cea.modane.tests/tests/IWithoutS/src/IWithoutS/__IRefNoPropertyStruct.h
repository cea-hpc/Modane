#ifndef IWITHOUTS___IREFNOPROPERTYSTRUCT_H
#define IWITHOUTS___IREFNOPROPERTYSTRUCT_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "IWithoutS/Interfaces/__INoPropertyInterfViaStruct.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace IWithoutS {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface représentant la structure RefNoPropertyStruct
 * 
 */
class IRefNoPropertyStruct
{
 public:
  IRefNoPropertyStruct() {}
  virtual ~IRefNoPropertyStruct() {}

 public:
  virtual ::IWithoutSInterfaces::INoPropertyInterfViaStruct* getInterf() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * Classe représentant la structure RefNoPropertyStruct
 * 
 */
class RefNoPropertyStruct
: public IRefNoPropertyStruct
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  RefNoPropertyStruct()
  : m_interf(0)
  {}
  virtual ~RefNoPropertyStruct() {}

 public:  // ***** ACCESSEURS
  ::IWithoutSInterfaces::INoPropertyInterfViaStruct* getInterf() override { return m_interf; }
  void setInterf(::IWithoutSInterfaces::INoPropertyInterfViaStruct* value) { m_interf = value; }

 protected:  // ***** ATTRIBUTS
  ::IWithoutSInterfaces::INoPropertyInterfViaStruct* m_interf;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutS

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS___IREFNOPROPERTYSTRUCT_H
