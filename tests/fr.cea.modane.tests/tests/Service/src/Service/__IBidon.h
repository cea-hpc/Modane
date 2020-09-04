#ifndef SERVICE___IBIDON_H
#define SERVICE___IBIDON_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "arcane/ArcaneTypes.h"
#include "arcane/ItemTypes.h"
#include "arcane/Item.h"
#include "arcane/ItemVector.h"
#include "arcane/ItemVectorView.h"
#include "arcane/VariableTypes.h"
#include "arcane/utils/Array.h"
#include "Service/Legacy.h"
#include "Service/__IDeura.h"
#include "Service/__IOvipare.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

using namespace Arcane;
namespace Service {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface représentant la structure Bidon
 * 
 */
class IBidon
{
 public:
  IBidon() {}
  virtual ~IBidon() {}

 public:
  virtual ::onf::OnfUtils::Duboi* getDuboi() = 0;
  virtual Danlacol* getDanlacol() = 0;
  virtual IDeura* getDeura() = 0;
  virtual IOvipare* getOvipare() = 0;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * Classe représentant la structure Bidon
 * 
 */
class Bidon
: public IBidon
{
 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
  Bidon()
  : m_duboi(0)
  , m_danlacol(0)
  , m_deura(0)
  , m_ovipare(0)
  {}
  virtual ~Bidon() {}

 public:  // ***** ACCESSEURS
  ::onf::OnfUtils::Duboi* getDuboi() override { return m_duboi; }
  void setDuboi(::onf::OnfUtils::Duboi* value) { m_duboi = value; }

  Danlacol* getDanlacol() override { return m_danlacol; }
  void setDanlacol(Danlacol* value) { m_danlacol = value; }

  IDeura* getDeura() override { return m_deura; }
  void setDeura(IDeura* value) { m_deura = value; }

  IOvipare* getOvipare() override { return m_ovipare; }
  void setOvipare(IOvipare* value) { m_ovipare = value; }

 protected:  // ***** ATTRIBUTS
  ::onf::OnfUtils::Duboi* m_duboi;
  Danlacol* m_danlacol;
  IDeura* m_deura;
  IOvipare* m_ovipare;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace Service

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SERVICE___IBIDON_H
