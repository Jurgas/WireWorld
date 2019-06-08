package Core;

public abstract class CellularAutomaton implements Observable {
    private Grid g;

    public CellularAutomaton(){
        g = new Grid();
    }

    public Grid getG(){
        return g;
    }

    public void setCellAtIndex(int x, int y, Cell state){
        g.setCellAtIndex(x, y, state);
    }
}
