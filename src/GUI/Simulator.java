package GUI;

import Core.Cell;
import Core.CellularAutomaton;
import Core.GameOfLife;
import Core.WireWorld;

import javax.swing.*;
import java.awt.*;

class Simulator extends JFrame {

    private static final int DEFAULT_WIDTH = 1280;
    private static final int DEFAULT_HEIGHT = 720;


    private CellularAutomaton mode;
    private int cellDim = 20;
    private Sidebar side;
    private Board board;
    private boolean drawBlueprint;
    static JScrollPane boardScrollPane;

    Simulator(CellularAutomaton mode) {
        this.mode = mode;
        Simulator s = this;
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setResizable(false);
        if (mode instanceof WireWorld) {
            side = new WwSidebar(new GridBagLayout(), s);
            add(side, BorderLayout.WEST);
        } else if (mode instanceof GameOfLife) {
            side = new GolSidebar(new GridBagLayout(), s);
            add(side, BorderLayout.WEST);
        } else {
            JOptionPane.showMessageDialog(null, "Wybrano zły automat!", "Błąd", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
        board = new Board(s);
        boardScrollPane = new JScrollPane(board);
        add(boardScrollPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    CellularAutomaton getMode() {
        return mode;
    }

    int getCellDim() {
        return cellDim;
    }

    void setCellDim(int cellDim) {
        this.cellDim = cellDim;
    }

    Cell getPenClass() {
        return side.getPen();
    }

    void reFreshBoard() {
        board.reFreshBoard();
    }

}
