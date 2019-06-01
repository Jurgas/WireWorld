package GUI;

import Core.CellularAutomaton;
import Core.GameOfLife;
import Core.WireWorld;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Simulator extends JFrame {

    private CellularAutomaton mode;
    private int cellDim;
    private boolean drawBlueprint;

    public  Simulator(String selectedMode){
        setPreferredSize(new Dimension(500, 500));
        if(selectedMode.equals("WireWorld"))
            mode = new WireWorld();
        else if (selectedMode.equals("Game of Life"))
            mode = new GameOfLife();
        else
            System.out.println("zle");

        pack();
        setLocationRelativeTo(null);
    }

    public Simulator(String selectedMode, File file) {
        this(selectedMode);
    }

    public Simulator(String selectedMode, int cellGridx, int cellGridy){
        this(selectedMode);

        System.out.println(cellGridx);
        System.out.println(cellGridy);
    }

    public CellularAutomaton getMode() {
        return mode;
    }
}
