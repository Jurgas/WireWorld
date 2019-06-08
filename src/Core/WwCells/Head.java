package Core.WwCells;

import Core.Cell;

public class Head extends Cell {
    public Cell nextState(int i){
        return new Tail();
    }
}
