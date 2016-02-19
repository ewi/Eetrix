package fi.ewi.eetrix.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Drawing component test class.
 * @author ewi
 */
public class DrawComponent extends JComponent {

    private static final int DEFAULT_WIDTH = 150;
    private static final int DEFAULT_HEIGHT = 300;

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rect = new Rectangle2D.Double(1, 1, DEFAULT_WIDTH-2, DEFAULT_HEIGHT-2);
        g2.draw(rect);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
