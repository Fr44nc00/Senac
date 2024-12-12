/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelo;

import java.util.Date;
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
public class PacienteTest {
    
    public PacienteTest() {
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
     * Test of getEmail method, of class Paciente.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Paciente.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Paciente instance = new Paciente();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConvenio method, of class Paciente.
     */
    @Test
    public void testGetConvenio() {
        System.out.println("getConvenio");
        Paciente instance = new Paciente();
        int expResult = 0;
        int result = instance.getConvenio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConvenio method, of class Paciente.
     */
    @Test
    public void testSetConvenio() {
        System.out.println("setConvenio");
        int convenio = 0;
        Paciente instance = new Paciente();
        instance.setConvenio(convenio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdPaciente method, of class Paciente.
     */
    @Test
    public void testGetIdPaciente() {
        System.out.println("getIdPaciente");
        Paciente instance = new Paciente();
        int expResult = 0;
        int result = instance.getIdPaciente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdPaciente method, of class Paciente.
     */
    @Test
    public void testSetIdPaciente() {
        System.out.println("setIdPaciente");
        int idPaciente = 0;
        Paciente instance = new Paciente();
        instance.setIdPaciente(idPaciente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Paciente.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class Paciente.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Paciente instance = new Paciente();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndereco method, of class Paciente.
     */
    @Test
    public void testGetEndereco() {
        System.out.println("getEndereco");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.getEndereco();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEndereco method, of class Paciente.
     */
    @Test
    public void testSetEndereco() {
        System.out.println("setEndereco");
        String endereco = "";
        Paciente instance = new Paciente();
        instance.setEndereco(endereco);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataNascimento method, of class Paciente.
     */
    @Test
    public void testGetDataNascimento() {
        System.out.println("getDataNascimento");
        Paciente instance = new Paciente();
        Date expResult = null;
        Date result = instance.getDataNascimento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataNascimento method, of class Paciente.
     */
    @Test
    public void testSetDataNascimento() {
        System.out.println("setDataNascimento");
        Date dataNascimento = null;
        Paciente instance = new Paciente();
        instance.setDataNascimento(dataNascimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTelefone method, of class Paciente.
     */
    @Test
    public void testGetTelefone() {
        System.out.println("getTelefone");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.getTelefone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTelefone method, of class Paciente.
     */
    @Test
    public void testSetTelefone() {
        System.out.println("setTelefone");
        String telefone = "";
        Paciente instance = new Paciente();
        instance.setTelefone(telefone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCpf method, of class Paciente.
     */
    @Test
    public void testGetCpf() {
        System.out.println("getCpf");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.getCpf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCpf method, of class Paciente.
     */
    @Test
    public void testSetCpf() {
        System.out.println("setCpf");
        String cpf = "";
        Paciente instance = new Paciente();
        instance.setCpf(cpf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRg method, of class Paciente.
     */
    @Test
    public void testGetRg() {
        System.out.println("getRg");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.getRg();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRg method, of class Paciente.
     */
    @Test
    public void testSetRg() {
        System.out.println("setRg");
        String rg = "";
        Paciente instance = new Paciente();
        instance.setRg(rg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdConvenio method, of class Paciente.
     */
    @Test
    public void testGetIdConvenio() {
        System.out.println("getIdConvenio");
        Paciente instance = new Paciente();
        int expResult = 0;
        int result = instance.getIdConvenio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdConvenio method, of class Paciente.
     */
    @Test
    public void testSetIdConvenio() {
        System.out.println("setIdConvenio");
        int convenio = 0;
        Paciente instance = new Paciente();
        instance.setIdConvenio(convenio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
