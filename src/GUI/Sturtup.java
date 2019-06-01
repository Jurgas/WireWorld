package GUI;

import javax.swing.*;
import java.awt.*;

public class Sturtup {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Launcher frame = new Launcher();
            frame.setTitle("Automat komórkowy");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
