#ifndef IWITHOUTS_INTERFACES_NOPROPERTYINTERFVIASTRUCTDEFAULTSERVICE_H
#define IWITHOUTS_INTERFACES_NOPROPERTYINTERFVIASTRUCTDEFAULTSERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "IWithoutS/Interfaces/__NoPropertyInterfViaStructDefaultServiceBase.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace IWithoutSInterfaces {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service IWithoutS.Interfaces.NoPropertyInterfViaStructDefault : implémentation
 * Service par défaut pour l'interface IWithoutS.Interfaces.NoPropertyInterfViaStruct
 */
class NoPropertyInterfViaStructDefaultService
: public NoPropertyInterfViaStructDefaultServiceBase<NoPropertyInterfViaStructDefaultService>
{
 public:
  explicit NoPropertyInterfViaStructDefaultService(const ServiceBuildInfo& bi);
  ~NoPropertyInterfViaStructDefaultService();

 public:
  void computeSequential(const Cell cell, NoPropertyInterfViaStructDefaultComputeSequentialVars& vars, const Real coef) override;
  void computeParallel(const Cell cell, NoPropertyInterfViaStructDefaultComputeParallelVars& vars, const Real coef) override;
  void computeByItemTypeHexaedron8(ItemVectorView items, NoPropertyInterfViaStructDefaultComputeByItemTypeVars& vars, const Real coef) override;
  void computeByEnvCell(const EnvCell envcell, NoPropertyInterfViaStructDefaultComputeByEnvCellVars& vars, const Real coef) override;
  void computeByMatCell(const MatCell matcell, NoPropertyInterfViaStructDefaultComputeByMatCellVars& vars, const Real coef) override;
  Integer getSequentialCpt(NoPropertyInterfViaStructDefaultGetSequentialCptVars& vars) override;
  Integer getParallelCpt(NoPropertyInterfViaStructDefaultGetParallelCptVars& vars) override;
  Integer getItemTypeCpt(NoPropertyInterfViaStructDefaultGetItemTypeCptVars& vars) override;

 private:
	Integer m_sequential_cpt;
	Integer m_item_type_cpt;
	AtomicInt32 m_parallel_cpt;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace IWithoutSInterfaces

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // IWITHOUTS_INTERFACES_NOPROPERTYINTERFVIASTRUCTDEFAULTSERVICE_H
