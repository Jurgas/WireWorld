package GUI;

import Core.Cell;
import Core.WwCells.Conductor;
import Core.WwCells.Empty;
import Core.WwCells.Head;
import Core.WwCells.Tail;

import javax.swing.*;
import java.awt.*;

public class WwSidebar extends Sidebar {

    private JRadioButton emptyCell;
    private JRadioButton conductorCell;
    private JRadioButton headCell;
    private JRadioButton tailCell;
    private ButtonGroup groupCell;
    private JLabel blueprintLabel;
    private JComboBox<String> blueprintsComboox;

    WwSidebar(GridBagLayout layout, Simulator s) {
        super(layout, s);
        setLayout(layout);

        groupCell = new ButtonGroup();

        emptyCell = new JRadioButton("Gumka", true);
        emptyCell.setActionCommand("Empty");
        groupCell.add(emptyCell);

        conductorCell = new JRadioButton("Przewodnik", false);
        conductorCell.setActionCommand("Conductor");
        groupCell.add(conductorCell);

        headCell = new JRadioButton("Głowa elek.", false);
        headCell.setActionCommand("Head");
        groupCell.add(headCell);

        tailCell = new JRadioButton("Ogon elek.", true);
        tailCell.setActionCommand("Tail");
        groupCell.add(tailCell);

        blueprintLabel = new JLabel("Wklej:");

        blueprintsComboox = new JComboBox<>();
        blueprintsComboox.addItem("");
        blueprintsComboox.addItem("OR");
        blueprintsComboox.addItem("AND");


        add(emptyCell, new GBC(0, 6, 3, 1).setAnchor(GBC.WEST).setInsets(30, 30, 0, 0));
        add(conductorCell, new GBC(0, 7, 3, 1).setAnchor(GBC.WEST).setInsets(5, 30, 0, 0));
        add(headCell, new GBC(0, 8, 3, 1).setAnchor(GBC.WEST).setInsets(5, 30, 0, 0));
        add(tailCell, new GBC(0, 9, 3, 1).setAnchor(GBC.WEST).setInsets(5, 30, 20, 0));
        add(blueprintLabel, new GBC(0, 10).setAnchor(GBC.EAST).setInsets(10, 10, 180, 0));
        add(blueprintsComboox, new GBC(1, 10, 2, 1).setAnchor(GBC.WEST).setInsets(10, 0, 180, 0));
    }

    public Cell getPen() {
        if (groupCell.getSelection().getActionCommand().equals("Empty"))
            return new Empty();
        else if (groupCell.getSelection().getActionCommand().equals("Head"))
            return new Head();
        else if (groupCell.getSelection().getActionCommand().equals("Tail"))
            return new Tail();
        else
            return new Conductor();
    }
}
