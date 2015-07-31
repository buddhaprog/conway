/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conway;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rob Helvey
 */
public class ConwayTest {

    public ConwayTest() {
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
     * Test of isValidStartSize method, of class Conway.
     */
    @Test
    public void testIsValidStartSize() {
        System.out.println("isValidStartSize");
        Conway conway = new Conway();
        assertEquals(false, conway.isValidStartSize(-20)); //way outside
        assertEquals(false, conway.isValidStartSize(0));  // it's zero
        assertEquals(false, conway.isValidStartSize(1000)); //way outside
        assertEquals(true, conway.isValidStartSize(1)); //border
        assertEquals(true, conway.isValidStartSize(50));  // middle
        assertEquals(true, conway.isValidStartSize(25)); //border
    }

    /**
     * Test of isValidEndSize method, of class Conway.
     */
    @Test
    public void testIsValidEndSize() {
        System.out.println("isValidEndSize");
        Conway conway = new Conway();
        assertEquals(false, conway.isValidEndSize(-20)); //way outside
        assertEquals(false, conway.isValidEndSize(0));  // it's zero
        assertEquals(false, conway.isValidEndSize(1000)); //way outside
        assertEquals(true, conway.isValidEndSize(1)); //border
        assertEquals(true, conway.isValidEndSize(50));  // middle
        assertEquals(true, conway.isValidEndSize(25)); //border
    }

    /**
     * Test of isValidSize method, of class Conway.
     */
    @Test
    public void testIsValidSize() {
        System.out.println("isValidSize");
        Conway conway = new Conway();
        assertEquals(false, conway.isValidSize(-20)); //way outside
        assertEquals(false, conway.isValidSize(0));  // it's zero
        assertEquals(false, conway.isValidSize(1000)); //way outside
        assertEquals(true, conway.isValidSize(1)); //border
        assertEquals(true, conway.isValidSize(50));  // middle
        assertEquals(true, conway.isValidSize(25)); //border
    }

    /**
     * Test of life method, of class Conway.
     */
    @Test
    public void testLife() {
        System.out.println("life");

        String[] dish1
                =
                {
                    "...o....",
                    "...oo...",
                    "...o....",
                    "...oo...",
                    "...o....",
                    "...o..o.",
                };
        String[] expResult1
                =
                {
                    "...oo...",
                    "..ooo...",
                    "..o.....",
                    "..ooo...",
                    "..oo....",
                    "........"
                };
        String[] result1 = Conway.life(dish1);
        assertArrayEquals(expResult1, result1);

        String[] dish2
                =
                {
                    "...oo...",
                    "..ooo...",
                    "..o.....",
                    "..ooo...",
                    "..oo....",
                    "........"
                };
        String[] expResult2
                =
                {
                    "..o.o...",
                    "..o.o...",
                    ".o......",
                    ".o..o...",
                    "..o.o...",
                    "........"
                };
        String[] result2 = Conway.life(dish2);
        assertArrayEquals(expResult2, result2);

        String[] dish3
                =
                {
                    "..o.o...",
                    "..o.o...",
                    ".o......",
                    ".o..o...",
                    "..o.o...",
                    "........"
                };
        String[] expResult3
                =
                {
                    "........",
                    ".oo.....",
                    ".ooo....",
                    ".ooo....",
                    "...o....",
                    "........"
                };
        String[] result3 = Conway.life(dish3);
        assertArrayEquals(expResult3, result3);

    }

    /**
     * Test of getNeighbors method, of class Conway.
     */
    @Test
    public void testGetNeighbors() {
        System.out.println("getNeighbors");
        String above = "";
        String same = "";
        String below = "";
        int expResult = 0;
        int result = Conway.getNeighbors(above, same, below);
        assertEquals(expResult, result);

        assertEquals(3, Conway.getNeighbors("o", "o", "o"));
        assertEquals(0, Conway.getNeighbors(".", ".", "."));
        assertEquals(1, Conway.getNeighbors(".", ".", "o"));
        assertEquals(2, Conway.getNeighbors(".", "o", "o"));
        assertEquals(2, Conway.getNeighbors("o", "o", "."));
        assertEquals(1, Conway.getNeighbors("o", ".", "."));
        assertEquals(1, Conway.getNeighbors(".", "o", "."));
        assertEquals(2, Conway.getNeighbors("o", ".", "o"));

    }

}
