package Tests;

import Core.CellularAutomaton;
import Core.GameOfLife;
import Core.GolCells.Alive;
import Core.GolCells.Dead;
import Core.InputOutput.Writer;
import Core.WireWorld;
import Core.WwCells.Conductor;
import Core.WwCells.Empty;
import Core.WwCells.Head;
import Core.WwCells.Tail;

import java.io.File;
import java.io.FileNotFoundException;

public class writeToFileTest {
    public static void writeToFileTest(){
        CellularAutomaton ca = new GameOfLife();
        ca.createEmptyGrid(3, 3, ca);
        ca.setCellAtIndex(0, 0, new Dead());
        ca.setCellAtIndex(0, 1, new Alive());
        ca.setCellAtIndex(0, 2, new Dead());
        ca.setCellAtIndex(1, 0, new Dead());
        ca.setCellAtIndex(1, 1, new Dead());
        ca.setCellAtIndex(1, 2, new Alive());
        ca.setCellAtIndex(2, 0, new Alive());
        ca.setCellAtIndex(2, 1, new Alive());
        ca.setCellAtIndex(2, 2, new Alive());

        File f = new File("./TestFiles/writeTest.txt");

        CellularAutomaton ca2 = new WireWorld();
        ca2.createEmptyGrid(3, 3, ca2);
        ca2.setCellAtIndex(0, 0, new Head());
        ca2.setCellAtIndex(0, 1, new Empty());
        ca2.setCellAtIndex(0, 2, new Empty());
        ca2.setCellAtIndex(1, 0, new Head());
        ca2.setCellAtIndex(1, 1, new Conductor());
        ca2.setCellAtIndex(1, 2, new Tail());
        ca2.setCellAtIndex(2, 0, new Head());
        ca2.setCellAtIndex(2, 1, new Empty());
        ca2.setCellAtIndex(2, 2, new Empty());

        File f2 = new File("./TestFiles/writeTest2.txt");

        try {
            new Writer().writeToFile(ca, f);
            new Writer().writeToFile(ca2, f2);
        } catch (FileNotFoundException ignored) {
        }
    }
}
