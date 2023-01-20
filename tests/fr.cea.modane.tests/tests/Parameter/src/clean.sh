# On efface les sources du modules mais pas celles de l'interface pour vérifier que les types des paramètres sont en cohérence
cd Parameter
rm -f __*.h *.axl *_axl.h HydroModule.*
rm -rf output ../*.modane
