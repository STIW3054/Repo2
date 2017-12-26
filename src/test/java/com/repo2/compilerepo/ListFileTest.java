/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo2.compilerepo;

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
     * Test of getList method, of class ListFile.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        File folder = null;
        ListFile instance = null;
        ListFile expResult = null;
//        ListFile result = instance.getList(folder);
        assertEquals("", "");
    }

    /**
     * Test of getFileExtension method, of class ListFile.
     */
    @Test
    public void testGetFileExtension() {
        System.out.println("getFileExtension");
        String fullName = "";
        ListFile instance = null;
        String expResult = "";
        //String result = instance.getFileExtension(fullName);
        assertEquals("", "");
    }

    /**
     * Test of filterOutNonJavaFiles method, of class ListFile.
     */
    @Test
    public void testFilterOutNonJavaFiles() {
        System.out.println("filterOutNonJavaFiles");
        String absolutePath = "";
        ListFile instance = null;
        //instance.filterOutNonJavaFiles(absolutePath);
    }

    /**
     * Test of toArray method, of class ListFile.
     */
    @Test
    public void testToArray() {
        System.out.println("toArray");
        ListFile instance = null;
        String[] expResult = null;
        //String[] result = instance.toArray();
        assertEquals("", "");
    }

    /**
     * Test of call method, of class ListFile.
     */
    @Test
    public void testCall() throws Exception {
        System.out.println("call");
        ListFile instance = null;
        String[] expResult = null;
        //String[] result = instance.call();
        assertEquals("", "");
    }

}
