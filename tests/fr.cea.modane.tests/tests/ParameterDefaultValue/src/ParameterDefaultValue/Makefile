MODULE_NAME=Hydro
EXAMPLE_ADDITIONAL_LIBS=-Wl,-rpath,. -L. -lVarAsArgs -lNoVarAsArgs
EXAMPLE_ADDITIONAL_TARGETS=libVarAsArgs.so libNoVarAsArgs.so

include ../../../Makefile.inc
include ../../../Makefile.module

libVarAsArgs.so : VarAsArgs/UpdaterImplService.cc VarAsArgs/UpdaterImpl_axl.h
	$(CXX) -shared -o $@ ${CFLAGS} $<

VarAsArgs/UpdaterImpl_axl.h : VarAsArgs/UpdaterImpl.axl
	$(AXL_EXE) -l c++ -o VarAsArgs $<

libNoVarAsArgs.so : NoVarAsArgs/UpdaterNoVarsImplService.cc NoVarAsArgs/UpdaterNoVarsImpl_axl.h
	$(CXX) -shared -o $@ ${CFLAGS} $<

NoVarAsArgs/UpdaterNoVarsImpl_axl.h : NoVarAsArgs/UpdaterNoVarsImpl.axl
	$(AXL_EXE) -l c++ -o NoVarAsArgs $<

fullclean::
	make clean
	\rm -f __*.h *.axl VarAsArgs/__*.h VarAsArgs/*.axl VarAsArgs/*_axl.h NoVarAsArgs/__*.h NoVarAsArgs/*.axl NoVarAsArgs/*_axl.h
	\rm -rf output ../*.modane
