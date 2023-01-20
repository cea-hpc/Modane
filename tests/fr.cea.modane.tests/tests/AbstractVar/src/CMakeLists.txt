cmake_minimum_required(VERSION 3.13 FATAL_ERROR)
project(AbstractVarCore LANGUAGES NONE)

include(${CMAKE_CURRENT_LIST_DIR}/../../Common.cmake)

project(Hydro LANGUAGES C CXX)
find_package(Arcane REQUIRED)

add_executable(Hydro
  AbstractVar/HydroModule.cc
  AbstractVar/Updater/UpdaterImplService.cc
  AbstractVar/Updater/UpdaterImplService.h
  AbstractVar/main.cc
  AbstractVar/Hydro_axl.h
  AbstractVar/Updater/UpdaterImpl_axl.h
)

arcane_generate_axl(AbstractVar/Hydro)
arcane_generate_axl(AbstractVar/Updater/UpdaterImpl)
target_link_libraries(Hydro PRIVATE arcane_full)
target_include_directories(Hydro PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_BINARY_DIR})
