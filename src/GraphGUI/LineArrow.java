package GraphGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

// https://itqna.net/questions/3389/how-draw-arrow-using-java2d
public class LineArrow extends JFrame {

    private static final Polygon ARROW_HEAD = new Polygon();

    static {
        ARROW_HEAD.addPoint(0, 0);
        ARROW_HEAD.addPoint(-5, -10);
        ARROW_HEAD.addPoint(5, -10);
    }

    public static class ArrowEdge {
        private final int x;
        private final int y;
        private final int endX;
        private final int endY;
        private final Color color;

        public ArrowEdge(int x, int y, int x2, int y2, Color color) {
            super();
            this.x = x;
            this.y = y;
            this.endX = x2;
            this.endY = y2;
            this.color = color;
        }

        public void draw(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            double angle = Math.atan2(endY - y, endX - x);

            g2.setColor(color);

            g2.drawLine(x, y, (int) (endX - 10 * Math.cos(angle)), (int) (endY - 10 * Math.sin(angle)));

            AffineTransform tx1 = g2.getTransform();

            AffineTransform tx2 = (AffineTransform) tx1.clone();

            tx2.translate(endX, endY);
            tx2.rotate(angle - Math.PI / 2);

            g2.setTransform(tx2);
            g2.fill(ARROW_HEAD);

            g2.setTransform(tx1);

        }
    }
}
