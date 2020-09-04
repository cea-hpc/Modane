#
# Generated file - Do not overwrite
#
cmake_minimum_required(VERSION 3.10)
include(/ccc/home/cont001/arcaneuser/arcaneuser/products/rhel7/arcane/dev5_debug/samples/ArcaneCompilerConfig.cmake)
project(MicroHydroProject LANGUAGES C CXX)
find_package(Arcane)
add_subdirectory(MicroHydro)
if (EXISTS ${CMAKE_CURRENT_SOURCE_DIR}/Project.cmake)
include(Project.cmake)
endif()
