cmake_minimum_required(VERSION 3.13 FATAL_ERROR)
project(ServiceCore LANGUAGES NONE)

include(${CMAKE_CURRENT_LIST_DIR}/../../../Common.cmake)

project(Hydro LANGUAGES C CXX)

add_executable(Hydro
  HydroModule.cc
  HydroModule.h
  main.cc
AfaceDefault.cc
AnotherConcreteFaceDefaultService.cc
Compri2Service.cc
CompriService.cc
OrnythorinqueService.cc
SingletonDefaultService.cc
TrackingDefaultService.cc

AfaceDefault.h
AnotherConcreteFaceDefaultService.h
Compri2Service.h
CompriService.h
OrnythorinqueService.h
SingletonDefaultService.h
TrackingDefaultService.h
)

arcane_add_arcane_libraries_to_target(Hydro)
target_include_directories(Hydro PUBLIC .. ${CMAKE_CURRENT_BINARY_DIR})

arcane_target_add_axl(Hydro Hydro)
arcane_target_add_axl(Hydro AnotherConcreteFaceDefault)
arcane_target_add_axl(Hydro Compri2)
arcane_target_add_axl(Hydro Compri)
arcane_target_add_axl(Hydro Ornythorinque)
arcane_target_add_axl(Hydro SingletonDefault)
arcane_target_add_axl(Hydro TrackingDefault)
