package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.AppLogger;

public class PlayerSetUp extends JFrame {
    public String titleStr = "Player Set Up";
    int windowWidth = 400;
    int windowHeight = 200;
    JPanel mainPanel = new JPanel();
    static AppLogger logr = AppLogger.getInstance();

    private void PlayerSetUp() {
        super.setTitle(titleStr);
        initComp();
    }

    private void initComp() {

        mainPanel();
        lastSteps();
    }

    private void lastSteps() {
        pack();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(windowWidth, windowHeight);
        this.setVisible(true);
    }

    private void mainPanel() {
        JPanel mP = new JPanel(new GridLayout(3, 1));
        //Name Field
        JPanel namePanel = new JPanel(new GridLayout(2, 1));
        JLabel nameLabel = new JLabel("Player Name:");
        JTextField nameField = new JTextField();
        //addPlaceHolder(nameField, "Name");
    }

}
