# How to execute tests

4 test suites are available:
- FullCleanTestsSuite to remove generated files before git commit
- GenerateTestsSuite to generate axl and cpp source files
- CompilationTestsSuite to generate and compile
- ExecutionTestsSuite to execute tests which can be executed (not all tests)

For every tests, the compilation is done in a separate 'build' directory.
To clean compilation results, a script clean.sh is available in the tests directory.