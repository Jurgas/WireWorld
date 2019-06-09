package GUI;

import java.awt.*;

class GBC extends GridBagConstraints {

    GBC(int gridx, int gridy) {
        this.gridx = gridx;
        this.gridy = gridy;
    }

    GBC(int gridx, int gridy, int gridwidth, int gridheight) {
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
    }

    GBC setAnchor(int anchor) {
        this.anchor = anchor;
        return this;
    }

    GBC setInsets(int top, int left, int bottom, int right) {
        this.insets = new Insets(top, left, bottom, right);
        return this;
    }

}
