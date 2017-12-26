//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #237767
//Name: #Wan Zulkarnain Bin Wan Hasbullah

package FileHandler;

import FileHandler.Identify.Comments;
import FileHandler.Identify.JavaKeywords;
import FileHandler.Identify.LOC;

public class Identify_Adapter {
    
    Comments comments;
    JavaKeywords javaKeywords;
    LOC loc;

    public Identify_Adapter(String fileContent[][]) {
        this.loc = new LOC();
        this.comments = new Comments();
        this.javaKeywords = new JavaKeywords();
        
        findAll(fileContent);
    }
    
    public void findAll(String fileContent[][]){
        comments.findComments(fileContent);
        javaKeywords.findKeywords(fileContent);
        loc.findLOC(fileContent);
    }
    
    public String getSemester(){
        return comments.semester;
    }
    
    public String getCourse(){
        return comments.course;
    }
    
    public String getGroup(){
        return comments.group;
    }
    
    public String getTask(){
        return comments.task;
    }
    
    public String[] getName(){
        String name[] = new String[comments.name.size()];
        for (int i=0; i<comments.name.size();i++){
            name[i] = comments.name.get(i);
        }
        return name;
    }
    
    public String[] getMatrik(){
        String matrik[] = new String[comments.matrik.size()];
        for (int i=0; i<comments.name.size(); i++){
            matrik[i] = comments.matrik.get(i);
        }
        return matrik;
    }
    
    public int[][] getKeywordsCount(){
        return javaKeywords.countOfKeywords;
    }
    
    public String[] getJavaKeywords(){
        return javaKeywords.KEYWORDS;
    }
    
    public int[][] getLineOfCode(){
        return loc.loc;
    }

}
