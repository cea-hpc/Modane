MODULE_NAME=Hydro
EXAMPLE_ADDITIONAL_LIBS=-Wl,-rpath,. -L.

include ../../../Makefile.inc
include ../../../Makefile.module

fullclean::
	make clean
	\rm -f __*.h *.axl ${MODULE_NAME}Module.* SubEnum/__*.h EosDefault.h EosDefault.cc
	\rm -rf output ../*.modane
	