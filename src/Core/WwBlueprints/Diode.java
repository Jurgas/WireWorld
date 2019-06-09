package Core.WwBlueprints;

import Core.Blueprint;
import Core.CellularAutomaton;
import Core.WwCells.Conductor;
import Core.WwCells.Empty;

public class Diode extends Blueprint {
    public void drawBlueprint(int x, int y, CellularAutomaton cellularAutomaton) {
        int[] scheme = {0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0};
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 8; b++) {
                if (scheme[b + a * 8] == 1) {
                    cellularAutomaton.setCellAtIndex(x + b, y + a, new Conductor());
                } else {
                    cellularAutomaton.setCellAtIndex(x + b, y + a, new Empty());
                }
            }
        }
    }
}
