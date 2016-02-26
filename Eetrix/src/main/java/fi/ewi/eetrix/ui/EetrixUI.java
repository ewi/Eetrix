/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ewi.eetrix.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Main UI class.
 * @author ewi
 */
public class EetrixUI extends JFrame {

    private DrawComponent dc;
    //private DrawBlock bl;
    private JButton startGameButton;
    private JButton exitGameButton;
    private JButton showScoreButton;
    private JLabel scoreLabel;

    /**
     * Constructor. Initializes game UI with buttons and 
     * game area.
     */
    public EetrixUI() {
        startGameButton = new JButton("Start Game");
        exitGameButton = new JButton("Show Scores");
        showScoreButton = new JButton("Exit Game");
        scoreLabel = new JLabel();

        dc = new DrawComponent();
        dc.initGrid(10, 20);
        this.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(scoreLabel);
        panel.add(startGameButton);
        panel.add(exitGameButton);
        //panel.add(showScoreButton);

        this.add(panel, BorderLayout.EAST);
        this.add(dc, BorderLayout.WEST);

        pack();
    }

    /**
     * Update view.
     * @param area integer array representing game area.
     */
    public void updateView(int[][] area) {
        this.dc.updategrid(area);
    }
    /**
     * Exit button listener.
     * @param listenForExitButton Action listener object.
     */
    public void addExitButtonListener(ActionListener listenForExitButton) {
        exitGameButton.addActionListener(listenForExitButton);
    }
        /**
     * Start game button listener.
     * @param listenForStartButton Action listener object.
     */
    public void addStartButtonListener(ActionListener listenForStartButton) {
        startGameButton.addActionListener(listenForStartButton);
    }
    
    /**
     * Disable start button while game is running.
     */
    public void disableStartButton() {
        this.startGameButton.setEnabled(false);
    }
     /**
     * Enable start button while game is running.
     */
    public void enableStartButton() {
        this.startGameButton.setEnabled(true);
    }

}
