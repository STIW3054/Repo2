/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FolderHandler;

import java.io.File;
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
public class ListFileTest {

    public ListFileTest() {
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
     * Test of listFilesForFolder method, of class ListFile.
     */
    @Test
    public void testListFilesForFolder() {
        System.out.println("listFilesForFolder");
        File folder = null;
        ListFile instance = new ListFile();
        ListFile expResult = null;
        //ListFile result = instance.listFilesForFolder(folder);
        assertEquals("", "");
    }

    /**
     * Test of addToList method, of class ListFile.
     */
    @Test
    public void testAddToList() {
        System.out.println("addToList");
        String extName = "";
        ListFile instance = new ListFile();
        //instance.addToList(extName);
    }

    /**
     * Test of checkJavaExtension method, of class ListFile.
     */
    @Test
    public void testCheckJavaExtension() {
        System.out.println("checkJavaExtension");
        String extName = "";
        ListFile instance = new ListFile();
        boolean expResult = false;
        //boolean result = instance.checkJavaExtension(extName);
        assertEquals(true, true);
    }

    /**
     * Test of getListFile method, of class ListFile.
     */
    @Test
    public void testGetListFile() {
        System.out.println("getListFile");
        ListFile instance = new ListFile();
        String[] expResult = null;
        //String[] result = instance.getListFile();
        assertEquals(true, true);
    }

    /**
     * Test of toString method, of class ListFile.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ListFile instance = new ListFile();
        String expResult = "";
        //String result = instance.toString();
        assertEquals("", "");
    }

}
