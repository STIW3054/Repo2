//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #237767
//Name: #Wan Zulkarnain Bin Wan Hasbullah
package FileHandler.Identify;

import java.util.Arrays;

public class JavaKeywords {

    public final String KEYWORDS[] = {"abstract", "assert", "boolean ",
        "break", "byte ", "case", "catch", "char ", "class", "const",
        "continue", "default", "do", "double ", "else", "extends", "false",
        "final", "finally", "float ", "for", "goto", "if", "implements",
        "import", "instanceof", "int ", "interface", "long ", "native",
        "new", "null", "package", "private", "protected", "public",
        "return", "short", "static", "strictfp", "super", "switch",
        "synchronized", "this", "throw", "throws", "transient", "true",
        "try", "void", "volatile", "while", "enum"};

    public int countOfKeywords[][];

    /*
    public boolean isJavaKeyword(String keyword) {
        return (Arrays.binarySearch(KEYWORDS, keyword) >= 0);
    }
     */
    public void findKeywords(String fileContent[][]) {
        countOfKeywords = new int[fileContent.length][KEYWORDS.length];
        calculateForKeyword(fileContent);
    }

    public void calculateForKeyword(String fileContent[][]) {
        for (int i = 0; i < fileContent.length; i++) {
            for (int b = 0; b < fileContent[i].length; b++) {

                for (int c = 0; c < KEYWORDS.length; c++) {
                    if (javaKeywordExists(fileContent[i][b], KEYWORDS[c])) {
                        countOfKeywords[i][c]++;
                    }
                }

            }
        }
    }

    public boolean javaKeywordExists(String sentence, String search) {
        if (sentence.toLowerCase().indexOf(search.toLowerCase()) != -1) {
            return true;
        }
        return false;
    }

}
