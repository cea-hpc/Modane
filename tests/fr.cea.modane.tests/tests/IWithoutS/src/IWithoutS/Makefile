MODULE_NAME=Hydro
EXAMPLE_ADDITIONAL_LIBS=-Wl,-rpath,. -L. -lEos -lInterfaces -lOutside -lChild
EXAMPLE_ADDITIONAL_TARGETS=libEos.so libInterfaces.so libOutside.so libChild.so libMother.so

include ../../../Makefile.inc
include ../../../Makefile.module

libOutside.so : Outside/OutsideService.cc Outside/Outside_axl.h 
	$(CXX) -shared -o $@ ${CFLAGS} $<

Outside/Outside_axl.h : Outside/Outside.axl
	$(AXL_EXE) -l c++ -o Outside $< 

Interfaces/NoPropertyInterfViaStructDefaultService.cc : Interfaces/NoPropertyInterfViaStructDefault_axl.h

libInterfaces.so : Interfaces/NoPropertyInterfDefault.cc Interfaces/RefPropertyInterfDefault.cc Interfaces/NoPropertyInterfViaStructDefaultService.cc 
	$(CXX) -shared -o $@ ${CFLAGS} $^

Interfaces/NoPropertyInterfViaStructDefault_axl.h : Interfaces/NoPropertyInterfViaStructDefault.axl
	$(AXL_EXE) -l c++ -o Interfaces $< 


Eos/EosDefaultService.cc : Eos/EosDefault_axl.h
 
libEos.so : Eos/EosDefaultService.cc 
	$(CXX) -shared -o $@ ${CFLAGS} $^

Eos/EosDefault_axl.h : Eos/EosDefault.axl
	$(AXL_EXE) -l c++ -o Eos $< 
	
ChildDefault.cc : ChildDefault.h

libChild.so : ChildDefault.cc
	$(CXX) -shared -o $@ ${CFLAGS} $<

MotherDefault.cc : MotherDefault.h

libMother.so : MotherDefault.cc
	$(CXX) -shared -o $@ ${CFLAGS} $<

fullclean::
	make clean
	\rm -f __*.h *.axl Eos/__*.h Eos/*.axl Eos/*_axl.h Interfaces/__*.h Interfaces/*.axl Interfaces/*_axl.h Variables/__*.h Outside/* ChildDefault.* MotherDefault.*
	\rm -rf output ../../doc ../*.modane

doc::
	doxygen Doxyfile
