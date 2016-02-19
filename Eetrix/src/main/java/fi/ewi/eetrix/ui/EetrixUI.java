/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ewi.eetrix.ui;

import fi.ewi.eetrix.core.GameControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author ewi
 */
public class EetrixUI extends JFrame implements KeyListener {

    private DrawComponent dc;
    private DrawBlock bl;
    private JButton startGameButton;
    private JButton exitGameButton;
    private JButton showScoreButton;
    private JLabel scoreLabel;

    public EetrixUI() {
        startGameButton = new JButton("Start Game");
        exitGameButton = new JButton("Show Scores");
        showScoreButton = new JButton("Exit Game");
        scoreLabel = new JLabel();

        dc = new DrawComponent();
        this.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(scoreLabel);
        panel.add(startGameButton);
        panel.add(exitGameButton);
        panel.add(showScoreButton);

        this.add(panel, BorderLayout.EAST);
        this.add(dc, BorderLayout.WEST);

        pack();
    }

    public void addExitButtonListener(ActionListener listenForExitButton) {
        exitGameButton.addActionListener(listenForExitButton);
    }

    private void ab(double x, double y) {
        bl = new DrawBlock(x, y);
        this.addKeyListener(this);
        this.add(bl);

        Thread t = new Thread(bl);
        t.start();

    }

//    private static void gui() {
//        JFrame ui = new EetrixUI();
//        ui.setTitle("Eetrix");
//        ui.pack();
//        ui.setSize(300, 300);
//        ui.setVisible(true);
//        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//    }

//    public static void main(String[] args) {
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                gui();
//            }
//        });
//    }

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
        //displayInfo(e, "KEY RELEASED: ");
        //System.out.println(e.getKeyCode() + "KEY RELEASED: ");

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //displayInfo(e, "KEY RELEASED: ");
        //System.out.println(e.getKeyCode() + "KEY Typed: ");

    }

}
