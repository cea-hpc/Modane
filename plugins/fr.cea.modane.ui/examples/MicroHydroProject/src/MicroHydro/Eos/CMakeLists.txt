#
# Generated file - Do not overwrite
#
add_library(Eos
  PerfectGasService.cc
  StiffenedGasService.cc
)

target_include_directories(Eos PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_CURRENT_BINARY_DIR})
arcane_add_arcane_libraries_to_target(Eos)

arcane_target_add_axl(Eos PerfectGas)
arcane_target_add_axl(Eos StiffenedGas)


if (EXISTS ${CMAKE_CURRENT_SOURCE_DIR}/Project.cmake)
include(Project.cmake)
endif()
