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
public class GithubAccountTest {
    
    public GithubAccountTest() {
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
     * Test of setPath method, of class GithubAccount.
     */
    @Test
    public void testSetPath() {
        System.out.println("setPath");
        String listPath = "";
        GithubAccount instance = new GithubAccount();
        //instance.setPath(listPath);
    }

    /**
     * Test of getNameAccountList method, of class GithubAccount.
     */
    @Test
    public void testGetNameAccountList() {
        System.out.println("getNameAccountList");
        GithubAccount instance = new GithubAccount();
        String[] expResult = null;
        //String[] result = instance.getNameAccountList();
        assertEquals("", "");
    }

    /**
     * Test of getURLAccountList method, of class GithubAccount.
     */
    @Test
    public void testGetURLAccountList() {
        System.out.println("getURLAccountList");
        GithubAccount instance = new GithubAccount();
        String[] expResult = null;
        //String[] result = instance.getURLAccountList();
        assertEquals("", "");
    }
    
}
