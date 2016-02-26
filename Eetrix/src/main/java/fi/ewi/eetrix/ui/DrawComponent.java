package fi.ewi.eetrix.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Drawing component test class.
 *
 * @author ewi
 */
public class DrawComponent extends JComponent {

    private static final int DEFAULT_WIDTH = 150;
    private static final int DEFAULT_HEIGHT = 300;
    private double y, x;
    private int columns, rows;
    private int[][] grid;

    /**
     * Initialize grid array.
     *
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
     *
     * @param grid integer array 2D
     */
    public void updategrid(int[][] grid) {
        this.grid = grid;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rect = new Rectangle2D.Double(1, 1, DEFAULT_WIDTH - 2, DEFAULT_HEIGHT - 2);
        g2.draw(rect);
        try {
            drawRect(1, 1, g2);
            Thread.sleep(1000);
            drawRect(2, 3, g2);
            Thread.sleep(1000);
            drawRect(3, 4, g2);
        } catch (Exception e) {

        }
//        for (int i = 0; i < rows-1; i++) {
//            for (int j = 0; j < columns-1; j++) {
//                // If color is assigned to grid cell then we draw 
//                // rectangle to corresponding block.
//                if (grid[i][j] != 0) {
//                    drawRect(i, j, g2);
//                }
//            }
//        }

    }

    /**
     * Draw rectangle to graphic area.
     *
     * @param x coordinate
     * @param y coordinate
     * @param g Graphics2D object
     */
    public void drawRect(int x, int y, Graphics2D g) {
        Rectangle2D r2 = new Rectangle2D.Double(x * 10, y * 10, 10, 10);
        g.setColor(Color.orange);
        g.fillRoundRect(2, 2, x * 10, y * 10, 10, 10);
        g.draw(r2);
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
