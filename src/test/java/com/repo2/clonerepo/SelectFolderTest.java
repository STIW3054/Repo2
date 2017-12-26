/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo2.clonerepo;

import java.awt.event.ActionEvent;
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
public class SelectFolderTest {
    
    public SelectFolderTest() {
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
     * Test of displayDialog method, of class SelectFolder.
     */
    @Test
    public void testDisplayDialog() {
        System.out.println("displayDialog");
        SelectFolder instance = new SelectFolder();
        SelectFolder expResult = null;
        //SelectFolder result = instance.displayDialog();
        assertEquals("", "");
    }

    /**
     * Test of getPath method, of class SelectFolder.
     */
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        SelectFolder instance = new SelectFolder();
        String expResult = "";
        //String result = instance.getPath();
        assertEquals("", "");
    }

    /**
     * Test of actionPerformed method, of class SelectFolder.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        SelectFolder instance = new SelectFolder();
        //instance.actionPerformed(e);
    }
    
}
