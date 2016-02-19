/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ewi.eetrix.core;

/**
 *
 * @author ewi
 */
public class GameControl {
    private GameArea gamearea;
    private Points points;
//    private 
    public GameControl() {
        gamearea = new GameArea(10, 10);
        
    }
    public int[][] printGameArea() {
        return gamearea.getGameArea();
    }
    
    
}
