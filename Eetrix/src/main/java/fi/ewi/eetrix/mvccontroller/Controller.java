package fi.ewi.eetrix.mvccontroller;

import fi.ewi.eetrix.ui.*;
import fi.ewi.eetrix.core.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author ewi
 */
/*
 HOURS: 2016-02-19 | 0.5h | Aloitettu MVC kontrollerin kirjoitus
 */
public class Controller implements KeyListener {

    private Block bl;

    public Controller() {
        EetrixUI eetrixUI = new EetrixUI();
        GameControl gc = new GameControl();
        GameArea ga = new GameArea(10, 20);
    }

    public void gameloop() {
        boolean newBlock = true;
        while (true) {
            if (newBlock) {
                bl = new Block();
                Thread t = new Thread(bl);
                t.start();
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
}
