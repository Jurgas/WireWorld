package Tests;

import Core.CellularAutomaton;
import Core.InputOutput.Reader;
import Core.WireWorld;
import Core.WwCells.Empty;
import Core.WwCells.Head;
import Core.WwCells.Tail;

import java.io.File;
import java.io.IOException;

public class readFileTest {


    public static void readFileTest() throws IOException {
        boolean success = false;
        CellularAutomaton readData = new WireWorld();
        Reader reader = new Reader();
        File data = new File("/Users/piotrowczarczyk/IdeaProjects/WireWorld2/cellgrids/data.txt");
        reader.readFile(readData, data);

        if(readData.getCellAtIndex(0, 0) instanceof Empty &&
                readData.getCellAtIndex(1, 0) instanceof Head &&
                readData.getCellAtIndex(2, 0) instanceof Tail &&
                readData.getCellAtIndex(0, 1) instanceof Head &&
                readData.getCellAtIndex(1, 1) instanceof Head &&
                readData.getCellAtIndex(2, 1) instanceof Head &&
                readData.getCellAtIndex(0, 2) instanceof Empty &&
                readData.getCellAtIndex(1, 2) instanceof Empty &&
                readData.getCellAtIndex(2, 2) instanceof Empty) {
            success = true;
        }

        if(success){
            System.out.println("Test metody readFile() zakończony powodzeniem!");
        }
        else{
            System.out.println("Test metody readFile() zakończony niepowodzeniem!");
        }
    }

}
