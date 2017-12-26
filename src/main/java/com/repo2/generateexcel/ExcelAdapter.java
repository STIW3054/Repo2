package com.repo2.generateexcel;

import Excel.Generate;
import Excel.SumData;
import FileHandler.Identify_Adapter;
import FileHandler.ScanFile;
import FolderHandler.ListFile;
import FolderHandler.Path;
import java.io.File;

public class ExcelAdapter {

    public static final String FILENAME = "output_result.xlsx";

    public static void generate(String arrayListFile[]) {
        
            ScanFile scanFile = new ScanFile();
            String fileContent[][] = scanFile.getFileContent(arrayListFile);
            int numberOfFiles = scanFile.getNumberOfFiles();

            Identify_Adapter identify = new Identify_Adapter(fileContent);

            String name[] = identify.getName();
            String matrik[] = identify.getMatrik();
            String course = identify.getCourse();
            String group = identify.getGroup();
            String semester = identify.getSemester();
            String task = identify.getTask();

            String[] javaKeywords = identify.getJavaKeywords();
            int[][] keywordsCount = identify.getKeywordsCount();

            int[][] lineOfCode = identify.getLineOfCode();

            SumData sumdata = new SumData(name, matrik, course, group, semester, task, javaKeywords, keywordsCount, lineOfCode);
            int totalKeywords[][] = sumdata.getTotalKeywordsCount();
            String[] distinctMatrik = sumdata.getDistinctMatrik();
            int[] totalMatrik = sumdata.getTotalForEachMatrik();

            int[][] totalLOC = sumdata.getTotalLOC();
            Generate generate = new Generate(FILENAME);
            generate.setHeader(semester, course, group, task).setKeyword(javaKeywords);
            generate.setData(totalKeywords, javaKeywords, distinctMatrik, totalLOC, totalMatrik);
            generate.processDataObject().createExcel().write();
    }
}
