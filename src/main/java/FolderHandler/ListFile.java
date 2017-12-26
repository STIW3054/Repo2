//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #237767
//Name: #Wan Zulkarnain Bin Wan Hasbullah

package FolderHandler;

import java.io.File;
import java.util.LinkedList;

public class ListFile {

    private LinkedList<String> listOfFileName;

    /**
     * Constructor
     */
    public ListFile() {
        listOfFileName = new LinkedList();
    }

    /**
     * - Get all files recursively - Check if the file extension is java - Add
     * to LinkedList
     *
     * @param folder
     * @return *Chain*
     */
    public ListFile listFilesForFolder(final File folder) {

        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                this.listFilesForFolder(fileEntry);
            } else {
                addToList(fileEntry.getName());
            }
        }
        return this;
    }

    /**
     * Add the filename to LinkedList
     *
     * @param extName
     */
    public void addToList(String extName) {
        if (checkJavaExtension(extName)) {
            listOfFileName.add(extName);
        }
    }

    /**
     * Verify if the filename has an extension of Java If the has, return true
     * Else return false
     *
     * @param extName
     * @return
     */
    public boolean checkJavaExtension(String extName) {
        if (extName.substring(extName.length() - 4).equalsIgnoreCase("Java")) {
            return true;
        }
        return false;
    }

    /**
     * Convert LinkedList of Filename to String of Array
     *
     * @return
     */
    public String[] getListFile() {
        String arrayOfFileName[] = new String[listOfFileName.size()];

        for (int i = 0; i < listOfFileName.size(); i++) {
            arrayOfFileName[i] = listOfFileName.get(i);
        }
        return arrayOfFileName;
    }

    /**
     * Convert LinkedList of Filename to Single String
     *
     * @return
     */
    public String toString() {
        String stringOfFileName = "";

        for (int i = 0; i < listOfFileName.size(); i++) {
            stringOfFileName += listOfFileName.get(i);
        }
        return stringOfFileName;
    }
}
