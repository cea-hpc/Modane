MODULE_NAME=Hydro
EXAMPLE_ADDITIONAL_LIBS=-Wl,-rpath,. -L. -lPerfectGas
EXAMPLE_ADDITIONAL_TARGETS=libPerfectGas.so

include ../../../Makefile.inc
include ../../../Makefile.module

libPerfectGas.so : Eos/PerfectGasService.cc Eos/PerfectGas_axl.h 
	$(CXX) -shared -o $@ ${CFLAGS} $< 

Eos/PerfectGas_axl.h : Eos/PerfectGas.axl
	$(AXL_EXE) -l c++ -o Eos $< 


fullclean::
	make clean
	\rm -f __*.h *.axl Eos/__*.h Eos/*.axl Eos/*_axl.h
	\rm -rf output ../../doc ../*.modane

doc::
	doxygen Doxyfile
	