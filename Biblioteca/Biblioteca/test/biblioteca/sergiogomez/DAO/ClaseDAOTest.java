/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.sergiogomez.DAO;

import biblioteca.sergiogomez.Modelo.Libro;
import biblioteca.sergiogomez.Modelo.Usuario;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sergio
 */
public class ClaseDAOTest {
    
    public ClaseDAOTest() {
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
     * Test of cambiarContrasena method, of class ClaseDAO.
     */
    @Test
    public void testCambiarContrasena() {
        System.out.println("cambiarContrasena");
        Usuario usuario = null;
        String contrasena = "";
        ClaseDAO instance = new ClaseDAO();
        boolean expResult = false;
        boolean result = instance.cambiarContrasena(new Usuario(), "prueba");
        assertEquals(expResult, result);
    }

    /**
     * Test of comprobarUsuario method, of class ClaseDAO.
     */
    @Test
    public void testComprobarUsuario() {
        System.out.println("comprobarUsuario");
        String nombre = "";
        String contrasena = "";
        ClaseDAO instance = new ClaseDAO();
        boolean expResult = false;
        boolean result = instance.comprobarUsuario("prueba", "prueba");
        assertEquals(expResult, result);
    }

    /**
     * Test of nuevoIdUsuario method, of class ClaseDAO.
     */
    @Test
    public void testNuevoIdUsuario() {
        System.out.println("nuevoIdUsuario");
        ClaseDAO instance = new ClaseDAO();
        int expResult = 6;
        int result = instance.nuevoIdUsuario();
        assertEquals(expResult, result);
    }

    /**
     * Test of existeUsuario method, of class ClaseDAO.
     */
    @Test
    public void testExisteUsuario() {
        System.out.println("existeUsuario");
        String nombre = "";
        ClaseDAO instance = new ClaseDAO();
        boolean expResult = false;
        boolean result = instance.existeUsuario("Prueba");
        assertEquals(expResult, result);
    }

    /**
     * Test of existeLibro method, of class ClaseDAO.
     */
    @Test
    public void testExisteLibro() {
        System.out.println("existeLibro");
        String isbn = "";
        ClaseDAO instance = new ClaseDAO();
        boolean expResult = false;
        boolean result = instance.existeLibro("aaa");
        assertEquals(expResult, result);
    }

    /**
     * Test of cargarUsuarios method, of class ClaseDAO.
     */
    @Test
    public void testCargarUsuarios() {
        System.out.println("cargarUsuarios");
        ClaseDAO instance = new ClaseDAO();
        int expResult = 0;
        int result = instance.cargarUsuarios().size();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of cargarLibros method, of class ClaseDAO.
     */
    @Test
    public void testCargarLibros() {
        System.out.println("cargarLibros");
        ClaseDAO instance = new ClaseDAO();
        int expResult = 5;
        int result = instance.cargarLibros().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerUsuario method, of class ClaseDAO.
     */
    @Test
    public void testObtenerUsuario() throws Exception {
        System.out.println("obtenerUsuario");
        String nombre = "";
        ClaseDAO instance = new ClaseDAO();
        Usuario expResult = null;
        Usuario result = instance.obtenerUsuario("Admin");
        assertNotEquals(expResult, result);
    }

    /**
     * Test of cargarLibrosUsuairo method, of class ClaseDAO.
     */
    @Test
    public void testCargarLibrosUsuairo() {
        System.out.println("cargarLibrosUsuairo");
        int id = 0;
        ClaseDAO instance = new ClaseDAO();
        ArrayList<Libro> expResult = new ArrayList<Libro>();
        ArrayList<Libro> result = instance.cargarLibrosUsuairo(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of cargarLibrosSinPrestamo method, of class ClaseDAO.
     */
    @Test
    public void testCargarLibrosSinPrestamo() {
        System.out.println("cargarLibrosSinPrestamo");
        ClaseDAO instance = new ClaseDAO();
        ArrayList<Libro> expResult = new ArrayList<Libro>();
        ArrayList<Libro> result = instance.cargarLibrosSinPrestamo();
        assertNotEquals(expResult, result);
    }
 
}
