package GUI;

import Core.Cell;
import Core.InputOutput.Writer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;

abstract class Sidebar extends JPanel {
    private JTextField genTextField;
    private JTextField delayTextField;
    private JLabel genLabel;
    private JLabel delayLabel;
    private JLabel delayMsLabel;
    private JLabel genNumLabel;
    private JLabel cellDimLabel;
    private JButton genPlayButton;
    private JButton genStopButton;
    private JButton saveButton;
    private JSlider cellDimSlider;
    private Thread t;
    private File file;

    Sidebar(GridBagLayout layout, Simulator s) {

        KeyAdapter adapter = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE))
                    e.consume();
            }
        };

        setLayout(layout);

        genTextField = new JTextField("50", 5);
        delayTextField = new JTextField("1000", 5);

        genTextField.addKeyListener(adapter);
        delayTextField.addKeyListener(adapter);

        genLabel = new JLabel("Liczba generacji:");
        delayLabel = new JLabel("Opóźnienie:");
        delayMsLabel = new JLabel("ms");
        genNumLabel = new JLabel("Generacja #: 0");
        cellDimLabel = new JLabel("Wielkość komórki");

        genPlayButton = new JButton("Generuj!");
        genPlayButton.addActionListener(e -> {
            genPlayButton.setEnabled(false);
            genStopButton.setEnabled(true);
            saveButton.setEnabled(false);
            genTextField.setEnabled(false);
            delayTextField.setEnabled(false);
            Runnable run = () -> {
                try {
                    for (int i = 0; i < Integer.parseInt(genTextField.getText()); i++){
                        s.getMode().createNewGen();
                    s.reFreshBoard();
                    Thread.sleep(Integer.parseInt(delayTextField.getText()));}
                } catch (InterruptedException ignored) {
                }
            };
            t = new Thread(run);
            t.start();
        });

        genStopButton = new JButton("Stop");
        genStopButton.setEnabled(false);
        genStopButton.addActionListener(e -> {
            genPlayButton.setEnabled(true);
            genStopButton.setEnabled(false);
            saveButton.setEnabled(true);
            genTextField.setEnabled(true);
            delayTextField.setEnabled(true);
            t.interrupt();
        });

        saveButton = new JButton("Zapisz");
        saveButton.addActionListener(e -> {
            try {
                if ((file = chooseWriteFile()) != null) {
                    Writer w = new Writer();
                    w.writeToFile(s.getMode(), file);
                }
            } catch (FileNotFoundException ignored) {
            }

        });

        cellDimSlider = new JSlider(3, 40, 20);
        cellDimSlider.addChangeListener(event -> {
            JSlider source = (JSlider) event.getSource();
            s.setCellDim(source.getValue());
            s.reFreshBoard();
        });

        add(genLabel, new GBC(0, 0, 2, 1).setInsets(15, 10, 10, 0));
        add(genTextField, new GBC(2, 0).setInsets(15, 10, 10, 0));
        add(delayLabel, new GBC(0, 1, 2, 1).setInsets(15, 10, 10, 0));
        add(delayTextField, new GBC(2, 1).setInsets(15, 10, 10, 0));
        add(delayMsLabel, new GBC(3, 1).setInsets(15, 0, 10, 0).setAnchor(GBC.WEST));
        add(genPlayButton, new GBC(0, 2, 2, 1).setInsets(15, 10, 10, 0));
        add(genStopButton, new GBC(2, 2, 2, 1).setInsets(15, 10, 10, 0));
        add(genNumLabel, new GBC(0, 3, 4, 1).setInsets(5, 10, 10, 0));
        add(cellDimLabel, new GBC(0, 4, 4, 1).setInsets(15, 10, 5, 0));
        add(cellDimSlider, new GBC(0, 5, 4, 1).setInsets(0, 10, 5, 0));
        add(saveButton, new GBC(0, 12, 4, 1).setInsets(0, 0, 30, 0));

    }

    private File chooseWriteFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("./cellgrids"));
        chooser.setDialogTitle("Zapisz obecną generację");
        int result = chooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION)
            return chooser.getSelectedFile();
        return null;


    }

    public abstract Cell getPen();
}
