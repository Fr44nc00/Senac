/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import java.util.ArrayList;
import modelo.Convenio;
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
public class ConvenioDAOTest {
    
    public ConvenioDAOTest() {
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
     * Test of buscarcConvenios method, of class ConvenioDAO.
     */
    @Test
    public void testBuscarcConvenios() throws Exception {
        System.out.println("buscarcConvenios");
        ConvenioDAO instance = new ConvenioDAO();
        ArrayList<Convenio> expResult = null;
        ArrayList<Convenio> result = instance.buscarcConvenios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarConvenioFiltro method, of class ConvenioDAO.
     */
    @Test
    public void testBuscarConvenioFiltro() throws Exception {
        System.out.println("buscarConvenioFiltro");
        String query = "";
        ConvenioDAO instance = new ConvenioDAO();
        Convenio expResult = null;
        Convenio result = instance.buscarConvenioFiltro(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
