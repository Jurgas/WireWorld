package Core;

import java.util.Arrays;
import java.util.List;

public class Grid {
    private Cell[][] grid;

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

    public void setCellAtIndex(Cell state, int x, int y) {
        this.grid[x][y] = state;
    }

    public void createNewGen() {
        Arrays.stream(this.grid).forEach(row -> {
            Arrays.stream(row).forEach(cell -> {
                cell = cell.nextState();
            });
        });
    }
}
