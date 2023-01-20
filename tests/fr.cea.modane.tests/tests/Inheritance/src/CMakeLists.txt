cmake_minimum_required(VERSION 3.13 FATAL_ERROR)
project(InheritanceCore LANGUAGES NONE)

include(${CMAKE_CURRENT_LIST_DIR}/../../Common.cmake)

project(Hydro LANGUAGES C CXX)
find_package(Arcane REQUIRED)

add_executable(Hydro
  Inheritance/HydroModule.cc
  Inheritance/HydroModule.h
  Inheritance/Serv/BasicService.cc
  Inheritance/Serv/BasicService.h
  Inheritance/Serv/MyParentInterfDefault.cc
  Inheritance/Serv/MyParentInterfDefault.h
  Inheritance/main.cc
  Inheritance/Hydro_axl.h
  Inheritance/Serv/Basic_axl.h
)

arcane_generate_axl(Inheritance/Hydro)
arcane_generate_axl(Inheritance/Serv/Basic)
target_link_libraries(Hydro PRIVATE arcane_full)
target_include_directories(Hydro PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_BINARY_DIR})
