package Core;

import Core.GolBlueprints.Frog;
import Core.GolBlueprints.Glider;
import Core.WwBlueprints.Diode;
import Core.WwBlueprints.OR;

public abstract class CellularAutomaton implements Observable {
    private Grid g;
    public CellularAutomaton() {
        g = new Grid();
    }

    public int getHeight() {
        return g.getHeight();
    }

    public int getWidth() {
        return g.getWidth();
    }

    public Cell getCellAtIndex(int x, int y) {
        return g.getCellAtIndex(x, y);
    }

    public void createEmptyGrid(int width, int height, CellularAutomaton cellularAutomaton) {
        g.createEmptyGrid(width, height, cellularAutomaton);
    }

    public void setCellAtIndex(int x, int y, Cell state) {
        g.setCellAtIndex(x, y, state);
    }

    public void createNewGen() {
        g.createNewGen();
    }

    public void drawBlueprint(int x, int y, CellularAutomaton cellularAutomaton, String str){
        if(str.equals("Frog"))
            new Frog().drawBlueprint(x,y,cellularAutomaton);
        else if (str.equals("Glider"))
            new Glider().drawBlueprint(x,y,cellularAutomaton);
        else if (str.equals("Diode"))
            new Diode().drawBlueprint(x,y,cellularAutomaton);
        else if (str.equals("OR"))
            new OR().drawBlueprint(x,y,cellularAutomaton);
    }
}
