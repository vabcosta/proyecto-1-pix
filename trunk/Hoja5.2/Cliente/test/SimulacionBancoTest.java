/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
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
public class SimulacionBancoTest {
    
    public SimulacionBancoTest() {
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
     * Test of main method, of class SimulacionBanco.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        SimulacionBanco.main(args);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of sacarEstado method, of class SimulacionBanco.
     */
    @Test
    public void testSacarEstado() {
        System.out.println("sacarEstado");
        VectorHeap<Cliente> caja1 = null;
        VectorHeap<Cliente> caja2 = null;
        VectorHeap<Cliente> caja3 = null;
        VectorHeap<Cliente> caja4 = null;
        List<Cliente> tamanos = null;
        int j = 0;
        SimulacionBanco.sacarEstado(caja1, caja2, caja3, caja4, tamanos, j);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of sacarEstado2 method, of class SimulacionBanco.
     */
    @Test
    public void testSacarEstado2() {
        System.out.println("sacarEstado2");
        ListaCircular<Cliente> caja5 = null;
        ListaCircular<Cliente> caja6 = null;
        ListaCircular<Cliente> caja7 = null;
        ListaCircular<Cliente> caja8 = null;
        List<Cliente> tamanos = null;
        int j = 0;
        SimulacionBanco.sacarEstado2(caja5, caja6, caja7, caja8, tamanos, j);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of tiempoEspera method, of class SimulacionBanco.
     */
    @Test
    public void testTiempoEspera() {
        System.out.println("tiempoEspera");
        List<Cliente> tamanos = null;
        int j = 0;
        int expResult = 0;
        int result = SimulacionBanco.tiempoEspera(tamanos, j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of cajaMenorSize method, of class SimulacionBanco.
     */
    @Test
    public void testCajaMenorSize() {
        System.out.println("cajaMenorSize");
        int[] tamanos = null;
        int expResult = 0;
        int result = SimulacionBanco.cajaMenorSize(tamanos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of menu method, of class SimulacionBanco.
     */
    @Test
    public void testMenu() {
        System.out.println("menu");
        SimulacionBanco.menu();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of obtenerNumero method, of class SimulacionBanco.
     */
    @Test
    public void testObtenerNumero() {
        System.out.println("obtenerNumero");
        String mensaje = "";
        boolean mostrar = false;
        double expResult = 0.0;
        double result = SimulacionBanco.obtenerNumero(mensaje, mostrar);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }
}
