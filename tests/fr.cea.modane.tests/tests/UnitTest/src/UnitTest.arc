<?xml version='1.0' encoding='UTF-8'?>
<cas codeversion="1.0" codename="UnitTest" xml:lang="fr">
	<arcane>
		<titre>Jeu de tests unitaires pour UnitTest</titre>
		<boucle-en-temps>UnitTest</boucle-en-temps>
	</arcane>

	<maillage>
		<meshgenerator><sod><x>100</x><y>10</y><z>10</z></sod></meshgenerator>
	</maillage>

	<module-main></module-main>
	
	<module-test-unitaire>
	  <xml-test name="UnitTest">
	     <!-- ici les données de mon service de test (si bien sur il en a !)... -->
	  </xml-test>
	</module-test-unitaire>	
	
</cas>
