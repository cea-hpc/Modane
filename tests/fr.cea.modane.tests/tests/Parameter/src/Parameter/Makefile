MODULE_NAME=Hydro
EXAMPLE_ADDITIONAL_LIBS=-Wl,-rpath,. -L. -lParameter
EXAMPLE_ADDITIONAL_TARGETS=libParameter.so

include ../../../Makefile.inc
include ../../../Makefile.module

libParameter.so : ParameterDefault.cc ParameterDefault.h 
	$(CXX) -shared -o $@ ${CFLAGS} $<

fullclean::
	# On efface les sources du modules mais pas celles de l'interface pour vérifier que les types des paramètres sont en cohérence
	make clean
	\rm -f __*.h *.axl *_axl.h ${MODULE_NAME}Module.*
	\rm -rf output ../*.modane
	