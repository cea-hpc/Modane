#
# Generated file - Do not overwrite
#
add_library(MicroHydro __IBoundaryCondition.h __BoundaryConditionType.h __DefaultLoopDelegationServiceVars.h __DefaultLoopDelegationServiceBase.h DefaultLoopDelegation_axl.h DefaultLoopDelegationService.h DefaultLoopDelegationService.cc __ILoopDelegation.h __MicroHydroModuleVars.h __MicroHydroModuleBase.h MicroHydro_axl.h MicroHydroModule.h MicroHydroModule.cc)
target_include_directories(MicroHydro PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_BINARY_DIR})
target_link_libraries(MicroHydro PUBLIC arcane_core)
arcane_generate_axl(DefaultLoopDelegation)
arcane_generate_axl(MicroHydro)
add_subdirectory(Eos)
if (EXISTS ${CMAKE_CURRENT_SOURCE_DIR}/Project.cmake)
include(Project.cmake)
endif()
