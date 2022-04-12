<?xml version='1.0' encoding='UTF-8'?>
<cas codeversion="1.0" codename="Calculator" xml:lang="fr">
	<arcane>
		<titre>Exemple Arcane d'un module Calculator simple</titre>
		<boucle-en-temps>CalculatorLoop</boucle-en-temps>
	</arcane>

	<maillage>
        <fichier internal-partition='true'>sod.vtk</fichier>
		<initialisation/>
	</maillage>

	<module-main></module-main>

	<!-- Configuration du module calculator -->
	<calculator>
		<operands><x>4</x><y>2</y></operands>
		<operands><x>8</x><y>3</y></operands>
		<operation name="Add"/>
		<method>
			<params>
				<name>Param1</name>
				<valeur>2</valeur>
			</params>	
			<params>
				<name>Param2</name>
				<valeur>5</valeur>
			</params>	
			<name>MyMethod</name>
			<another-param>
				<name>Param3</name>
				<valeur>22</valeur>
			</another-param>	
		</method>	
	</calculator>
</cas>
