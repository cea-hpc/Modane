MODULE_NAME=Hydro
EXAMPLE_ADDITIONAL_LIBS=-Wl,-rpath,. -L. -lUpdaterImpl 
EXAMPLE_ADDITIONAL_TARGETS=libUpdaterImpl.so 

include ../../../Makefile.inc
include ../../../Makefile.module

libUpdaterImpl.so : Updater/UpdaterImplService.cc Updater/UpdaterImpl_axl.h
	$(CXX) -shared -o $@ ${CFLAGS} $<

Updater/UpdaterImpl_axl.h : Updater/UpdaterImpl.axl
	$(AXL_EXE) -l c++ -o Updater $< 

fullclean::
	make clean
	\rm -f __*.h *.axl *_axl.h Updater/__*.h Updater/*.axl Updater/*_axl.h *.*nabla Updater/*.*nabla 
	\rm -rf output ../../doc ../*.modane

doc::
	doxygen Doxyfile
