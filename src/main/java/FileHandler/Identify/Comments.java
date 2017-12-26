//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #237767
//Name: #Wan Zulkarnain Bin Wan Hasbullah
package FileHandler.Identify;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comments {

    public final String COMMENTKEYWORD[] = {"Matrik", "Name"};
    public final String STATICCOMMENTKEYWORD[] = {"Semester", "Course", "Group", "Task"};

    public String semester;
    public String course;
    public String group;
    public String task;

    public LinkedList<String> matrik;
    public LinkedList<String> name;

    public Comments() {
        this.name = new LinkedList();
        this.matrik = new LinkedList();
    }

    public void findComments(String fileContent[][]) {

        /**
         * Fixed Comment Title: Semester, Course, Group, Task Variable Comment
         * Title: Matrik, Name
         */
        setFixedCommentTitle(fileContent);
        setVariableCommentTitle(fileContent);

    }

    public void setFixedCommentTitle(String fileContent[][]) {
        for (int i = 0; i < fileContent.length; i++) {
            for (int b = 0; b < fileContent[i].length; b++) {
                if (checkFixedCommentKeyword(fileContent[i][b], STATICCOMMENTKEYWORD[0])) {
                    semester = grepThisWord(fileContent[i][b], STATICCOMMENTKEYWORD[0]);
                } else if (checkFixedCommentKeyword(fileContent[i][b], STATICCOMMENTKEYWORD[1])) {
                    course = grepThisWord(fileContent[i][b], STATICCOMMENTKEYWORD[1]);

                } else if (checkFixedCommentKeyword(fileContent[i][b], STATICCOMMENTKEYWORD[2])) {
                    group = grepThisWord(fileContent[i][b], STATICCOMMENTKEYWORD[2]);
                } else if (checkFixedCommentKeyword(fileContent[i][b], STATICCOMMENTKEYWORD[3])) {
                    task = grepThisWord(fileContent[i][b], STATICCOMMENTKEYWORD[3]);
                }
            }
        }
    }

    public boolean checkFixedCommentKeyword(String sentence, String search) {
        search = "//" + search + ":";
        if (sentence.toLowerCase().indexOf(search.toLowerCase()) != -1) {
            return true;
        }
        return false;
    }

    public String grepThisWord(String sentence, String search) {
        Pattern pattern = Pattern.compile(search);
        Matcher matcher = pattern.matcher(sentence);
        String thisWord = "";

        while (matcher.find()) {     // find the next match
            String stringGroup = matcher.group();
            int startIndex = matcher.start();
            int endIndex = matcher.end();
            int i = endIndex;

            boolean shouldStop = false;
            while (true) {
                try {
                    if (sentence.substring(i + 1, i + 2).equals(" ") && shouldStop && !search.equals(COMMENTKEYWORD[1])) {
                        break;
                    } else if ((sentence.substring(i + 1, i + 2).equals(" ") || sentence.substring(i + 1, i + 2).equals("#")) && !search.equals(COMMENTKEYWORD[1])) {
                        i++;
                        continue;
                    } else if (sentence.substring(i + 1, i + 2).equals("#")) {
                        i++;
                        continue;
                    } else {
                        shouldStop = true;
                        thisWord += sentence.substring(i + 1, i + 2);
                    }
                    i++;
                } catch (Exception e) {
                    break;
                }
            }
        }
        return thisWord;
    }

    public void setVariableCommentTitle(String fileContent[][]) {
        for (int i = 0; i < fileContent.length; i++) {
            for (int b = 0; b < fileContent[i].length; b++) {
                if (checkFixedCommentKeyword(fileContent[i][b], COMMENTKEYWORD[0])) {
                    matrik.add(grepThisWord(fileContent[i][b], COMMENTKEYWORD[0]));
                } else if (checkFixedCommentKeyword(fileContent[i][b], COMMENTKEYWORD[1])) {
                    name.add(grepThisWord(fileContent[i][b], COMMENTKEYWORD[1]));
                }
            }
        }
    }

}
