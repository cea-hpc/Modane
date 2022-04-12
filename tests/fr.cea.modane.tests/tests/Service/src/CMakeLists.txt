cmake_minimum_required(VERSION 3.13 FATAL_ERROR)
project(ServiceCore LANGUAGES NONE)

include(${CMAKE_CURRENT_LIST_DIR}/../../Common.cmake)

project(Hydro LANGUAGES C CXX)

add_executable(Hydro
  Service/HydroModule.cc
  Service/HydroModule.h
  Service/main.cc
  Service/AfaceDefault.cc
  Service/AnotherConcreteFaceDefaultService.cc
  Service/Compri2Service.cc
  Service/CompriService.cc
  Service/OrnythorinqueService.cc
  Service/SingletonDefaultService.cc
  Service/TrackingDefaultService.cc
  Service/AfaceDefault.h
  Service/AnotherConcreteFaceDefaultService.h
  Service/Compri2Service.h
  Service/CompriService.h
  Service/OrnythorinqueService.h
  Service/SingletonDefaultService.h
  Service/TrackingDefaultService.h
  Service/Hydro_axl.h
  Service/AnotherConcreteFaceDefault_axl.h
  Service/Compri_axl.h
  Service/Compri2_axl.h
  Service/Ornythorinque_axl.h
  Service/SingletonDefault_axl.h
  Service/TrackingDefault_axl.h
)

arcane_generate_axl(Service/Hydro)
arcane_generate_axl(Service/AnotherConcreteFaceDefault)
arcane_generate_axl(Service/Compri2)
arcane_generate_axl(Service/Compri)
arcane_generate_axl(Service/Ornythorinque)
arcane_generate_axl(Service/SingletonDefault)
arcane_generate_axl(Service/TrackingDefault)
target_link_libraries(Hydro PRIVATE arcane_full)
target_include_directories(Hydro PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_BINARY_DIR})

