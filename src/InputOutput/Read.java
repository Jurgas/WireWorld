package InputOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Read {
    private boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String mode;
    private int[] dim = new int[2];

    public int[][] readFile(File file) throws IOException {
        int currentRow = 0;
        try (Scanner sc = new Scanner(file)) {
            if (!sc.hasNext()) {
                throw new IOException("Plik jest pusty!");
            }
            String temp = sc.next();
            if (temp.equalsIgnoreCase("ww"))
                this.mode = "WireWorld";
            else if (temp.equalsIgnoreCase("gol"))
                this.mode = "Game of Life";
            else
                throw new IOException("Podano błędną nazwę automatu!");
            for (int i = 0; i < dim.length; i++) {
                if (isNumeric(temp)) {
                    dim[i] = sc.nextInt();
                }
                else
                    throw new IOException("Błędnie podano wymiary siatki!");
            }
            while (sc.hasNext() && isNumeric(temp = sc.next())) {
                for(int i = 0; i < temp.length(); i++){

                }
            }

        } catch (FileNotFoundException e) {
        }

    }

}
