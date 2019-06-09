package Testy;

import Core.CellularAutomaton;
import Core.GameOfLife;
import Core.GolCells.Alive;
import Core.GolCells.Dead;

public class drawBlueprintTest {
    public static void main(String[] args) {
        boolean success = false;
        CellularAutomaton cellularAutomaton = new GameOfLife();
        cellularAutomaton.createEmptyGrid(4, 4, cellularAutomaton);
        cellularAutomaton.drawBlueprint(1,1 ,cellularAutomaton, "Glider");
        if(cellularAutomaton.getCellAtIndex(0, 0) instanceof Dead &&
                cellularAutomaton.getCellAtIndex(1, 0) instanceof Dead &&
                cellularAutomaton.getCellAtIndex(2, 0) instanceof Dead &&
                cellularAutomaton.getCellAtIndex(3, 0) instanceof Dead &&
                cellularAutomaton.getCellAtIndex(0, 1) instanceof Dead &&
                cellularAutomaton.getCellAtIndex(1, 1) instanceof Dead &&
                cellularAutomaton.getCellAtIndex(2, 1) instanceof Alive &&
                cellularAutomaton.getCellAtIndex(3, 1) instanceof Dead &&
                cellularAutomaton.getCellAtIndex(0, 2) instanceof Dead &&
                cellularAutomaton.getCellAtIndex(1, 2) instanceof Dead &&
                cellularAutomaton.getCellAtIndex(2, 2) instanceof Dead &&
                cellularAutomaton.getCellAtIndex(3, 2) instanceof Alive &&
                cellularAutomaton.getCellAtIndex(0, 3) instanceof Dead &&
                cellularAutomaton.getCellAtIndex(1, 3) instanceof Alive &&
                cellularAutomaton.getCellAtIndex(2, 3) instanceof Alive &&
                cellularAutomaton.getCellAtIndex(3, 3) instanceof Alive) {
            success = true;
        }
        if(success){
            System.out.println("Test metody drawBlueprint() zakończony powodzeniem!");
        }
        else{
            System.out.println("Test metody drawBlueprint() zakończony niepowodzeniem!");
        }

    }
}
