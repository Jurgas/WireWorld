package Core.WwBlueprints;

import Core.Blueprint;
import Core.CellularAutomaton;
import Core.WwCells.Conductor;
import Core.WwCells.Empty;

public class Diode extends Blueprint {
    private String name = "Diode";

    public void drawBlueprint(int x, int y, CellularAutomaton cellularAutomaton, int rotation) {
        int[] scheme;
        int[] scheme0 = {0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0};
        int[] scheme90 = {0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0,};
        int[] scheme180 = {0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0};
        int[] scheme270 = {0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0,};

        if (rotation == 0 || rotation == 180) {
            for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 8; b++) {
                    if (rotation == 0) {
                        scheme = scheme0;
                    } else {
                        scheme = scheme180;
                    }
                    if (scheme[b + a * 8] == 1) {
                        cellularAutomaton.setCellAtIndex(x + b, y + a, new Conductor());
                    } else {
                        cellularAutomaton.setCellAtIndex(x + b, y + a, new Empty());
                    }
                }
            }
        } else if (rotation == 90 || rotation == 270) {
            for (int a = 0; a < 8; a++) {
                for (int b = 0; b < 3; b++) {
                    if (rotation == 90) {
                        scheme = scheme90;
                    } else {
                        scheme = scheme270;
                    }
                    if (scheme[b + a * 3] == 1) {
                        cellularAutomaton.setCellAtIndex(x + b, y + a, new Conductor());
                    } else {
                        cellularAutomaton.setCellAtIndex(x + b, y + a, new Empty());
                    }
                }
            }
        }
    }
}
