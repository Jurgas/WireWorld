package Core;

public abstract class CellularAutomaton implements Observable {
    private Grid g;

    public CellularAutomaton(){
        g = new Grid();
    }

    public Grid getG(){
        return g;
    }

    public int getHeight(){
        return g.getHeight();
    }
    public int getWidth(){
        return g.getWidth();
    }

    public Cell getCellAtIndex(int x, int y){
        return g.getCellAtIndex(x, y);
    }

    public void createEmptyGrid(int width, int height, CellularAutomaton cellularAutomaton){
        g.createEmptyGrid(width, height, cellularAutomaton);
    }
    public void setCellAtIndex(int x, int y, Cell state){
        g.setCellAtIndex(x, y, state);
    }
}
