MODULE_NAME=MicroHydro
EXAMPLE_ADDITIONAL_LIBS=-Wl,-rpath,. -L. -lPerfectGas -lStiffenedGas -lDefaultLoopDelegation
EXAMPLE_ADDITIONAL_TARGETS=libPerfectGas.so libStiffenedGas.so libDefaultLoopDelegation.so

include ../../../Makefile.inc
include ../../../Makefile.module

libPerfectGas.so : Eos/PerfectGasService.cc Eos/PerfectGas_axl.h 
	$(CXX) -shared -o $@ ${CFLAGS} $<

Eos/PerfectGas_axl.h : Eos/PerfectGas.axl
	$(AXL_EXE) -l c++ -o Eos $< 

libStiffenedGas.so : Eos/StiffenedGasService.cc Eos/StiffenedGas_axl.h
	$(CXX) -shared -o $@ ${CFLAGS} $<

Eos/StiffenedGas_axl.h : Eos/StiffenedGas.axl
	$(AXL_EXE) -l c++ -o Eos $< 

libDefaultLoopDelegation.so : DefaultLoopDelegationService.cc DefaultLoopDelegation_axl.h 
	$(CXX) -shared -o $@ ${CFLAGS} $<

DefaultLoopDelegation_axl.h :DefaultLoopDelegation.axl
	$(AXL_EXE) -l c++ $< 

fullclean::
	make clean
	\rm -f __*.h *.axl *_axl.h Eos/__*.h Eos/*.axl Eos/*_axl.h *.*nabla Eos/*.*nabla 
	\rm -rf output ../../doc ../*.modane

doc::
	doxygen Doxyfile
