<?xml version='1.0' encoding='UTF-8'?>
<case codeversion="1.0" codename="Hydro" xml:lang="en">
	<arcane>
		<title>Test unitaire des propiétés sur les interfaces</title>
		<timeloop>HydroLoop</timeloop>
	</arcane>

	<mesh>
		<meshgenerator><sod><x>100</x><y>10</y><z>10</z></sod></meshgenerator>
		<initialisation/>
	</mesh>

	<module-main></module-main>

	<hydro>
		<eos name="StiffenedGas">
			<temperature-coef>18</temperature-coef>
			<my-real>12.35</my-real>
			<my-struct>
				<r>35.26</r>
			</my-struct>
			<my-interf>
				<r>48.15</r>
				<s>
					<r>18.35</r>
				</s>
			</my-interf>
			<my-structs>
				<r>35.0</r>
			</my-structs>
			<my-structs>
				<r>36.0</r>
			</my-structs>
			<my-structs>
				<r>37.0</r>
			</my-structs>
			<my-structs>
				<r>38.0</r>
			</my-structs>
			<my-integers>1</my-integers>
			<my-integers>2</my-integers>
			<my-integers>3</my-integers>
		</eos>
	</hydro>
</case>
