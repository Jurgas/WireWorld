package Core.InputOutput;

import Core.CellularAutomaton;
import Core.WireWorld;

import java.io.File;
import java.io.IOException;

public class ReaderTest {

    public static void main(String[] args) throws IOException {
        CellularAutomaton automaton = new WireWorld();
        Reader reader = new Reader();
        File data = new File("/Users/piotrowczarczyk/IdeaProjects/WireWorld2/cellgrids/data.txt");
        CellularAutomaton parsedData = reader.readFile(automaton, data);
        System.out.println(parsedData);

    }
}
