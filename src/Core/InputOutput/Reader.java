package Core.InputOutput;

import Core.CellularAutomaton;
import Core.GameOfLife;
import Core.GolCells.Alive;
import Core.GolCells.Dead;
import Core.WireWorld;
import Core.WwCells.Conductor;
import Core.WwCells.Empty;
import Core.WwCells.Head;
import Core.WwCells.Tail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Reader {
    private int[] dim = new int[2];

    private boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public CellularAutomaton getMode(File file) throws IOException {
        try (Scanner sc = new Scanner(file)) {
            if (!sc.hasNext()) {
                throw new IOException("Plik jest pusty!");
            }
            String temp = sc.next();
            sc.close();
            if (temp.equalsIgnoreCase("ww"))
                return new WireWorld();
            else if (temp.equalsIgnoreCase("gol"))
                return new GameOfLife();
            else
                throw new IOException("Podano błędną nazwę automatu!");
        }
    }


    public void readFile(CellularAutomaton ca, File file) throws IOException {

        int currentRow = 0;
        try (Scanner scanner = new Scanner(file)) {
            if (!scanner.hasNext()) {
                throw new IOException("Plik jest pusty!");
            }
            scanner.next();
            int xDimension = scanner.nextInt();
            int yDimension = scanner.nextInt();
            dim[0] = xDimension;
            dim[1] = yDimension;
            ca.createEmptyGrid(dim[0], dim[1], ca);
            while (scanner.hasNext() && currentRow < dim[1]) {
            String data = scanner.next();
            List<Integer> cells = stringToIntegerArray(data);
                for (int i = 0; i < cells.size(); i++) {
                    if (ca instanceof WireWorld) {
                        switch (cells.get(i)) {
                            case 0: {
                                ca.setCellAtIndex(i, currentRow, new Empty());
                                break;
                            }
                            case 1: {
                                ca.setCellAtIndex(i, currentRow, new Head());
                                break;
                            }
                            case 2: {
                                ca.setCellAtIndex(i, currentRow, new Tail());
                                break;
                            }
                            case 3: {
                                ca.setCellAtIndex(i, currentRow, new Conductor());
                                break;
                            }
                        }
                    } else if (ca instanceof GameOfLife) {
                        switch (Character.getNumericValue(data.charAt(i))) {
                            case 0: {
                                ca.setCellAtIndex(i, currentRow, new Dead());
                            }
                            case 1: {
                                ca.setCellAtIndex(i, currentRow, new Alive());
                            }
                        }
                    }
                }
                currentRow++;
            }

        } catch (FileNotFoundException ignored) {
        }
    }

    private List<Integer> stringToIntegerArray(String string) {
        List<Integer> integers = new ArrayList<>();
        char[] array = string.toCharArray();
        for (char c : array) {
            integers.add(Integer.parseInt(String.valueOf(c)));
        }
        return integers;
    }

}
