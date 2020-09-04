#
# Generated file - Do not overwrite
#
add_library(Eos __IEquationOfState.h __PerfectGasServiceVars.h __PerfectGasServiceBase.h PerfectGas_axl.h PerfectGasService.h PerfectGasService.cc __StiffenedGasServiceVars.h __StiffenedGasServiceBase.h StiffenedGas_axl.h StiffenedGasService.h StiffenedGasService.cc)
target_include_directories(Eos PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_BINARY_DIR})
target_link_libraries(Eos PUBLIC arcane_core)
arcane_generate_axl(PerfectGas)
arcane_generate_axl(StiffenedGas)
if (EXISTS ${CMAKE_CURRENT_SOURCE_DIR}/Project.cmake)
include(Project.cmake)
endif()
