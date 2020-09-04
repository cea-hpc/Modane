<?xml version='1.0' encoding='UTF-8'?>
<cas codeversion="1.0" codename="MicroHydroProject" xml:lang="fr">
	<arcane>
		<titre>Exemple Arcane d'un module Hydro très, très simplifié</titre>
		<boucle-en-temps>MicroHydroLoop</boucle-en-temps>
	</arcane>

	<arcane-post-traitement>
		<frequence-sortie>10</frequence-sortie>
		<depouillement>
			<variable>CellMass</variable>
			<variable>Pressure</variable>
			<variable>Density</variable>
			<variable>Velocity</variable>
			<variable>NodeMass</variable>
			<variable>InternalEnergy</variable>
			<!-- <variable>CellVolume</variable> -->
		</depouillement>
	</arcane-post-traitement>

	<maillage>
		<meshgenerator><sod><x>100</x><y>10</y><z>10</z></sod></meshgenerator>
		<initialisation>
			<variable nom="Density" valeur="1." groupe="ZG" />
			<variable nom="Pressure" valeur="1." groupe="ZG" />
			<variable nom="AdiabaticCst" valeur="1.4" groupe="ZG" />
			<variable nom="Density" valeur="0.125" groupe="ZD" />
			<variable nom="Pressure" valeur="0.1" groupe="ZD" />
			<variable nom="AdiabaticCst" valeur="1.4" groupe="ZD" />
		</initialisation>
	</maillage>

	<module-main></module-main>

	<!-- Configuration du module hydrodynamique -->
	<micro-hydro>
		<deltat-init>0.001</deltat-init>
		<deltat-min>0.00001</deltat-min>
		<deltat-max>0.0001</deltat-max>
		<temps-final>0.05</temps-final>

		<boundary-condition>
			<surface>XMIN</surface>
			<type>vx</type>
			<value>0.</value>
		</boundary-condition>
		<boundary-condition>
			<surface>XMAX</surface>
			<type>vx</type>
			<value>0.</value>
		</boundary-condition>
		<boundary-condition>
			<surface>YMIN</surface>
			<type>vy</type>
			<value>0.</value>
		</boundary-condition>
		<boundary-condition>
			<surface>YMAX</surface>
			<type>vy</type>
			<value>0.</value>
		</boundary-condition>
		<boundary-condition>
			<surface>ZMIN</surface>
			<type>vz</type>
			<value>0.</value>
		</boundary-condition>
		<boundary-condition>
			<surface>ZMAX</surface>
			<type>vz</type>
			<value>0.</value>
		</boundary-condition>
		
		<eos-model name="PerfectGas"/>

                <!-- <eos-model name="StiffenedGas">
                       <limit-tension>0.01</limit-tension>
                </eos-model> -->
	</micro-hydro>
</cas>
