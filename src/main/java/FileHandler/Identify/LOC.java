//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #237767
//Name: #Wan Zulkarnain Bin Wan Hasbullah
package FileHandler.Identify;

public class LOC {

    public int loc[][];

    /**
     * Dimensi pertama untuk refer to file Dimensi kedua untuk refer kepada (1)
     * Empty line, (2) Comment Line, (3) Actual Line of Code
     *
     * @param fileContent
     */
    public void findLOC(String fileContent[][]) {
        loc = new int[fileContent.length][3];
        calculateForEmptyLine(fileContent);
    }

    public void calculateForEmptyLine(String fileContent[][]) {
        for (int i = 0; i < fileContent.length; i++) {
            for (int b = 0; b < fileContent[i].length; b++) {
                
                /**
                 * Empty line
                 */
                if (fileContent[i][b] == null || fileContent[i][b].isEmpty() || fileContent[i][b].trim().length() == 0) {
                    loc[i][0]++;
                    /**
                     * Comment
                     * Andaian tiada comment yang berada dibelakang code
                     */
                } else if (fileContent[i][b].contains("//")) {
                    loc[i][1]++;
                    /**
                     * Actual LOC
                     */
                } else {
                    loc[i][2]++;
                }
            }
        }
    }

}
