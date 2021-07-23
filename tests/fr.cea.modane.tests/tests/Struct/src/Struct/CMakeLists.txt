cmake_minimum_required(VERSION 3.13 FATAL_ERROR)
project(StructCore LANGUAGES NONE)

include(${CMAKE_CURRENT_LIST_DIR}/../../../Common.cmake)

project(Calculator LANGUAGES C CXX)

add_executable(Calculator
  CalculatorModule.cc
  CalculatorModule.h
  Operation/AddService.cc
  Operation/SubService.cc
  main.cc
  )

arcane_add_arcane_libraries_to_target(Calculator)
target_include_directories(Calculator PUBLIC .. ${CMAKE_CURRENT_BINARY_DIR})

arcane_target_add_axl(Calculator Calculator)
arcane_target_add_axl(Calculator Operation/Add)
arcane_target_add_axl(Calculator Operation/Sub)
