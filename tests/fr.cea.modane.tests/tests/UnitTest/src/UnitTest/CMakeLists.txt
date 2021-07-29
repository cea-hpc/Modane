cmake_minimum_required(VERSION 3.13 FATAL_ERROR)
project(UnitTestCore LANGUAGES NONE)

include(${CMAKE_CURRENT_LIST_DIR}/../../../Common.cmake)

project(UnitTest LANGUAGES C CXX)

add_executable(UnitTest
  UnitTestService.cc
  UnitTestService.h
  main.cc
  )

arcane_add_arcane_libraries_to_target(UnitTest)
target_include_directories(UnitTest PUBLIC .. ${CMAKE_CURRENT_BINARY_DIR})

arcane_target_add_axl(UnitTest UnitTest)
