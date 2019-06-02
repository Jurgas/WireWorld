package Core;

public abstract class CellularAutomaton implements Observable {
    private Grid g;

    public CellularAutomaton(){
        g = new Grid();
    }

    public Grid getG(){
        return g;
    }
}
