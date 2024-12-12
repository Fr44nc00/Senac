/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package servicos;

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
public class ServicosFactoryTest {
    
    public ServicosFactoryTest() {
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
     * Test of getPacienteServicos method, of class ServicosFactory.
     */
    @Test
    public void testGetPacienteServicos() {
        System.out.println("getPacienteServicos");
        PacienteServicos expResult = null;
        PacienteServicos result = ServicosFactory.getPacienteServicos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConvenioServicos method, of class ServicosFactory.
     */
    @Test
    public void testGetConvenioServicos() {
        System.out.println("getConvenioServicos");
        ConvenioServicos expResult = null;
        ConvenioServicos result = ServicosFactory.getConvenioServicos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
