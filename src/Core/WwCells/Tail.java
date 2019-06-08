package Core.WwCells;

import Core.Cell;

public class Tail extends Cell {
    public Cell nextState( int i){
        return new Conductor();
    }
}
