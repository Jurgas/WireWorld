package Core.WwCells;

import Core.Cell;

public class Empty extends Cell {
    public Cell nextState(int i) {
        return new Empty();
    }
}
