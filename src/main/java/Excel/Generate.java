//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #237767
//Name: #Wan Zulkarnain Bin Wan Hasbullah
package Excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Generate {

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    String sheetName;

    String header[][];
    String keyword[][];
    String data[][];
    String[][] information;

    public Generate(String sheetName) {
        this.workbook = new XSSFWorkbook();
        this.sheet = workbook.createSheet(sheetName);
        this.sheetName = sheetName;

    }

    public Generate setHeader(String semester, String course, String group, String task) {

        String temporaryHeader[][] = {
            {"Semester", semester},
            {"Course", course},
            {"Group", group},
            {"Task", task}
        };

        header = temporaryHeader;

        return this;
    }

    public Generate setKeyword(String[] javaKeywords) {
        /**
         * Per requirement, add Matric, LOC, Blank, Comment, Actual LOC +
         * javakeyword
         */
        String keywordToDisplay[] = new String[javaKeywords.length + 6];
        keywordToDisplay[0] = "Matrik";
        keywordToDisplay[1] = "LOC";
        keywordToDisplay[2] = "Blank";
        keywordToDisplay[3] = "Comment";
        keywordToDisplay[4] = "Actual LOC";

        for (int i = 5; i < (keywordToDisplay.length - 1); i++) {
            keywordToDisplay[i] = javaKeywords[(i - 5)];
        }
        keywordToDisplay[5 + javaKeywords.length] = "Total";

        String keyword[][] = {{}, {
            "", "", "", "", "", "java keyword"
        },
        keywordToDisplay,};

        this.keyword = keyword;
        return this;
    }

    public Generate setData(int totalKeywords[][], String javaKeywords[], String[] distinctMatrik, int totalLOC[][], int totalMatrik[]) {
        String data[][] = new String[totalKeywords.length][javaKeywords.length + 6];

        for (int i = 0; i < data.length; i++) {
            data[i][0] = distinctMatrik[i];
            data[i][1] = (totalLOC[i][0] + totalLOC[i][1] + totalLOC[i][2]) + "";
            data[i][2] = totalLOC[i][0] + "";
            data[i][3] = totalLOC[i][1] + "";
            data[i][4] = totalLOC[i][2] + "";
            int b = 0;
            for (b = 5; b < (data[i].length - 1); b++) {
                data[i][b] = totalKeywords[i][(b - 5)] + "";
            }
            data[i][b] = totalMatrik[i] + "";
        }
        this.data = data;
        return this;
    }

    /**
     *
     * @param header
     * @param keyword
     * @param data
     */
    public Generate processDataObject() {

        information = new String[header.length + keyword.length + data.length][];
        int i = 0;
        for (; i < header.length; i++) {
            information[i] = new String[header[i].length];
            for (int b = 0; b < header[i].length; b++) {
                information[i][b] = header[i][b];
            }
        }

        for (int b = 0; b < keyword.length; b++) {
            information[i] = keyword[b];
            i++;
        }

        for (int b = 0; b < data.length; b++) {
            information[i] = data[b];
            i++;
        }

        this.information = information;
        return this;
    }

    public Generate createExcel() {
        int rowNum = 0;

        for (Object[] datatype : information) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
        return this;
    }

    public Generate write() {
        try {
            FileOutputStream outputStream = new FileOutputStream(sheetName);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

}
