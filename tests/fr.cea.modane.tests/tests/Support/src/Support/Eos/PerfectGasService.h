#ifndef SUPPORT_EOS_PERFECTGASSERVICE_H
#define SUPPORT_EOS_PERFECTGASSERVICE_H

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#include "Support/Eos/__PerfectGasServiceBase.h"
#include "ProjectIncludes.h"

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

namespace SupportEos {

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

/*!
 * \brief Service Support.Eos.PerfectGas : implémentation
 * 
 */
class PerfectGasService
: public PerfectGasServiceBase<PerfectGasService>
{
 public:
  explicit PerfectGasService(const ServiceBuildInfo& bi);
  ~PerfectGasService();

 public:
  void computeSequential(const Cell cell, PerfectGasComputeSequentialVars& vars, const Real coef) override;
  void computeParallel(const Cell cell, PerfectGasComputeParallelVars& vars, const Real coef) override;
  void computeByItemTypeHexaedron8(ItemVectorView items, PerfectGasComputeByItemTypeVars& vars, const Real coef) override;
  void computeByMatCell(const MatCell matcell, PerfectGasComputeByMatCellVars& vars, const Real coef) override;
  void computeByEnvCell(const EnvCell envcell, PerfectGasComputeByEnvCellVars& vars, const Real coef) override;
  void computeByComponentCell(const ComponentCell componentcell, PerfectGasComputeByComponentCellVars& vars, const Real coef) override;
  void computeByAllEnvCell(const AllEnvCell allenvcell, PerfectGasComputeByAllEnvCellVars& vars, const Real coef) override;
  void computeByParticle(const Particle particle, PerfectGasComputeByParticleVars& vars, const Real coef) override;
  void computeByDof(const DoF dof, PerfectGasComputeByDofVars& vars, const Real coef) override;
  Integer getParallelCpt(PerfectGasGetParallelCptVars& vars) override;
  Integer getSequentialCpt(PerfectGasGetSequentialCptVars& vars) override;
  Integer getItemTypeCpt(PerfectGasGetItemTypeCptVars& vars) override;

 private:
	Integer m_sequential_cpt;
	Integer m_item_type_cpt;
	AtomicInt32 m_parallel_cpt;
};

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

}  // namespace SupportEos

/*---------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------*/

#endif  // SUPPORT_EOS_PERFECTGASSERVICE_H
