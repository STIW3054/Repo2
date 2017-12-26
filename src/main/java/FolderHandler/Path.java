//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #237767
//Name: #Wan Zulkarnain Bin Wan Hasbullah
package FolderHandler;

import java.io.File;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Path {
    
    /**
     * Relative folder directory is Netbeans Project Folder Must send folderName
     * with starting of /
     *
     * @param folderName
     * @return File
     */
    public static String getPath(String folderName) {
        return System.getProperty("user.dir") + File.separator + folderName;
        //return Paths.get("").toAbsolutePath().toString() + "\\" + folderName;
    }

}
