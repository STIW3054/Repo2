/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo2.logging;

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
public class LoggingTest {

    public LoggingTest() {
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
     * Test of setText method, of class Logging.
     */
    @Test
    public void testSetText() {
        System.out.println("setText");
        String text = "";
        Logging instance = null;
        Logging expResult = null;
        //Logging result = instance.setText(text);
        assertEquals("", "");
    }

    /**
     * Test of run method, of class Logging.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Logging instance = null;
//        instance.run();
    }

}
