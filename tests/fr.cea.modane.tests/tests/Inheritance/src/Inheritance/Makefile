MODULE_NAME=Hydro
EXAMPLE_ADDITIONAL_LIBS=-Wl,-rpath,. -L. -lBasic -lParentInterf
EXAMPLE_ADDITIONAL_TARGETS=libBasic.so libParentInterf.so

include ../../../Makefile.inc
include ../../../Makefile.module

libBasic.so : Serv/BasicService.cc Serv/Basic_axl.h
	$(CXX) -shared -o $@ ${CFLAGS} $<

Serv/Basic_axl.h : Serv/Basic.axl
	$(AXL_EXE) -l c++ -o Serv $< 


libParentInterf.so : Serv/MyParentInterfDefault.cc 
	$(CXX) -shared -o $@ ${CFLAGS} $<
	
fullclean::
	make clean
	\rm -f __*.h *.axl Serv/__*.h Serv/*.axl Serv/*_axl.h ${MODULE_NAME}Module.* Serv/BasicService.* Serv/MyParentInterfDefault.*
	\rm -rf output ../*.modane
