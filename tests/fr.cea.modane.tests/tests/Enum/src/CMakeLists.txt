cmake_minimum_required(VERSION 3.13 FATAL_ERROR)
project(EnumCore LANGUAGES NONE)

include(${CMAKE_CURRENT_LIST_DIR}/../../Common.cmake)

project(Hydro LANGUAGES C CXX)
find_package(Arcane REQUIRED)

add_executable(Hydro
  Enum/HydroModule.cc
  Enum/EosDefault.cc
  Enum/EosDefault.h
  Enum/main.cc
  Enum/Hydro_axl.h
)

arcane_generate_axl(Enum/Hydro)
target_link_libraries(Hydro PRIVATE arcane_full)
target_include_directories(Hydro PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_BINARY_DIR})
