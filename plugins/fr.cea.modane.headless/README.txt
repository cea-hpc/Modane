Lors de la création de l'application (headless product), des dépendances sont non résolues (Missing requirement).

1. osgi.extender
   Il faut inclure org.eclipse.equinox.ds et ses dépendances (donc clic sur 'Add Required Plug-ins').
   
2. antlr 3.2.0
   Le problème vient du fait que nos installations d'Eclipse comportent 2 versions de antlr.
   Une pour Sirius très récente (aujourd'hui 4.3) et l'autre pour Xtext (aujourd'hui 3.2).
   Par défaut, le produit prend la version récente. Pour ce produit n'intégrant pas de Sirius, seule l'ancienne version est utile.
   A priori, il suffit donc d'entrer le numéro de version, cad 3.2, pour le produit org.antlr.runtime (onglet Contents, bouton Properties).
   Mais, ça ne fonctionne pas. La version 3.2 n'est pas trouvée.
   Pour que cela fonctionne il faut importer cette version 3.2 dans le workspace, comme un projet (File > Import > Plug-ins and Fragments).
   
(3. org.apache.batik.util.gui 1.6.0
   Même problème que antlr.)
   A faire ou pas ? Si le headless ne se lance pas avec launch il faut le fermer ?
   
4. Dans la liste des dépendances (headless.product > Contents), il faut forcer les versions de :
   - com.google.guava : 21.0.0
   - org.apache.batik.css et util : 1.9.1
   
  