AbstractVar
- Test des variables abstraites 
- Ajout d'une méthode sur un service sans prototype dans l'interface
- Ajout de variables abstraites sur une méthode d'un service sans prototype dans l'interface

Enum (pas d'exécution)
- Gestion des énumérés. Il comporte aussi une variable, un booléen et un point d'entrée (fourre-tout pour divers tests).
- Cas des énumérés dans un package différent

Inheritance (pas d'exécution)
- Test de l'héritage d'interface et de struct.
- Test de la validation sur la surcharge d'opération
- Opération permettant de vérifier qu'il n'y a pas d'auto-include 

IWithoutS (Meme cas que Support sans le service PerfectGas)
- Interface sans implémentation 
	- Si au moins une propriété concrete : on génére une implémentation unique de Service par défaut
	- Si aucune propriété concrete : on génére une classe d'implémentation 
- Test des méthodes avec support, support matériau et itemTypeSpecialized
- Test dans le cas où le service est dans un autre package que l'interface
- Test de l'héritage des méthodes

MicroHydro 
- Implémentation du cas test Arcane MicroHydro.

Parameter (pas d'exécution)
- Génération des paramètres de fonctions en In/Out/Return selon le type du paramète et sa cardinalité
  Le service Parameter.h a été vérifié. Il n'est volontairement pas effacé par le "make fullclean".
  Si la génération ne donne plus les mêmes types pour les paramètres, ce test ne compilera plus.
  VOIR LE TABLEAU DES TYPES DANS fr.cea.modane.generator.cpp.ArgExtensions.xtend et fr.cea.modane.generator.cpp.PtyExtensions.xtend

ParameterDefaultValue
- Test des valeurs par défaut sur les paramètres des fonctions des interfaces, services et modules
- Test du fonctionnement lors d'un appel depuis le module
- Test d'un service généré avec l'option 'variableAsArgs=false', cad sans structure de variable
  Le répertoire NoVarAsArgs contient un fichier modane.properties pour l'option de génération.

PartialGen (pas de compilation)
- Génération partielle d'un sous package d'une arborescence à 3 niveaux.

PtyOnInterface 
- Création de propriétés sur une interface : Real, Struct et Interface
- Utilisation des accesseurs générés pour récupérer les propriétés au niveau du module
- Création d'une propriété optionnelle et vérification de l'accesseur isPresent.

Service (pas d'exécution)
- Test du legacy - en option de Service et en paramètre de fonction
- Service par défaut.
- Interface en paramètre d'une fonction
- Option de cardinalité 0 qui ne doit pas se retrouver dans les fichiers Modane : elle permet juste le chargement
  du modèle lié (qui représente un service singleton).
- Service implémentant plusieurs interfaces  
- Module implémentant une interface
- Propriété autoLoad de entryPoint

Struct
- Codage de struct contenant des structs et des structs en paramètre de méthode.
  Notons que la génération d'attributs ref de type complex dans l'axl a été supprimée depuis 
  qu'Arcane autorise les interfaces sur les types complex (ref nécessitait d'avoir la même cardinalité).
- Test des struct en option de service
- Test des différents types d'attributs et initilisation dans le constructeur

Support
- Test parallèle/séquentiel pour les fonctions qui présentent un support normal, Particle, DoF, MatCell, EnvCell et ComponentCell.
- Test une fonction spécialisée par type d'item

UnitTest
- Tests pour les tests unitaires. Uniquement applicables à des fichiers Modane (pas dans MagicDraw)

Unpackaged (pas d'exécution)
- Test du fonctionnement si pas de package root.

Var (pas d'exécution)
- Création de la classe Vars pour passage des variables en paramètres
- Test du nom de type généré pour les variables sans support et de dim scalar 
- Test des variables multi-matériaux
- Test des variables particulaires
- Test des variables DoF
- Test des variables booléennes
- Test d'un service généré avec l'option 'variableAsArgs=false', cad sans structure de variable
  Le répertoire NoVarAsArgs contient un fichier modane.properties pour l'option de génération.
