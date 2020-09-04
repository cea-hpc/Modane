#ARCANE_ROOT=/ccc/products/nec/arcane/gcc6-mpich3/cea/2.9.1/release
ARCANE_ROOT=/ccc/products/nec/arcane/gcc6-mpich3/cea/dev1_2140/dbg

ARCANE_PKG_PATH=${ARCANE_ROOT}/lib/pkgconfig

ARCANE_EXTRA_LIBS=$(shell PKG_CONFIG_PATH=${ARCANE_PKG_PATH} pkg-config --libs arcane)
ARCANE_LIBS=-L/ccc/products/opendist/gcc/tbb/2018.2/lib -L/ccc/products/icc-17.0.4.196/default/17.0.4.196/lib/intel64 -L$(ARCANE_ROOT)/lib -Wl,-rpath,$(ARCANE_ROOT)/lib -larcane_std -larcane_driverlib -larcane_materials -larcane_mpithread -larcane_mpi -larcane_thread -larcane_impl -larcane_mesh -larcane_core -larcane_utils -larccore_trace -larccore_collections -larccore_base $(ARCANE_EXTRA_LIBS)
ARCANE_CFLAGS=$(shell PKG_CONFIG_PATH=${ARCANE_PKG_PATH} pkg-config --cflags arcane) -I..

GCC_ROOT=/ccc/products/opendist/gcc49/gcc/8.2
CXX=${GCC_ROOT}/bin/g++ -g -std=c++14
#CXX=/usr/local/opendev1/natif/llvm/3.3/bin/clang++ -g

LIBS=${ARCANE_LIBS} -Wl,-rpath,${GCC_ROOT}/lib64
INCS=${ARCANE_CFLAGS}
#CFLAGS=-fPIC -Wall -Wextra -pedantic ${ARCANE_CFLAGS}
CFLAGS=-fPIC -Wall -D_GLIBCXX_USE_CXX11_ABI=0 ${ARCANE_CFLAGS}

AXL_EXE = ${ARCANE_ROOT}/bin/axl2cc

