# Create a new version

We assume that you have already merged into `master` the developments you intend to include in your new release.

NB : To get the last tag, check previous ones [here](https://github.com/cea-hpc/Modane/releases). Don't omit 'v' prefix !

1. Go to Modane root directory

2. Edit `change_version.sh` script to change the version number. Replace old version number by new one

3. Execute the script. Check everything is OK in Eclipse (Build)

4. As indicated in the `change_version.sh` output log, change splashscreen: edit `plugins\fr.cea.modane.rcp\splash.svg` with inkscape and replace old version number by new one

5. Open `plugins\fr.cea.modane.rcp\splash.svg` with gimp, check image dimensions (cf `change_version.sh` output log) and export it as bmp (replace `splash.bmp`)

6. Push modifications

7. Build product (on /tmp not to dirty your dev env)
    ```bash
    cd /tmp
    git clone https://github.com/cea-hpc/Modane.git
    cd /tmp/Modane
    mvn clean; mvn verify
    ```
8. Create Release on [GitHub](https://github.com/cea-hpc/Modane/releases). Click Draft a new release, fill version and attach binaries produced by maven (3 binaries for Modane, 3 binaries for ModaneHeadless and 1 update-site)
    
