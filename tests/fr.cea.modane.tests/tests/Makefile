CASES = AbstractVar Enum Inheritance IWithoutS MicroHydro Parameter ParameterDefaultValue PtyOnInterface Service Struct Support UnitTest Var

fullclean::
	@for i in ${CASES}; do cd $$i/src/$$i; make fullclean; cd ../../..; done;
	cd PartialGen/src/level1; make fullclean; cd ../../..;
	cd Unpackaged/src; make fullclean; cd ../..;
