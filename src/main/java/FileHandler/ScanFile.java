//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #237767
//Name: #Wan Zulkarnain Bin Wan Hasbullah
package FileHandler;

import FolderHandler.Path;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class ScanFile {

    String fileContent[][];
    LinkedList<String> listFileContent;

    public String[][] getFileContent(String arrayListFile[]) {

        fileContent = new String[arrayListFile.length][];
        listFileContent = new LinkedList();

        for (int i = 0; i < arrayListFile.length; i++) {
            readFileContent(arrayListFile[i], i);
        }
        return fileContent;
    }

    public void readFileContent(String fileName, int fileNumber) {
        listFileContent.clear();
        File file = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                listFileContent.add(line);
            }

            fileContent[fileNumber] = new String[listFileContent.size()];
            for (int b = 0; b < listFileContent.size(); b++) {
                fileContent[fileNumber][b] = listFileContent.get(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNumberOfFiles() {
        return fileContent.length;
    }

}
