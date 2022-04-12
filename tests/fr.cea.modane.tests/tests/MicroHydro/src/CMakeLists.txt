cmake_minimum_required(VERSION 3.13 FATAL_ERROR)
project(MicroHydroCore LANGUAGES NONE)

include(${CMAKE_CURRENT_LIST_DIR}/../../Common.cmake)

project(Hydro LANGUAGES C CXX)

add_executable(Hydro
  MicroHydro/MicroHydroModule.cc
  MicroHydro/main.cc
  MicroHydro/DefaultLoopDelegationService.cc
  MicroHydro/Eos/PerfectGasService.cc
  MicroHydro/Eos/StiffenedGasService.cc
  MicroHydro/MicroHydro_axl.h
  MicroHydro/Eos/PerfectGas_axl.h
  MicroHydro/Eos/StiffenedGas_axl.h
  MicroHydro/DefaultLoopDelegation_axl.h
)

arcane_generate_axl(MicroHydro/MicroHydro)
arcane_generate_axl(MicroHydro/Eos/PerfectGas)
arcane_generate_axl(MicroHydro/Eos/StiffenedGas)
arcane_generate_axl(MicroHydro/DefaultLoopDelegation)
target_link_libraries(Hydro PRIVATE arcane_full)
target_include_directories(Hydro PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_BINARY_DIR})
