/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mateus
 */
public class DAOFactoryTest {
    
    public DAOFactoryTest() {
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
     * Test of getPacienteDAO method, of class DAOFactory.
     */
    @Test
    public void testGetPacienteDAO() {
        System.out.println("getPacienteDAO");
        PacienteDAO expResult = null;
        PacienteDAO result = DAOFactory.getPacienteDAO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConvenioDAO method, of class DAOFactory.
     */
    @Test
    public void testGetConvenioDAO() {
        System.out.println("getConvenioDAO");
        ConvenioDAO expResult = null;
        ConvenioDAO result = DAOFactory.getConvenioDAO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
