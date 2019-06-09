package Tests;

import Core.Cell;
import Core.GameOfLife;
import Core.GolCells.Alive;
import Core.GolCells.Dead;
import Core.Grid;
import Core.WireWorld;
import Core.WwCells.Conductor;
import Core.WwCells.Empty;
import Core.WwCells.Head;

public class nextStateTest {

    public static void nextStateTest(){
        int i = 0;

        Grid grid = new Grid();
        grid.createEmptyGrid(3, 3, new GameOfLife());
        grid.setCellAtIndex(0, 0, new Dead());
        grid.setCellAtIndex(0, 1, new Alive());
        grid.setCellAtIndex(0, 2, new Dead());
        grid.setCellAtIndex(1, 0, new Dead());
        grid.setCellAtIndex(1, 1, new Dead());
        grid.setCellAtIndex(1, 2, new Alive());
        grid.setCellAtIndex(2, 0, new Alive());
        grid.setCellAtIndex(2, 1, new Alive());
        grid.setCellAtIndex(2, 2, new Alive());

        int count = grid.countCells(1, 1);

        Cell test = new Alive().nextState(count);

        if (test instanceof Dead)
            i++;


        Grid grid2 = new Grid();
        grid2.createEmptyGrid(3, 3, new WireWorld());
        grid2.setCellAtIndex(0, 0, new Head());
        grid2.setCellAtIndex(0, 1, new Empty());
        grid2.setCellAtIndex(0, 2, new Empty());
        grid2.setCellAtIndex(1, 0, new Head());
        grid2.setCellAtIndex(1, 1, new Conductor());
        grid2.setCellAtIndex(1, 2, new Conductor());
        grid2.setCellAtIndex(2, 0, new Head());
        grid2.setCellAtIndex(2, 1, new Empty());
        grid2.setCellAtIndex(2, 2, new Empty());

        int count2 = grid2.countCells(1, 1);

        Cell test2 = new Alive().nextState(count2);

        if (test2 instanceof Conductor)
            i++;

        if (i == 2)
            System.out.println("Test metody nextState() zakończony powodzeniem!");
        else {
            System.out.println("Test metody nextState() zakończony niepowodzeniem!");
        }
    }
}
