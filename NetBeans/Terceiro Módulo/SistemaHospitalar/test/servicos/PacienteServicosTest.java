/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package servicos;

import java.util.ArrayList;
import modelo.Paciente;
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
public class PacienteServicosTest {
    
    public PacienteServicosTest() {
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
     * Test of cadastrarPaciente method, of class PacienteServicos.
     */
    @Test
    public void testCadastrarPaciente() throws Exception {
        System.out.println("cadastrarPaciente");
        Paciente pac = null;
        PacienteServicos instance = new PacienteServicos();
        instance.cadastrarPaciente(pac);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPacienteFiltro method, of class PacienteServicos.
     */
    @Test
    public void testBuscarPacienteFiltro() throws Exception {
        System.out.println("buscarPacienteFiltro");
        String query = "";
        PacienteServicos instance = new PacienteServicos();
        ArrayList<Paciente> expResult = null;
        ArrayList<Paciente> result = instance.buscarPacienteFiltro(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPaciente method, of class PacienteServicos.
     */
    @Test
    public void testBuscarPaciente() throws Exception {
        System.out.println("buscarPaciente");
        PacienteServicos instance = new PacienteServicos();
        ArrayList<Paciente> expResult = null;
        ArrayList<Paciente> result = instance.buscarPaciente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
