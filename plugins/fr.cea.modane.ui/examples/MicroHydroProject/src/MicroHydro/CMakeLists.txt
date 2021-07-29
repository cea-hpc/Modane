#
# Generated file - Do not overwrite
#
add_library(MicroHydro
  DefaultLoopDelegationService.cc
  MicroHydroModule.cc
)

target_include_directories(MicroHydro PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_CURRENT_BINARY_DIR})
arcane_add_arcane_libraries_to_target(MicroHydro)

arcane_target_add_axl(MicroHydro DefaultLoopDelegation)
arcane_target_add_axl(MicroHydro MicroHydro)

add_subdirectory(Eos)

if (EXISTS ${CMAKE_CURRENT_SOURCE_DIR}/Project.cmake)
include(Project.cmake)
endif()
