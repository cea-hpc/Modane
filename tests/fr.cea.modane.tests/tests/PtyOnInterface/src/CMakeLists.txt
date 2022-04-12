cmake_minimum_required(VERSION 3.13 FATAL_ERROR)
project(PtyOnInterfaceCore LANGUAGES NONE)

include(${CMAKE_CURRENT_LIST_DIR}/../../Common.cmake)

project(Hydro LANGUAGES C CXX)

add_executable(Hydro
  PtyOnInterface/HydroModule.cc
  PtyOnInterface/HydroModule.h
  PtyOnInterface/MyInterfDefaultService.cc
  PtyOnInterface/MyInterfDefaultService.h
  PtyOnInterface/PerfectGasService.cc
  PtyOnInterface/PerfectGasService.h
  PtyOnInterface/StiffenedGasService.cc
  PtyOnInterface/StiffenedGasService.h
  PtyOnInterface/main.cc
  PtyOnInterface/Hydro_axl.h
  PtyOnInterface/MyInterfDefault_axl.h
  PtyOnInterface/PerfectGas_axl.h
  PtyOnInterface/StiffenedGas_axl.h
)

arcane_generate_axl(PtyOnInterface/Hydro)
arcane_generate_axl(PtyOnInterface/MyInterfDefault)
arcane_generate_axl(PtyOnInterface/PerfectGas)
arcane_generate_axl(PtyOnInterface/StiffenedGas)
target_link_libraries(Hydro PRIVATE arcane_full)
target_include_directories(Hydro PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_BINARY_DIR})
