//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #237767
//Name: #Wan Zulkarnain Bin Wan Hasbullah
package Excel;

import java.util.Arrays;

public class SumData {

    String name[];
    String matrik[];
    String course;
    String group;
    String semester;
    String task;

    String javaKeywords[];
    int keywordsCount[][];
    int lineOfCode[][];

    int totalkeywordsCount[][];
    int totalLOC[][];

    public SumData(String[] name, String[] matrik, String course, String group, String semester, String task, String[] javaKeywords, int[][] keywordsCount, int[][] lineOfCode) {
        this.name = name;
        this.matrik = matrik;
        this.course = course;
        this.group = group;
        this.semester = semester;
        this.task = task;

        this.javaKeywords = javaKeywords;
        this.keywordsCount = keywordsCount;
        this.lineOfCode = lineOfCode;

        sortToProperPresentation();
    }

    public void sortToProperPresentation() {
        String[] distinctMatrik = getDistinctMatrik();
        totalkeywordsCount = new int[distinctMatrik.length][javaKeywords.length];
        totalLOC = new int[distinctMatrik.length][3];
        
        boolean errorFlag = false;

        for (int i = 0; i < distinctMatrik.length; i++) {
            for (int b = 0; b < keywordsCount.length; b++) {
                try {
                    for (int c = 0; c < keywordsCount[b].length; c++) {

                        if (distinctMatrik[i].equals(matrik[b])) {
                            totalkeywordsCount[i][c] += keywordsCount[b][c];
                        }

                    }
                    if (distinctMatrik[i].equals(matrik[b])) {
                        totalLOC[i][0] += lineOfCode[b][0];
                        totalLOC[i][1] += lineOfCode[b][1];
                        totalLOC[i][2] += lineOfCode[b][2];

                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    errorFlag = true;
                } catch (NullPointerException e){
                    errorFlag = true;
                }
            }
        }

        if (errorFlag){
            System.out.println("There is an error because there is a file without matrik number. Expect non-proper output is generated");
        }
    }

    public int[][] getTotalLOC() {
        return totalLOC;
    }

    public int[][] getTotalKeywordsCount() {
        return totalkeywordsCount;
    }

    public int[] getTotalForEachMatrik() {
        int totalForEachMatrik[] = new int[getDistinctMatrik().length];
        for (int i = 0; i < totalkeywordsCount.length; i++) {
            for (int b = 0; b < totalkeywordsCount[i].length; b++) {
                totalForEachMatrik[i] += totalkeywordsCount[i][b];
            }
            //totalForEachMatrik[i] += totalLOC[i][0] + totalLOC[i][1] + totalLOC[i][2];
            totalForEachMatrik[i] += totalLOC[i][2];
        }
        return totalForEachMatrik;
    }

    public String[] getDistinctMatrik() {
        return Arrays.stream(matrik).distinct().toArray(String[]::new);
    }

}
