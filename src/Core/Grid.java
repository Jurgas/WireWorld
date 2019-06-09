package Core;


import Core.GolCells.Alive;
import Core.GolCells.Dead;
import Core.WwCells.Conductor;
import Core.WwCells.Empty;
import Core.WwCells.Head;

import java.util.Arrays;

public class Grid {
    private Cell[][] grid;

    public Grid() {
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
        try {
            this.grid[x][y] = state;
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
    }

    public int countCells(int x, int y) {
        int counter = 0;
        int xa = -1;
        int xb = 1;
        int ya = -1;
        int yb = 1;
        if (x == 0) {
            xa = 0;
        }
        if (x == getWidth() - 1) {
            xb = 0;
        }
        if (y == 0) {
            ya = 0;
        }
        if (y == getHeight() - 1) {
            yb = 0;
        }
        for (int iy = ya; iy <= yb; iy++) {
            for (int ix = xa; ix <= xb; ix++) {
                if (this.grid[x + ix][y + iy] instanceof Head || this.grid[x + ix][y + iy] instanceof Alive) {
                    counter++;
                }
            }
        }
        if (this.grid[x][y] instanceof Alive) {
            counter--;
        }
        return counter;
    }

    public void createEmptyGrid(int width, int height, CellularAutomaton cellularAutomaton) {
        this.grid = new Cell[width][height];
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                if (cellularAutomaton instanceof WireWorld) {
                    this.grid[x][y] = new Empty();
                } else if (cellularAutomaton instanceof GameOfLife) {
                    this.grid[x][y] = new Dead();
                }
            }
        }

    }

    public void createNewGen() {
        Cell[][] temp = new Cell[getWidth()][getHeight()];
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                temp[x][y] = grid[x][y].nextState(countCells(x, y));
            }
        }
        grid = temp;
    }
}
