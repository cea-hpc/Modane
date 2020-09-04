MODULE_NAME=Calculator
EXAMPLE_ADDITIONAL_LIBS=-Wl,-rpath,. -L. -lAdd -lSub
EXAMPLE_ADDITIONAL_TARGETS=libAdd.so libSub.so

include ../../../Makefile.inc
include ../../../Makefile.module

libAdd.so : Operation/AddService.cc Operation/Add_axl.h 
	$(CXX) -shared -o $@ ${CFLAGS} $<

Operation/Add_axl.h : Operation/Add.axl
	$(AXL_EXE) -l c++ -o Operation $< 


libSub.so : Operation/SubService.cc Operation/Sub_axl.h
	$(CXX) -shared -o $@ ${CFLAGS} $<

Operation/Sub_axl.h : Operation/Sub.axl
	$(AXL_EXE) -l c++ -o Operation $< 
	
fullclean::
	make clean
	\rm -f __*.h *.axl Operation/__*.h Operation/*.axl Operation/*_axl.h
	\rm -rf output ../*.modane
	