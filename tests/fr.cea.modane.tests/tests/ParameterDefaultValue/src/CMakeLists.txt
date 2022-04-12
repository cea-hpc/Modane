cmake_minimum_required(VERSION 3.13 FATAL_ERROR)
project(ParameterVarCore LANGUAGES NONE)

include(${CMAKE_CURRENT_LIST_DIR}/../../Common.cmake)

project(Hydro LANGUAGES C CXX)

add_executable(Hydro
  ParameterDefaultValue/HydroModule.cc
  ParameterDefaultValue/HydroModule.h
  ParameterDefaultValue/NoVarAsArgs/UpdaterNoVarsImplService.cc
  ParameterDefaultValue/VarAsArgs/UpdaterImplService.cc
  ParameterDefaultValue/main.cc
  ParameterDefaultValue/Hydro_axl.h
  ParameterDefaultValue/VarAsArgs/UpdaterImpl_axl.h
  ParameterDefaultValue/NoVarAsArgs/UpdaterNoVarsImpl_axl.h
)

arcane_generate_axl(ParameterDefaultValue/Hydro)
arcane_generate_axl(ParameterDefaultValue/VarAsArgs/UpdaterImpl)
arcane_generate_axl(ParameterDefaultValue/NoVarAsArgs/UpdaterNoVarsImpl)
target_link_libraries(Hydro PRIVATE arcane_full)
target_include_directories(Hydro PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_BINARY_DIR})
