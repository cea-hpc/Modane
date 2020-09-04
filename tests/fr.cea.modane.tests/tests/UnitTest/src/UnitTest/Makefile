include ../../../Makefile.inc

all : UnitTest.exe

UnitTest.exe: main.o libUnitTest.so
	$(CXX) $< -o $@ -Wl,-rpath,. -L. -lUnitTest -Wl,-rpath,. $(LIBS)

main.o: main.cc
	@echo LIBS=${ARCANE_LIBS}
	@echo FLAGS=${ARCANE_CFLAGS}
	$(CXX) -c ${CFLAGS} $< -o $@

libUnitTest.so : UnitTestService.cc UnitTest_axl.h 
	$(CXX) -shared -o $@ ${CFLAGS} $<

UnitTest_axl.h : UnitTest.axl
	$(AXL_EXE) -l c++ $< 

fullclean::
	make clean
	\rm -f __*.h *.axl *_axl.h 
	\rm -rf output 


clean::
	\rm -rf *.o lib*.so *.exe *_axl.h fatal_4 logs output