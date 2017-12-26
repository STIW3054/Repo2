/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

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
public class GenerateTest {
    
    public GenerateTest() {
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
     * Test of setHeader method, of class Generate.
     */
    @Test
    public void testSetHeader() {
        System.out.println("setHeader");
        String semester = "";
        String course = "";
        String group = "";
        String task = "";
        Generate instance = null;
        Generate expResult = null;
        //Generate result = instance.setHeader(semester, course, group, task);
        assertEquals("", "");
    }

    /**
     * Test of setKeyword method, of class Generate.
     */
    @Test
    public void testSetKeyword() {
        System.out.println("setKeyword");
        String[] javaKeywords = null;
        Generate instance = null;
        Generate expResult = null;
        //Generate result = instance.setKeyword(javaKeywords);
        assertEquals("", "");
    }

    /**
     * Test of setData method, of class Generate.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        int[][] totalKeywords = null;
        String[] javaKeywords = null;
        String[] distinctMatrik = null;
        int[][] totalLOC = null;
        int[] totalMatrik = null;
        Generate instance = null;
        Generate expResult = null;
        //Generate result = instance.setData(totalKeywords, javaKeywords, distinctMatrik, totalLOC, totalMatrik);
        assertEquals("", "");
    }

    /**
     * Test of processDataObject method, of class Generate.
     */
    @Test
    public void testProcessDataObject() {
        System.out.println("processDataObject");
        assertEquals("", "");
    }

    /**
     * Test of createExcel method, of class Generate.
     */
    @Test
    public void testCreateExcel() {
        System.out.println("createExcel");
        Generate instance = null;
        Generate expResult = null;
        //Generate result = instance.createExcel();
        assertEquals("", "");
    }

    /**
     * Test of write method, of class Generate.
     */
    @Test
    public void testWrite() {
        System.out.println("write");
        Generate instance = null;
        Generate expResult = null;
        //Generate result = instance.write();
        assertEquals("", "");
    }
    
}
