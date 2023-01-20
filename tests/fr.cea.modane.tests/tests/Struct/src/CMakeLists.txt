cmake_minimum_required(VERSION 3.13 FATAL_ERROR)
project(StructCore LANGUAGES NONE)

include(${CMAKE_CURRENT_LIST_DIR}/../../Common.cmake)

project(Calculator LANGUAGES C CXX)
find_package(Arcane REQUIRED)

add_executable(Calculator
  Struct/CalculatorModule.cc
  Struct/CalculatorModule.h
  Struct/Operation/AddService.cc
  Struct/Operation/SubService.cc
  Struct/main.cc
  Struct/Calculator_axl.h
  Struct/Operation/Add_axl.h
  Struct/Operation/Sub_axl.h
)

arcane_generate_axl(Struct/Calculator)
arcane_generate_axl(Struct/Operation/Add)
arcane_generate_axl(Struct/Operation/Sub)
target_link_libraries(Calculator PRIVATE arcane_full)
target_include_directories(Calculator PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_BINARY_DIR})
