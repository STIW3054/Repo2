/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo2.clonerepo;

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
public class GithubCloneTest {
    
    public GithubCloneTest() {
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
     * Test of cloneNow method, of class GithubClone.
     */
    @Test
    public void testCloneNow() {
        System.out.println("cloneNow");
        String[] urlAccountList = null;
        String clonePath = "";
        String[] nameAccountList = null;
        //GithubClone.cloneNow(urlAccountList, clonePath, nameAccountList);
  
    }

    /**
     * Test of run method, of class GithubClone.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        GithubClone instance = null;
        //instance.run();
    }
    
}
