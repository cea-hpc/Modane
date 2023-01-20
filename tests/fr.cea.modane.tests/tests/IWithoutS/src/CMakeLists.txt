cmake_minimum_required(VERSION 3.13 FATAL_ERROR)
project(IWithoutSCore LANGUAGES NONE)

include(${CMAKE_CURRENT_LIST_DIR}/../../Common.cmake)

project(Hydro LANGUAGES C CXX)
find_package(Arcane REQUIRED)

add_executable(Hydro
  IWithoutS/HydroModule.cc
  IWithoutS/HydroModule.h
  IWithoutS/ChildDefault.cc
  IWithoutS/ChildDefault.h
  IWithoutS/MotherDefault.cc
  IWithoutS/MotherDefault.h
  IWithoutS/Interfaces/NoPropertyInterfDefault.cc
  IWithoutS/Interfaces/RefPropertyInterfDefault.cc
  IWithoutS/Interfaces/NoPropertyInterfViaStructDefaultService.cc
  IWithoutS/Outside/OutsideService.cc
  IWithoutS/Eos/EosDefaultService.cc
  IWithoutS/main.cc
  IWithoutS/Hydro_axl.h
  IWithoutS/Outside/Outside_axl.h
  IWithoutS/Interfaces/NoPropertyInterfViaStructDefault_axl.h
  IWithoutS/Eos/EosDefault_axl.h
)

arcane_generate_axl(IWithoutS/Hydro)
arcane_generate_axl(IWithoutS/Outside/Outside)
arcane_generate_axl(IWithoutS/Interfaces/NoPropertyInterfViaStructDefault)
arcane_generate_axl(IWithoutS/Eos/EosDefault)
target_link_libraries(Hydro PRIVATE arcane_full)
target_include_directories(Hydro PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_BINARY_DIR})
