package Core.WwBlueprints;

import Core.Blueprint;
import Core.CellularAutomaton;
import Core.WwCells.Conductor;
import Core.WwCells.Empty;

public class OR extends Blueprint {
    public void drawBlueprint(int x, int y, CellularAutomaton cellularAutomaton) {
        int[] scheme = {0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0};
        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 9; b++) {
                if (scheme[b + a * 9] == 1) {
                    cellularAutomaton.setCellAtIndex(x + b, y + a, new Conductor());
                } else {
                    cellularAutomaton.setCellAtIndex(x + b, y + a, new Empty());
                }
            }
        }

    }
}