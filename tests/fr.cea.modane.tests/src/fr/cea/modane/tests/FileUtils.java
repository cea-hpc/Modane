package fr.cea.modane.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
 
    public static List<File> listAllFiles(String path) 
    {
    	List<File> allFiles = new ArrayList<File>(); 
        File root = new File(path);
        File[] list = root.listFiles();
   
        if (list != null) {  // In case of access error, list is null
            for (File f : list) {
                if (f.isDirectory()) {
                	allFiles.addAll(listAllFiles(f.getAbsolutePath()));
                } else {
                	allFiles.add(f);
                }
            }
        }
        return allFiles;
    }
}