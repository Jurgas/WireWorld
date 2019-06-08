package GUI;

import Core.Cell;
import Core.GolCells.Dead;
import Core.WwCells.Empty;
import Core.WwCells.Head;
import Core.WwCells.Tail;

import java.awt.*;

class ColorScheme {

    Color getColor(Cell c) {
        if (c.getClass().getPackageName().equals("Core.WwCells"))
            return WwColor(c);
        else
            return GolColor(c);
    }

    private Color WwColor(Cell c) {
        if (c instanceof Empty)
            return Color.BLACK;
        else if (c instanceof Head)
            return Color.RED;
        else if (c instanceof Tail)
            return Color.BLUE;
        else
            return Color.ORANGE;
    }

    private Color GolColor(Cell c) {
        if (c instanceof Dead)
            return Color.WHITE;
        else
            return Color.BLACK;
    }
}

