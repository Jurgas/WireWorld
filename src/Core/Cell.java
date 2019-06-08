package Core;

import Core.WwCells.Empty;

public abstract class Cell {

    public Cell nextState() {
        return new Empty();
    }
}
