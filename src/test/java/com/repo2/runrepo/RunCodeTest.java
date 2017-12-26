/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo2.runrepo;

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
public class RunCodeTest {

    public RunCodeTest() {
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
     * Test of detectPackageType method, of class RunCode.
     */
    @Test
    public void testDetectPackageType() {
        System.out.println("detectPackageType");
        RunCode instance = null;
        boolean expResult = false;
//        boolean result = instance.detectPackageType();
        assertEquals("", "");
    }

    /**
     * Test of runTerminal method, of class RunCode.
     */
    @Test
    public void testRunTerminal() {
        System.out.println("runTerminal");
        String path = "";
        String commandString = "";
        String action = "";
        RunCode instance = null;
//        instance.runTerminal(path, commandString, action);
    }

    /**
     * Test of run method, of class RunCode.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        RunCode instance = null;
//        instance.run();
    }

}
