cmake_minimum_required(VERSION 3.13 FATAL_ERROR)
project(MicroHydroCore LANGUAGES NONE)

include(${CMAKE_CURRENT_LIST_DIR}/../../../Common.cmake)

project(MicroHydro LANGUAGES C CXX)

add_executable(MicroHydro
  MicroHydroModule.cc
  main.cc
  DefaultLoopDelegationService.cc
  Eos/PerfectGasService.cc
  Eos/StiffenedGasService.cc
  )

arcane_add_arcane_libraries_to_target(MicroHydro)
target_include_directories(MicroHydro PUBLIC .. ${CMAKE_CURRENT_BINARY_DIR})

arcane_target_add_axl(MicroHydro MicroHydro)
arcane_target_add_axl(MicroHydro Eos/PerfectGas)
arcane_target_add_axl(MicroHydro Eos/StiffenedGas)
arcane_target_add_axl(MicroHydro DefaultLoopDelegation)
