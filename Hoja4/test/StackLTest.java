/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luisa Portillo
 */
public class StackLTest {
    
    public StackLTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of push method, of class StackL.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Object valor = 1;
        StackL instance = new StackL();
        instance.push(valor);
        Object expResult = 1;
        Object result = instance.peek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of pop method, of class StackL.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        StackL instance = new StackL();
        Object expResult = null;
        Object result = instance.pop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of peek method, of class StackL.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        StackL instance = new StackL();
        Object expResult = null;
        Object result = instance.peek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of isEmpty method, of class StackL.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        StackL instance = new StackL();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
}
