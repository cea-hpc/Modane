cmake_minimum_required(VERSION 3.13 FATAL_ERROR)
project(PtyOnInterfaceCore LANGUAGES NONE)

include(${CMAKE_CURRENT_LIST_DIR}/../../../Common.cmake)

project(Hydro LANGUAGES C CXX)

add_executable(Hydro
  HydroModule.cc
  HydroModule.h
  MyInterfDefaultService.cc
  MyInterfDefaultService.h
  PerfectGasService.cc
  PerfectGasService.h
  StiffenedGasService.cc
  StiffenedGasService.h
  main.cc
  )

arcane_add_arcane_libraries_to_target(Hydro)
target_include_directories(Hydro PUBLIC .. ${CMAKE_CURRENT_BINARY_DIR})

arcane_target_add_axl(Hydro Hydro)
arcane_target_add_axl(Hydro MyInterfDefault)
arcane_target_add_axl(Hydro PerfectGas)
arcane_target_add_axl(Hydro StiffenedGas)
