MODULE_NAME=Hydro
EXAMPLE_ADDITIONAL_LIBS=-Wl,-rpath,. -L. -lCompri -lCompri2 -lAface -lSingleton -lOrnythorinque
EXAMPLE_ADDITIONAL_TARGETS=libCompri.so libCompri2.so libAface.so libAnotherConcreteFace.so libSingleton.so libTracking.so libOrnythorinque.so

include ../../../Makefile.inc
include ../../../Makefile.module

libCompri.so : CompriService.cc Compri_axl.h 
	$(CXX) -shared -o $@ ${CFLAGS} $<

Compri_axl.h : Compri.axl
	$(AXL_EXE) -l c++ $< 

libCompri2.so : Compri2Service.cc Compri2_axl.h
	$(CXX) -shared -o $@ ${CFLAGS} $<

Compri2_axl.h : Compri2.axl
	$(AXL_EXE) -l c++ $< 
	
libAface.so : AfaceDefault.cc
	$(CXX) -shared -o $@ ${CFLAGS} $<

libAnotherConcreteFace.so : AnotherConcreteFaceDefaultService.cc AnotherConcreteFaceDefault_axl.h
	$(CXX) -shared -o $@ ${CFLAGS} $<

AnotherConcreteFaceDefault_axl.h : AnotherConcreteFaceDefault.axl
	$(AXL_EXE) -l c++ $< 

libSingleton.so : SingletonDefaultService.cc SingletonDefault_axl.h
	$(CXX) -shared -o $@ ${CFLAGS} $<

SingletonDefault_axl.h : SingletonDefault.axl
	$(AXL_EXE) -l c++ $< 

libTracking.so : TrackingDefaultService.cc TrackingDefault_axl.h
	$(CXX) -shared -o $@ ${CFLAGS} $<

TrackingDefault_axl.h : TrackingDefault.axl
	$(AXL_EXE) -l c++ $< 

libOrnythorinque.so : OrnythorinqueService.cc Ornythorinque_axl.h 
	$(CXX) -shared -o $@ ${CFLAGS} $<

Ornythorinque_axl.h : Ornythorinque.axl
	$(AXL_EXE) -l c++ $< 
	
fullclean::
	make clean
	\rm -f __*.h *.axl CompriService.* *_axl.h Compri2Service.* AnotherConcreteFaceDefaultService.* ${MODULE_NAME}Module.* AfaceDefault.* OrnythorinqueService.* SingletonDefaultService.* TrackingDefaultService.*
	\rm -rf output ../*.modane
	