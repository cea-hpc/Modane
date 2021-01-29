MODULE_NAME=Hydro
EXAMPLE_ADDITIONAL_LIBS=-Wl,-rpath,. -L. -lEosDefault
EXAMPLE_ADDITIONAL_TARGETS=libEosDefault.so

include ../../../Makefile.inc
include ../../../Makefile.module

libEosDefault.so : EosDefault.cc
	$(CXX) -shared -o $@ ${CFLAGS} $<

fullclean::
	make clean
	\rm -f __*.h *.axl ${MODULE_NAME}Module.* SubEnum/__*.h EosDefault.h EosDefault.cc
	\rm -rf output ../*.modane
	