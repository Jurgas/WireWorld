package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Board extends JComponent {

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for (int i=0; i< Simulator.mode.getG().getHeight(); i++)
            for( int j=0; j< Simulator.mode.getG().getHeight(); j++){
                Rectangle2D rect = new Rectangle2D.Double(j*Simulator.cellDim,
                        i*Simulator.cellDim, Simulator.cellDim-1, Simulator.cellDim-1);
                g2.setPaint(Color.BLACK);  // do zrobienia
                g2.draw(rect);
                g2.setPaint(Color.RED);
                g2.fill(rect);
            }
    }

    public Dimension getPreferredSize(){
        return new Dimension(Simulator.mode.getG().getWidth()*Simulator.cellDim, Simulator.mode.getG().getHeight()*Simulator.cellDim);
    }
}
