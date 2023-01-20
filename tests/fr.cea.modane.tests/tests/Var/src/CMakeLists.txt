cmake_minimum_required(VERSION 3.13 FATAL_ERROR)
project(PtyOnInterfaceCore LANGUAGES NONE)

include(${CMAKE_CURRENT_LIST_DIR}/../../Common.cmake)

project(Hydro LANGUAGES C CXX)
find_package(Arcane REQUIRED)

add_executable(Hydro
  Var/HydroModule.cc
  Var/HydroModule.h
  Var/PerfectGasService.cc
  Var/PerfectGasService.h
  Var/StiffenedGasService.cc
  Var/StiffenedGasService.h
  Var/NoVarAsArgs/MyEosDelegationService.cc
  Var/NoVarAsArgs/MyEosDelegationService.h
  Var/main.cc
  Var/Hydro_axl.h
  Var/PerfectGas_axl.h
  Var/StiffenedGas_axl.h
  Var/NoVarAsArgs/MyEosDelegation_axl.h
)

arcane_generate_axl(Var/Hydro)
arcane_generate_axl(Var/PerfectGas)
arcane_generate_axl(Var/StiffenedGas)
arcane_generate_axl(Var/NoVarAsArgs/MyEosDelegation)
target_link_libraries(Hydro PRIVATE arcane_full)
target_include_directories(Hydro PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_BINARY_DIR})
