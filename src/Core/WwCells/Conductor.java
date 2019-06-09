package Core.WwCells;

import Core.Cell;

public class Conductor extends Cell {
    public Cell nextState(int i) {
        if (i == 1 || i == 2) {
            return new Head();
        } else {
            return new Conductor();
        }

    }
}
