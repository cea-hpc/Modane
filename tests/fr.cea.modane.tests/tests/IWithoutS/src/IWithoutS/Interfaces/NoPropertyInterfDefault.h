#ifndef IWITHOUTS_INTERFACES_NOPROPERTYINTERFDEFAULT_H
#define IWITHOUTS_INTERFACES_NOPROPERTYINTERFDEFAULT_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "IWithoutS/Interfaces/__NoPropertyInterfDefaultBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace IWithoutSInterfaces {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Interface IWithoutS.Interfaces.NoPropertyInterf : implémentation
 * 
 */
class NoPropertyInterfDefault
: public NoPropertyInterfDefaultBase<NoPropertyInterfDefault>
{
 public:
  explicit NoPropertyInterfDefault(IMesh* mesh);
  ~NoPropertyInterfDefault();

 public:
  void computeSequential(const Cell cell, NoPropertyInterfDefaultComputeSequentialVars& vars, const Real coef) override;
  void computeParallel(const Cell cell, NoPropertyInterfDefaultComputeParallelVars& vars, const Real coef) override;
  void computeByItemTypeHexaedron8(ItemVectorView items, NoPropertyInterfDefaultComputeByItemTypeVars& vars, const Real coef) override;
  void computeByEnvCell(const EnvCell envcell, NoPropertyInterfDefaultComputeByEnvCellVars& vars, const Real coef) override;
  void computeByMatCell(const MatCell matcell, NoPropertyInterfDefaultComputeByMatCellVars& vars, const Real coef) override;
  Integer getSequentialCpt(NoPropertyInterfDefaultGetSequentialCptVars& vars) override;
  Integer getParallelCpt(NoPropertyInterfDefaultGetParallelCptVars& vars) override;
  Integer getItemTypeCpt(NoPropertyInterfDefaultGetItemTypeCptVars& vars) override;

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

#endif  // IWITHOUTS_INTERFACES_NOPROPERTYINTERFDEFAULT_H
