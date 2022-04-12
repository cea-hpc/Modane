cmake_minimum_required(VERSION 3.13 FATAL_ERROR)
project(SupportCore LANGUAGES NONE)

include(${CMAKE_CURRENT_LIST_DIR}/../../Common.cmake)

project(Hydro LANGUAGES C CXX)

add_executable(Hydro
  Support/HydroModule.cc
  Support/HydroModule.h
  Support/Eos/PerfectGasService.cc
  Support/Eos/PerfectGasService.h
  Support/main.cc
  Support/Hydro_axl.h
  Support/Eos/PerfectGas_axl.h
)

arcane_generate_axl(Support/Hydro)
arcane_generate_axl(Support/Eos/PerfectGas)
target_link_libraries(Hydro PRIVATE arcane_full)
target_include_directories(Hydro PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_BINARY_DIR})
