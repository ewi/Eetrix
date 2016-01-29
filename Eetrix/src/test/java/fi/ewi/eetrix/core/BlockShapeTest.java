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
public class BlockShapeTest {
    
    static BlockShape bshape;
    
    public BlockShapeTest() {
        bshape = new BlockShape();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
  
    @Test
    public void testSquareblock() {
        bshape.squareBlock();
        char[][] test = bshape.getBlockShape();
        assertEquals(test[0][0], '1');
    }
}
