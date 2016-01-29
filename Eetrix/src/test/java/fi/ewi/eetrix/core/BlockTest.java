/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ewi.eetrix.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        gamearea = new GameArea(10,10);
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
        block = new Block(2,2);
        assertEquals(block.getXposition(),2);
        assertEquals(block.getYposition(),2);
        block.moveLeft();
        assertEquals(block.getXposition(),1);
        assertEquals(block.getYposition(),2);
        block.moveDown();
        assertEquals(block.getXposition(),1);
        assertEquals(block.getYposition(),1);
        block.moveRight();
        assertEquals(block.getXposition(),2);
        assertEquals(block.getYposition(),1);
        block.moveUp();
        assertEquals(block.getXposition(),2);
        assertEquals(block.getYposition(),2);

    }
    @Test
    public void testCollision_Happened() {
        block.setX(gamearea.getX()/2);
        block.setY(0);
            block.moveDown();
            assertEquals(gamearea.testCollision(block),true);
       
    }
    @Test
    public void testCollision_NotHappened() {
        block.setX(gamearea.getX()/2);
        block.setY(gamearea.getY()/2);
        block.moveDown();
        assertEquals(gamearea.testCollision(block),false);
    
    }
}
