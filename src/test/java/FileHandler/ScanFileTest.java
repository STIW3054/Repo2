/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileHandler;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wanzu
 */
public class ScanFileTest {

    public ScanFileTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getFileContent method, of class ScanFile.
     */
    @Test
    public void testGetFileContent() {
        System.out.println("getFileContent");
        String[] arrayListFile = null;
        ScanFile instance = new ScanFile();
        String[][] expResult = null;
        //String[][] result = instance.getFileContent(arrayListFile);
        assertEquals("", "");
    }

    /**
     * Test of readFileContent method, of class ScanFile.
     */
    @Test
    public void testReadFileContent() {
        System.out.println("readFileContent");
        String fileName = "";
        int fileNumber = 0;
        ScanFile instance = new ScanFile();
        //instance.readFileContent(fileName, fileNumber);
    }

    /**
     * Test of getNumberOfFiles method, of class ScanFile.
     */
    @Test
    public void testGetNumberOfFiles() {
        System.out.println("getNumberOfFiles");
        ScanFile instance = new ScanFile();
        int expResult = 0;
        //int result = instance.getNumberOfFiles();
        assertEquals("", "");
    }

}
