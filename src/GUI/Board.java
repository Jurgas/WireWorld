package GUI;

import Core.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Board extends JComponent {

    private Simulator s;

    Board(Simulator s) {
        this.s = s;
        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < s.getMode().getG().getHeight(); i++)
            for (int j = 0; j < s.getMode().getG().getWidth(); j++) {
                Rectangle2D rect = new Rectangle2D.Double(j * s.getCellDim(),
                        i * s.getCellDim(), s.getCellDim() - 1, s.getCellDim() - 1);
                Cell c = s.getMode().getG().getCell(j, i);
                g2.setPaint(Color.GRAY);
                g2.draw(rect);
                g2.setPaint(new ColorScheme().getColor(c));
                g2.fill(rect);
            }
    }


    private int[] find(Point2D p) {
        int x = (int) p.getX() / s.getCellDim();
        int y = (int) p.getY() / s.getCellDim();
        return new int[]{x, y};
    }

    private class MouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent event) {
            int[] t = find(event.getPoint());
            Cell penClass = s.getPenClass();
            s.getMode().getG().setCell(t[0], t[1], penClass);
            s.reFreshBoard();
        }

    }

    private class MouseMotionHandler extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent event) {
            int[] t = find(event.getPoint());
            Cell penClass = s.getPenClass();
            s.getMode().getG().setCell(t[0], t[1], penClass);
            s.reFreshBoard();
        }
    }

    void reFreshBoard() {
        repaint();
        revalidate();
    }

    public Dimension getPreferredSize() {
        return new Dimension(s.getMode().getG().getWidth() * s.getCellDim(), s.getMode().getG().getHeight() * s.getCellDim());
    }

}
