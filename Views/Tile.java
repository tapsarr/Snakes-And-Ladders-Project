package Views;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JPanel;


public class Tile extends JPanel {

    private JPanel mainTilePanel = new JPanel();
    private static final Color BACKGROUNDDEFAULT = Color.WHITE;
    private static final Color TEXTDEFAULT = Color.BLACK;


    public Tile() {

        super.setBackground(BACKGROUNDDEFAULT);
        super.setSize(super.getSize().width-1, super.getSize().height - 1);
        


    }
}
