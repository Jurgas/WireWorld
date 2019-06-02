package GUI;

import Core.CellularAutomaton;
import Core.GameOfLife;
import Core.WireWorld;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Simulator extends JFrame {

    private static final int DEFAULT_WIDTH = 1280;
    private static final int DEFAULT_HEIGHT = 720;


    static CellularAutomaton mode;
    static int cellDim = 20;
    private Sidebar side;
    static Board board;
    private boolean drawBlueprint;
    private JScrollPane boardScrollPane;

    public Simulator(String selectedMode) {
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setResizable(false);
        if (selectedMode.equalsIgnoreCase("WireWorld")) {
            mode = new WireWorld();
            side = new WwSidebar(new GridBagLayout());
            add(side, BorderLayout.WEST);
        } else if (selectedMode.equalsIgnoreCase("Game of Life")) {
            mode = new GameOfLife();
            side = new GolSidebar(new GridBagLayout());
            add(side, BorderLayout.WEST);
        } else {
            JOptionPane.showMessageDialog(null, "Wybrano zły automat!", "Błąd", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }

        board = new Board();
        boardScrollPane = new JScrollPane(board);
        add(boardScrollPane, BorderLayout.CENTER);


        pack();
        setLocationRelativeTo(null);
    }

    public Simulator(String selectedMode, File file) {
        this(selectedMode);
    }

    public Simulator(String selectedMode, int cellGridx, int cellGridy) {
        this(selectedMode);
    }

    public CellularAutomaton getMode() {
        return mode;
    }

}
