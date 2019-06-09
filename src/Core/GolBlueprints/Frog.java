package Core.GolBlueprints;

import Core.Blueprint;
import Core.CellularAutomaton;
import Core.GolCells.Alive;
import Core.GolCells.Dead;

public class Frog extends Blueprint {
    public void drawBlueprint(int x, int y, CellularAutomaton cellularAutomaton) {
        int[] scheme = {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0};
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                if (scheme[b + a * 4] == 1) {
                    cellularAutomaton.setCellAtIndex(x + b, y + a, new Alive());
                } else {
                    cellularAutomaton.setCellAtIndex(x + b, y + a, new Dead());
                }
            }
        }
    }
}
