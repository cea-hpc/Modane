<?xml version='1.0' encoding='UTF-8'?>
<case codeversion="1.0" codename="IWithoutS" xml:lang="en">
	<arcane>
		<title>Test</title>
		<timeloop>IWithoutSLoop</timeloop>
	</arcane>

	<mesh>
        <file internal-partition='true'>sod.vtk</file>
	</mesh>

	<module-main></module-main>


	<!-- Configuration du service 'SubDomain' eos -->
	<eos/>
	
	<!-- Configuration du module hdyro -->
	<hydro/>
</case>
