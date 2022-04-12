#
# Generated file - Do not overwrite
#
add_library(Eos
  PerfectGasService.cc
  StiffenedGasService.cc
  PerfectGas_axl.h
  StiffenedGas_axl.h
)

arcane_generate_axl(PerfectGas)
arcane_generate_axl(StiffenedGas)

target_link_libraries(Eos PRIVATE arcane_full)
target_include_directories(Eos PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_BINARY_DIR})

if (EXISTS ${CMAKE_CURRENT_SOURCE_DIR}/Project.cmake)
include(Project.cmake)
endif()
