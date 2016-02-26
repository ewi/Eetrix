package fi.ewi.eetrix.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

/**
 * Class for updating game area.
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

    /**
     * Constructor. 
     * @param x coordinate
     * @param y coordinate
     */
    public DrawBlock(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // TODO Move movemethods to core.
    /**
     * Decrement x.
     */
    public void moveLeft() {
        this.x -= 10;
        repaint();
    }

    /**
     * Increment x.
     */
    public void moveRight() {
        this.x += 10;
        repaint();
    }

    /**
     * Increment y.
     */
    public void moveDown() {
        this.y += 10;
    }

    /**
     * Increment y.
     */
    private void moveBlockDown() {
        y = y + 1;
    }

    /**
     * Initialize grid array.
     * @param columns columns
     * @param rows rows
     */
    public void initGrid(int columns, int rows) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new int[rows][columns];
    }

    /**
     * Set grid for drawing game area.
     * @param grid integer array 2D
     */
    public void updategrid(int[][] grid) {
        this.grid = grid;
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // If color is assigned to grid cell then we draw 
                // rectangle to corresponding block.
                if (grid[i][j] != 0) {
                    drawRect(i, j, g2d);
                }
            }
        }
    }

    /**
     * Draw rectangle to graphic area.
     * @param x coordinate
     * @param y coordinate
     * @param g Graphics2D object
     */
    public void drawRect(int x, int y, Graphics2D g) {
        rect = new Rectangle2D.Double(x * 10, y * 10, 10, 10);
        g.fillRoundRect(2, 2, x * 10, y * 10, 10, 10);
        g.setColor(Color.orange);
        g.draw(rect);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    /**
     * Thread interface run method for moving block down.
     */
    @Override
    public void run() {
        try {

            while (true) {
                moveBlockDown();
                repaint();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {

        }

    }

}
