package Core.InputOutput;

import Core.CellularAutomaton;
import Core.GameOfLife;
import Core.GolCells.Alive;
import Core.GolCells.Dead;
import Core.WireWorld;
import Core.WwCells.Conductor;
import Core.WwCells.Empty;
import Core.WwCells.Head;
import Core.WwCells.Tail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Writer {

    public void writeToFile(CellularAutomaton ca, File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        if (ca instanceof WireWorld) {
            writer.println("WW");
        } else if (ca instanceof GameOfLife) {
            writer.println("GOL");
        }
        writer.println(ca.getWidth() + " " + ca.getHeight());
        for (int y = 0; y < ca.getHeight(); y++) {
            if (y != 0) {
                writer.println();
            }
            for (int x = 0; x < ca.getWidth(); x++) {
                if (ca.getCellAtIndex(x, y) instanceof Dead || ca.getCellAtIndex(x, y) instanceof Empty) {
                    writer.print(0);
                }
                if (ca.getCellAtIndex(x, y) instanceof Alive || ca.getCellAtIndex(x, y) instanceof Head) {
                    writer.print(1);
                }
                if (ca.getCellAtIndex(x, y) instanceof Tail) {
                    writer.print(2);
                }
                if (ca.getCellAtIndex(x, y) instanceof Conductor) {
                    writer.print(3);
                }
            }
        }
        writer.close();
    }
}