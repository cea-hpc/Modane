add_executable(MicroHydroProject main)
target_link_libraries(MicroHydroProject PUBLIC MicroHydro Eos arcane_full)
configure_file(MicroHydroProject.config ${CMAKE_BINARY_DIR})