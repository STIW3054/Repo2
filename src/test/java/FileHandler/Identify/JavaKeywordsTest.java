/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileHandler.Identify;

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
public class JavaKeywordsTest {
    
    public JavaKeywordsTest() {
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
     * Test of findKeywords method, of class JavaKeywords.
     */
    @Test
    public void testFindKeywords() {
        System.out.println("findKeywords");
        String[][] fileContent = null;
        JavaKeywords instance = new JavaKeywords();
       // instance.findKeywords(fileContent);
    }

    /**
     * Test of calculateForKeyword method, of class JavaKeywords.
     */
    @Test
    public void testCalculateForKeyword() {
        System.out.println("calculateForKeyword");
        String[][] fileContent = null;
        JavaKeywords instance = new JavaKeywords();
       // instance.calculateForKeyword(fileContent);
    }

    /**
     * Test of javaKeywordExists method, of class JavaKeywords.
     */
    @Test
    public void testJavaKeywordExists() {
        System.out.println("javaKeywordExists");
        String sentence = "";
        String search = "";
        JavaKeywords instance = new JavaKeywords();
        boolean expResult = false;
        boolean result = instance.javaKeywordExists(sentence, search);
        assertEquals(true, result);
    }
    
}
