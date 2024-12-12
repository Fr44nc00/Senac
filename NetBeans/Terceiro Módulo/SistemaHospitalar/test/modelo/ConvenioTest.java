/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelo;

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
public class ConvenioTest {
    
    public ConvenioTest() {
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
     * Test of getIdConvenio method, of class Convenio.
     */
    @Test
    public void testGetIdConvenio() {
        System.out.println("getIdConvenio");
        Convenio instance = new Convenio();
        int expResult = 0;
        int result = instance.getIdConvenio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdConvenio method, of class Convenio.
     */
    @Test
    public void testSetIdConvenio() {
        System.out.println("setIdConvenio");
        int idConvenio = 0;
        Convenio instance = new Convenio();
        instance.setIdConvenio(idConvenio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNomeConvenio method, of class Convenio.
     */
    @Test
    public void testGetNomeConvenio() {
        System.out.println("getNomeConvenio");
        Convenio instance = new Convenio();
        String expResult = "";
        String result = instance.getNomeConvenio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNomeConvenio method, of class Convenio.
     */
    @Test
    public void testSetNomeConvenio() {
        System.out.println("setNomeConvenio");
        String nomeConvenio = "";
        Convenio instance = new Convenio();
        instance.setNomeConvenio(nomeConvenio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTempoCarencia method, of class Convenio.
     */
    @Test
    public void testGetTempoCarencia() {
        System.out.println("getTempoCarencia");
        Convenio instance = new Convenio();
        String expResult = "";
        String result = instance.getTempoCarencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTempoCarencia method, of class Convenio.
     */
    @Test
    public void testSetTempoCarencia() {
        System.out.println("setTempoCarencia");
        String tempoCarencia = "";
        Convenio instance = new Convenio();
        instance.setTempoCarencia(tempoCarencia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCnpj method, of class Convenio.
     */
    @Test
    public void testGetCnpj() {
        System.out.println("getCnpj");
        Convenio instance = new Convenio();
        String expResult = "";
        String result = instance.getCnpj();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCnpj method, of class Convenio.
     */
    @Test
    public void testSetCnpj() {
        System.out.println("setCnpj");
        String cnpj = "";
        Convenio instance = new Convenio();
        instance.setCnpj(cnpj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
