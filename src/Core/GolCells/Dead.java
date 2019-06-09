package Core.GolCells;

import Core.Cell;

public class Dead extends Cell {
    public Cell nextState(int i) {
        if (i == 3) {
            return new Alive();
        } else {
            return new Dead();
        }

    }
}
