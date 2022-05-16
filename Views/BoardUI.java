package Views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import Model.PlayerPiece;
import Model.Players;
import Model.Difficulty;
import Controller.AppLogger;

public class BoardUI extends JPanel {

    JButton[] tiles = new JButton[100];

    public BoardUI() {
        super(new GridLayout(10, 10));
        super.setBackground(Color.GRAY);
        
        for (int i = 0; i < 100; i++) {
            tiles[i].setText(String.valueOf(i));    
        }
        

    }
}
