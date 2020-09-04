MODULE_NAME=Hydro
EXAMPLE_ADDITIONAL_LIBS=-Wl,-rpath,. -L. -lPerfectGas -lStiffenedGas -lNoVarAsArgs
EXAMPLE_ADDITIONAL_TARGETS=libPerfectGas.so libStiffenedGas.so libNoVarAsArgs.so

include ../../../Makefile.inc
include ../../../Makefile.module

libPerfectGas.so : PerfectGasService.cc PerfectGas_axl.h 
	$(CXX) -shared -o $@ ${CFLAGS} $<

PerfectGas_axl.h : PerfectGas.axl
	$(AXL_EXE) -l c++ $< 

libStiffenedGas.so : StiffenedGasService.cc StiffenedGas_axl.h 
	$(CXX) -shared -o $@ ${CFLAGS} $<

StiffenedGas_axl.h : StiffenedGas.axl
	$(AXL_EXE) -l c++ $< 

libNoVarAsArgs.so : NoVarAsArgs/MyEosDelegationService.cc NoVarAsArgs/MyEosDelegation_axl.h 
	$(CXX) -shared -o $@ ${CFLAGS} $< 

NoVarAsArgs/MyEosDelegation_axl.h : NoVarAsArgs/MyEosDelegation.axl
	$(AXL_EXE) -l c++ -o NoVarAsArgs $< 

fullclean::
	make clean
	\rm -f __*.h *.axl PerfectGasService.* PerfectGas_axl.h StiffenedGasService.* StiffenedGas_axl.h ${MODULE_NAME}Module.* NoVarAsArgs/__*.h NoVarAsArgs/MyEosDelegation*
	\rm -rf output ../*.modane
