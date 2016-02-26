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
public class GameAreaTest {
    
     static GameArea gamearea;
     static Block block;
     
    public GameAreaTest() {
        gamearea = new GameArea(10,10);
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        gamearea = new GameArea(10,10);
    }
    @Test
    public void testblockset() {
        assertTrue(gamearea.setCell(1,1,1));
    }
    @Test
    public void testCell() {
        assertTrue(gamearea.testCell(1,1));
    }
    
    @Test
    public void testInitialGameArea() {
        assertEquals(gamearea.getWidth(),10);
        assertEquals(gamearea.getHeight(),10);
    }
    @Test
    public void testCellsinitialcondition() {
        assertEquals(gamearea.testCell(2,2),true);
    }
    
    @Test
    public void testMergeBlock_Before() {
        block = new Block(5,5);
        gamearea.setBlock(block);
        System.out.println(gamearea.testCell(block.getXposition(), block.getYposition()));
        assertEquals(gamearea.testCell(block.getXposition(), block.getYposition()),true);
    }
    @Test
    public void testMergeBlock_After() {
        block = new Block(5,5);
        gamearea.setBlock(block);
        gamearea.mergeBlock();
        assertEquals(gamearea.testCell(block.getXposition(), block.getYposition()),true);
    }
    @After
    public void tearDown() {
    }






}
