cmake_minimum_required(VERSION 3.13 FATAL_ERROR)
project(UnitTestCore LANGUAGES NONE)

include(${CMAKE_CURRENT_LIST_DIR}/../../Common.cmake)

project(Hydro LANGUAGES C CXX)

add_executable(Hydro
  UnitTest/UnitTestService.cc
  UnitTest/UnitTestService.h
  UnitTest/main.cc
  UnitTest/UnitTest_axl.h
)

arcane_generate_axl(UnitTest/UnitTest)
target_link_libraries(Hydro PRIVATE arcane_full)
target_include_directories(Hydro PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_BINARY_DIR})
