package GUI;

import javax.swing.*;
import java.awt.*;

public class GolSidebar extends Sidebar {

    private JRadioButton deadCell;
    private JRadioButton aliveCell;
    private ButtonGroup groupCell;
    private JLabel blueprintLabel;
    private JComboBox<String> blueprintsComboox;

    public GolSidebar(GridBagLayout layout) {
        super(layout);
        setLayout(layout);

        groupCell = new ButtonGroup();

        deadCell = new JRadioButton("Martwa", true);
        deadCell.setActionCommand("Martwa");
        groupCell.add(deadCell);

        aliveCell = new JRadioButton("Żywa", false);
        aliveCell.setActionCommand("Żywa");
        groupCell.add(aliveCell);

        blueprintLabel = new JLabel("Wklej:");

        blueprintsComboox = new JComboBox<>();
        blueprintsComboox.addItem("");
        blueprintsComboox.addItem("Glider");
        blueprintsComboox.addItem("Frog");


        add(deadCell, new GBC(0, 6, 3, 2).setAnchor(GBC.WEST).setInsets(30, 30, 0, 0));
        add(aliveCell, new GBC(0, 8, 3, 2).setAnchor(GBC.WEST).setInsets(5, 30, 20, 0));
        add(blueprintLabel, new GBC(0, 10).setAnchor(GBC.EAST).setInsets(10, 10, 230, 0));
        add(blueprintsComboox, new GBC(1, 10, 2, 1).setAnchor(GBC.WEST).setInsets(10, 0, 230, 0));
    }

    public String getPen() {
        return groupCell.getSelection().getActionCommand();
    }
}
