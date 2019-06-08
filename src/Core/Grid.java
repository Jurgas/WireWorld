package Core;

import Core.WwCells.Empty;

import java.util.Arrays;
import java.util.List;

public class Grid {
    private Cell[][] grid;

    public Grid() {
        this.grid = new Cell[5][5];
    }

    public void createEmptyGrid(int width, int height) {
        this.grid = new Cell[width][height];
    }

    public Cell getCellAtIndex(int x, int y) {
        return this.grid[x][y];
    }

    public int getWidth() {
        return this.grid.length;
    }

    public int getHeight() {
        return this.grid[0].length;
    }

    public void setCellAtIndex(int x, int y, Cell state) {
        this.grid[x][y] = state;
    }

    public void createNewGen() {
        Arrays.stream(this.grid).forEach(row -> {
            Arrays.stream(row).forEach(cell -> {
                cell = cell.nextState();
            });
        });
    }

    public Cell getCell(int x, int y) {

        //TODO unmock
        return new Empty();
    }
}
