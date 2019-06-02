package Core;

public class Grid {
    private Cell[][] grid;


    public Grid(){
        grid = new Cell[50][50];
    }

    public int getWidth() {
        return grid.length;
    }

    public int getHeight() {
        return grid[0].length;
    }

    public Cell getCell(int w, int h) {
        return grid[w][h];
    }
}
