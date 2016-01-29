/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ewi.eetrix.uitest;
import fi.ewi.eetrix.core.*;

/**
 *
 * @author ewi
 */
public class GameTest {
    
    static private fi.ewi.eetrix.core.GameControl gc = new GameControl();
    public static void main(String[] args){
        for (int i = 0;i < gc.printGameArea().length;i++) {
            for (int j = 0; j < gc.printGameArea()[i].length;j++) {
                System.out.print(gc.printGameArea()[i][j] + ", ");
            }
            System.out.println("");
        };
    }
    
}
