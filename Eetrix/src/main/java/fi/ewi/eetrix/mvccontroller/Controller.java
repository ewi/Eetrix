package fi.ewi.eetrix.mvccontroller;

import fi.ewi.eetrix.ui.*;
import fi.ewi.eetrix.core.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;

/**
 *
 * @author ewi
 */
/*
 HOURS: 2016-02-19 | 0.5h | Aloitettu MVC kontrollerin kirjoitus
 */
public class Controller implements KeyListener, ActionListener {

    private Block bl;
    private EetrixUI eetrixUI;
    private GameControl gc;
    private GameArea ga;
    
    public Controller(EetrixUI uI, GameControl gcontr) {
        this.eetrixUI = uI;
        this.gc = gcontr;
        GameArea ga = new GameArea(10, 20);
        this.eetrixUI.addExitButtonListener(new ExitButtonListener());

    }
    /**
     * Main game loop, handles new block creation.
     */
    public void gameloop() {
        boolean newBlock = true;
        while (true) {
            if (newBlock) {
                bl = new Block();
                Thread t = new Thread(bl);
                t.start();
                newBlock = false;
            }
            if (ga.testCollision(bl)){
                bl.setCollisionHappened();
                ga.setBlock(bl);
                ga.mergeBlock();
            }
        }
    }

    public void updateGraphicGameArea() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 39) {
            bl.moveRight();
        }
        if (e.getKeyCode() == 37) {
            bl.moveLeft();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    class ExitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
}
    class StartGameButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            gameloop();
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
}
    
}