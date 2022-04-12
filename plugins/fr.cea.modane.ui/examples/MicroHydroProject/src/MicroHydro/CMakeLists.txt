#
# Generated file - Do not overwrite
#
add_library(MicroHydro
  DefaultLoopDelegationService.cc
  MicroHydroModule.cc
  DefaultLoopDelegation_axl.h
  MicroHydro_axl.h
)

arcane_generate_axl(DefaultLoopDelegation)
arcane_generate_axl(MicroHydro)

target_link_libraries(MicroHydro PRIVATE arcane_full)
target_include_directories(MicroHydro PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_BINARY_DIR})

add_subdirectory(Eos)

if (EXISTS ${CMAKE_CURRENT_SOURCE_DIR}/Project.cmake)
include(Project.cmake)
endif()
