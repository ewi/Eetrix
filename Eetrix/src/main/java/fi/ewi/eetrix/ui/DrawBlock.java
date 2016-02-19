/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ewi.eetrix.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

/**
 *
 * @author ewi
 */
public class DrawBlock extends JPanel implements Runnable {

    private static final int DEFAULT_WIDTH = 100;
    private static final int DEFAULT_HEIGHT = 100;
    private double y, x;
    private int columns, rows;
    private int[][] grid;
    private Rectangle2D rect;
    private Graphics2D g2;

    public DrawBlock(double x, double y) {
        this.x = x;
        this.y = y;
        //this.addKeyListener(this);
//        addKl();
    }

    public void moveLeft() {
        this.x -= 10;
        repaint();
    }

    public void moveRight() {
        this.x += 10;
        repaint();
    }

    public void moveDown() {
        this.y += 10;
    }

    private void moveBall() {
        y = y + 1;
    }

    public void initGrid(int columns, int rows) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new int[rows][columns];
    }

    public void updategrid(int[][] grid) {
        this.grid = grid;
    }

    @Override
//	public void paint(Graphics g) {
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        //g2d.fillOval((int)x, (int)y, 30, 30);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                drawRect(i, j, g2d);
            }
        }
    }

    public void drawRect(int x, int y, Graphics2D g) {
        rect = new Rectangle2D.Double(x * 10, y * 10, 10, 10);
        g.fillRoundRect(2, 2, x * 10, y * 10, 10, 10);
        g.setColor(Color.orange);
        g.draw(rect);
    }
    /* public void paintComponent(Graphics g) {
     super.paintComponent(g);
     g2 = (Graphics2D) g;
     rect = new Rectangle2D.Double(this.x,this.y,40,40);
     g2.draw(rect);
     // Add action listener
     //        try {
     //    Thread.sleep(1000);                 //1000 milliseconds is one second.
     //} catch(InterruptedException ex) {
     //    Thread.currentThread().interrupt();
     //}
     r();
     r();
     r();
     r();
        

     } 
     */

    public void r() {
        this.x += 10;
        this.y += 10;
        rect.setRect(this.x, this.y, 10, 10);
        g2.draw(rect);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

//    	public static void main(String[] args) throws InterruptedException {
//		JFrame frame = new JFrame("Mini Tennis");
//		Game game = new Game();
//		frame.add(game);
//		frame.setSize(300, 400);
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		while (true) {
//			game.moveBall();
//			game.repaint();
//			Thread.sleep(10);
//		}
//	}
    @Override
    public void run() {
        try {

            while (true) {
                moveBall();
                repaint();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {

        }

    }
        // Add eventlistener for keyboardpresses.
    //InputMap imap =
//        /*public void actionPerformed(ActionEvent event) {
//            System.out.println("Action");
//        */}
}
