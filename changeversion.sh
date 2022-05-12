#
#!/bin/bash
#

OLD_VERSION=1.4.4
NEW_VERSION=1.4.5

echo "Looking for MANIFEST.MF files"
FIND_RES=`find . -path ./.metadata -prune -o -name "MANIFEST.MF" -print`
for f in $FIND_RES
do
   if grep -q "Bundle-Vendor: CEA" $f; then
      if grep -q "Bundle-Version: $OLD_VERSION.qualifier" $f; then
         echo "   Changing version of:" $f
         cp $f $f.old
         sed "s/Bundle-Version: $OLD_VERSION.qualifier/Bundle-Version: $NEW_VERSION.qualifier/g" $f.old > $f
      fi
   fi
done

echo "Looking for pom.xml files"
FIND_RES=`find . -path ./.metadata -prune -o -name "pom.xml" -print`
for f in $FIND_RES
do
   if grep -q -e "<groupId>fr.cea.modane</groupId>" -e "<groupId>fr.cea.modane.project</groupId>" $f; then
      if grep -q "<version>$OLD_VERSION-SNAPSHOT</version>" $f; then
         echo "   Changing version of:" $f
         cp $f $f.old
         sed "s%<version>$OLD_VERSION-SNAPSHOT</version>%<version>$NEW_VERSION-SNAPSHOT</version>%g" $f.old > $f
      fi
   fi
done

echo "Looking for feature.xml files"
FIND_RES=`find . -path ./.metadata -prune -o -name "feature.xml" -print`
for f in $FIND_RES
do
   if grep -q "provider-name=\"CEA\"" $f; then
      if grep -q "version=\"$OLD_VERSION.qualifier\"" $f; then
         echo "   Changing version of:" $f
         cp $f $f.old
         sed "s/version=\"$OLD_VERSION.qualifier\"/version=\"$NEW_VERSION.qualifier\"/g" $f.old > $f
      fi
   fi
done

f=./plugins/fr.cea.modane.rcp/plugin.xml
if grep -q "Version $OLD_VERSION" $f; then
   echo "   Changing version of:" $f
   cp $f $f.old
   sed "s/Version $OLD_VERSION/Version $NEW_VERSION/g" $f.old > $f
fi

FIND_RES=`find ./releng/fr.cea.modane.updatesite -path ./.metadata -prune -o -name "*.product" -print`
for f in $FIND_RES
do
   if grep -q "$OLD_VERSION.qualifier" $f; then
      echo "   Changing version of:" $f
      cp $f $f.old
      sed "s/$OLD_VERSION.qualifier/$NEW_VERSION.qualifier/g" $f.old > $f
   fi
done

f=./README.md
if grep -q "https://github.com/cea-hpc/Modane/releases/tag/v$OLD_VERSION" $f; then
   echo "   Changing version of:" $f
   cp $f $f.old
   sed "s%https://github.com/cea-hpc/Modane/releases/tag/v$OLD_VERSION%https://github.com/cea-hpc/Modane/releases/tag/v$NEW_VERSION%g" $f.old > $f
fi

echo "DONE. All that remains is to change the SPLASH SCREEN (BMP 459x347)."

