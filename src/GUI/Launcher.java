package GUI;

import Core.CellularAutomaton;
import Core.GameOfLife;
import Core.InputOutput.Reader;
import Core.WireWorld;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

class Launcher extends JFrame {
    private JTextField widthTextField;
    private JTextField heightTextField;
    private JLabel sizeLabel;
    private JLabel typeLabel;
    private JLabel widthLabel;
    private JLabel heightLabel;
    private ButtonGroup typeGroup;
    private JRadioButton wwRadioButton;
    private JRadioButton golRadioButton;
    private JButton createButton;
    private JButton readButton;
    private File file;

    Launcher() {

        KeyAdapter adapter = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE))
                    e.consume();
            }
        };


        setLayout(new GridBagLayout());
        setResizable(false);

        widthTextField = new JTextField("50", 4);
        heightTextField = new JTextField("50", 4);

        widthTextField.addKeyListener(adapter);
        heightTextField.addKeyListener(adapter);

        sizeLabel = new JLabel("Wielkość planszy:");
        typeLabel = new JLabel("Rodzaj automatu:");
        widthLabel = new JLabel("Szerokość:");
        heightLabel = new JLabel("Wysokość:");

        typeGroup = new ButtonGroup();

        wwRadioButton = new JRadioButton("WireWorld", true);
        wwRadioButton.setActionCommand("WireWorld");
        typeGroup.add(wwRadioButton);

        golRadioButton = new JRadioButton("Game of Life", false);
        golRadioButton.setActionCommand("Game of Life");
        typeGroup.add(golRadioButton);

        createButton = new JButton("Generuj pustą planszę");
        createButton.addActionListener(event -> {
            try {
            Simulator frame = new Simulator(makeCA(widthTextField.getText(), heightTextField.getText()));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle(typeGroup.getSelection().getActionCommand());
            frame.setVisible(true);
            dispose();}
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });

        readButton = new JButton("Wczytaj z pliku");
        readButton.addActionListener(event -> {
            if ((file = chooseFile()) != null) {
                try {
                    Reader r = new Reader();
                    CellularAutomaton mode = r.getMode(file);
                    r.readFile(mode, file);
                    Simulator frame = new Simulator(mode);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setTitle(mode.getClass().getSimpleName());
                    frame.setVisible(true);
                    dispose();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(sizeLabel, new GBC(0, 0).setAnchor(GBC.CENTER).setInsets(25, 25, 10, 25));
        add(widthLabel, new GBC(1, 0).setAnchor(GBC.EAST).setInsets(25, 0, 10, 0));
        add(widthTextField, new GBC(2, 0).setInsets(25, 0, 10, 12));
        add(heightLabel, new GBC(3, 0).setAnchor(GBC.EAST).setInsets(25, 0, 10, 0));
        add(heightTextField, new GBC(4, 0).setInsets(25, 0, 10, 25));
        add(typeLabel, new GBC(0, 1).setAnchor(GBC.CENTER).setInsets(10, 25, 10, 25));
        add(wwRadioButton, new GBC(1, 1, 2, 1).setInsets(0, 0, 0, 12));
        add(golRadioButton, new GBC(3, 1, 2, 1).setInsets(0, 0, 0, 25));
        add(createButton, new GBC(0, 2, 2, 1).setInsets(20, 25, 30, 25));
        add(readButton, new GBC(2, 2, 3, 1).setInsets(20, 25, 30, 25));

        pack();
        setLocationRelativeTo(null);
    }

    private File chooseFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("./cellgrids"));
        FileFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        chooser.setFileFilter(filter);
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION)
            return chooser.getSelectedFile();
        return null;
    }

    private CellularAutomaton makeCA(String x, String y) throws NumberFormatException {
        CellularAutomaton ca;
        String mode = typeGroup.getSelection().getActionCommand();
        if (mode.equalsIgnoreCase("WireWorld"))
            ca = new WireWorld();
        else
            ca = new GameOfLife();
        if (Integer.parseInt(x) <= 0 || Integer.parseInt(y) <= 0 || Integer.parseInt(x) > 300 || Integer.parseInt(x) > 300)
            throw new NumberFormatException("Podano złe wymiary! Wymiary powinny mieć od 0 do 300.");
        else
            ca.createEmptyGrid(Integer.parseInt(x), Integer.parseInt(y), ca);
        return ca;
    }
}
