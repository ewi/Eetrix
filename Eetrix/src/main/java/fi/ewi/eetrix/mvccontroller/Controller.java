package fi.ewi.eetrix.mvccontroller;

import fi.ewi.eetrix.ui.*;
import fi.ewi.eetrix.core.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;

/**
 * MVC-architecture controller class. This uses UI-class (eetrix.ui) and
 * model-package (eetrix.core).
 *
 * @author ewi
 */
/*
 HOURS: 2016-02-19 | 0.5h | Aloitettu MVC kontrollerin kirjoitus
 */
public class Controller implements KeyListener, ActionListener {

    private Block bl;
    private EetrixUI eetrixUI;
    private GameArea ga;

    /**
     * Constructor.
     *
     * @param uI EetrixUI Object
     * @param ga Game area object.
     */
    public Controller(EetrixUI uI, GameArea ga) {
        this.eetrixUI = uI;
        this.ga = ga;
        this.eetrixUI.addExitButtonListener(new ExitButtonListener());
        this.eetrixUI.addStartButtonListener(new StartGameButtonListener());
        //ga.setCell(5, 5, 1);
        //updateGraphicGameArea();
    }

    /**
     * Main game loop, handles new block creation.
     */
    public void gameloop() {
        this.eetrixUI.disableStartButton();
        boolean newBlock = true;
//        while (true) {
//            if (newBlock) {
//                ga.newBlock(); //bl = new Block();
//                Thread t = new Thread(ga.getBlock());
//                t.start();
//                newBlock = false;
//            }
//            if (ga.testCollision()) {
//                ga.getBlock().setCollisionHappened();
//                ga.mergeBlock();
//            }
        ga.setCell(1, 1, 1);
        ga.setCell(4, 4, 1);
        updateGraphicGameArea();
//        }
        this.eetrixUI.enableStartButton();

    }

    /**
     * Update JComponent variables.
     */
    public void updateGraphicGameArea() {
        this.eetrixUI.updateView(ga.getGameArea());
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

    /**
     * Action handler for exit button.
     */
    class ExitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    /**
     * Action handler for start button.
     */
    class StartGameButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button clicked");

            gameloop();

        }

    }

}
