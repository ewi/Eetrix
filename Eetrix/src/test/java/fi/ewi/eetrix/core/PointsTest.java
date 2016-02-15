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
public class PointsTest {
    
    public PointsTest() {
    }

    @Test
    public void testConstructor() {
        Points p = new Points();
        assertEquals(p.getPoints(),0);
    }
    
    @Test
    public void testPointsadd() {
        Points p = new Points();
        assertEquals(p.getPoints(),0);
        p.addPoints();
        assertEquals(p.getPoints(),1);
        // Test overflow handling
        p.addPoints(Integer.MAX_VALUE-1);
        assertEquals(p.getPoints(),Integer.MAX_VALUE);
        assertFalse(p.addPoints());
    }
    
    @Test
    public void testInnerClass() {
        Points p = new Points();
        p.addPoints(100);
        p.addPlayerToList("Mr.Gamer");
    }

}
