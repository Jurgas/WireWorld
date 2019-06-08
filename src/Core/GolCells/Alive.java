package Core.GolCells;

import Core.Cell;

public class Alive extends Cell {
    public Cell nextState(int i) {
        if (i == 2 || i == 3) {
            return new Alive();
        }
        else{
            return new Dead();
        }

    }
}
