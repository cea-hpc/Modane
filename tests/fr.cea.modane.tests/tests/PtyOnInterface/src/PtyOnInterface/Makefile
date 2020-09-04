MODULE_NAME=Hydro
EXAMPLE_ADDITIONAL_LIBS=-Wl,-rpath,. -L. -lPerfectGas -lStiffenedGas -lMyInterf
EXAMPLE_ADDITIONAL_TARGETS=libPerfectGas.so libStiffenedGas.so libMyInterf.so

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

libMyInterf.so : MyInterfDefaultService.cc MyInterfDefault_axl.h
	$(CXX) -shared -o $@ ${CFLAGS} $<

MyInterfDefault_axl.h : MyInterfDefault.axl
	$(AXL_EXE) -l c++ $< 

fullclean::
	make clean
	\rm -f __*.h *.axl *_axl.h *.*nabla 
	\rm -rf output ../../doc ../*.modane
	\rm -f MyInterfDefaultService.* PerfectGasService.* StiffenedGasService.*

doc::
	doxygen Doxyfile
