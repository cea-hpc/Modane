#
# Generated file - Do not overwrite
#
cmake_minimum_required(VERSION 3.13)
project(MicroHydroProject LANGUAGES C CXX)

set(Arcane_ROOT /home/lelandaisb/arcane/install)
include(/home/lelandaisb/arcane/install/samples/ArcaneCompilerConfig.cmake)
find_package(Arcane REQUIRED)

add_subdirectory(MicroHydro)

if (EXISTS ${CMAKE_CURRENT_SOURCE_DIR}/Project.cmake)
include(Project.cmake)
endif()
