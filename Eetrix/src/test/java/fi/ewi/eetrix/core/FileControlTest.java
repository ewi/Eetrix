package fi.ewi.eetrix.core;

import java.util.ArrayList;
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
public class FileControlTest {
    
    public FileControlTest() {
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

     @Test
     public void WriteFile() {
         ArrayList<String> scores = new ArrayList<>();
         scores.add("risto:200");
         scores.add("risto:100");
         
         FileControl fc = new FileControl("scores.dat");
         ArrayList<String> scores2 = fc.getFileContents();
         assertEquals(scores2.size(),0);
         fc.setFileContents(scores);         
     }
}
