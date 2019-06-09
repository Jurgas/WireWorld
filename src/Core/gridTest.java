package Core;

import Core.GolCells.Alive;
import Core.GolCells.Dead;
import Core.WwCells.Conductor;
import Core.WwCells.Head;
import Core.WwCells.Tail;

public class gridTest {
    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.createEmptyGrid(5, 5, new GameOfLife());
        grid.setCellAtIndex(2, 2, new Alive());
        grid.setCellAtIndex(1, 2, new Dead());
        grid.setCellAtIndex(2, 3, new Alive());
        grid.setCellAtIndex(3, 3, new Alive());
        grid.setCellAtIndex(0, 3, new Dead());
        grid.setCellAtIndex(1, 1, new Dead());
        System.out.println(grid.countCells(0, 2));
        for (int y = 0; y < 5; y++) {
            System.out.println();
            for (int x = 0; x < 5; x++) {
                System.out.print(grid.getCellAtIndex(x, y));
            }
        }
        System.out.println();
        System.out.println("--------------------");
        grid.createNewGen();
        for (int y = 0; y < 5; y++) {
            System.out.println();
            for (int x = 0; x < 5; x++) {
                System.out.print(grid.getCellAtIndex(x, y));
            }
        }
    }
}
