package fi.ewi.eetrix.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author ewi
 */
public class BlockTest {

    static Block block;
    static GameArea gamearea;

    public BlockTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        block = new Block();
        gamearea = new GameArea(10, 10);
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

    @Test
    public void testBlockMovement() {
        block = new Block(2, 2);
        assertEquals(block.getXposition(), 2);
        assertEquals(block.getYposition(), 2);
        block.moveLeft();
        assertEquals(block.getXposition(), 1);
        assertEquals(block.getYposition(), 2);
        block.moveDown();
        assertEquals(block.getXposition(), 1);
        assertEquals(block.getYposition(), 1);
        block.moveRight();
        assertEquals(block.getXposition(), 2);
        assertEquals(block.getYposition(), 1);
        block.moveUp();
        assertEquals(block.getXposition(), 2);
        assertEquals(block.getYposition(), 2);

    }

    @Test
    public void testCollision_Happened() {
        block.setX(gamearea.getWidth() / 2);
        block.setY(0);
        block.moveDown();
        gamearea.setBlock(block);
        assertEquals(gamearea.testCollision(), true);

    }

    @Test
    public void testCollision_NotHappened() {
        block.setX(gamearea.getWidth() / 2);
        block.setY(gamearea.getHeight() / 2);
        block.moveDown();
        gamearea.setBlock(block);

        assertEquals(gamearea.testCollision(), false);
    }

    @Ignore("Ignored")
    @Test(timeout = 1000)
    public void testThread() {
        GameArea ga = new GameArea(10, 20);
        ga.newBlock();
        Block bl = ga.getBlock();
        bl.setGamelevel(100);
        bl.setX(5);
        bl.setY(19);
        Thread t = new Thread(bl);
        t.start();
        try {
            t.join();
        } catch (Exception e) {

        }
        for (int i = 0; i < ga.getHeight(); i++) {
            for (int x : ga.getRow(i)) {
                System.out.println(x + ",");
            }
            System.out.println("");
        }

    }
}
