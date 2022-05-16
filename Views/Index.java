package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Assets.MainMenu;
import Controller.AppLogger;

/**
 * 
 * Setting up The Main Window.
 * <p>
 * <b> Needs {@link Views.Assets.MainMenu#MainMenu Menu}</b>
 * <p>
 * <b> Needs {@link AppLogger AppLogger}</b>
 * 
 * @author Psarris Anastasios
 * @version 1.0, 14 May 2022
 */
public class Index extends JFrame {
    
    public static Index indexInst = null;
    public String titleStr = "Snakes And Ladders";
    private MainMenu mainmenuBar = new MainMenu();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int windowWidth = screenSize.width ;
    int windowHeight = screenSize.height /2;
    JPanel mainPanel = new JPanel();
    static AppLogger logr = AppLogger.getInstance();

    private Index() {
        super.setTitle(titleStr);
        initComp();
    }

    private void initComp() {
        setPanel(backgroundPanel());
        this.add(mainPanel);
        this.setJMenuBar(mainmenuBar);
        lastSteps();
    }

    private void lastSteps() {
        pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(windowWidth, windowHeight);
        this.setVisible(true);

    }

    public void setPanel(JPanel panelToAdd) {

        mainPanel.removeAll();
        mainPanel = panelToAdd;
        this.repaint();
    }

    private JPanel backgroundPanel() {
        JPanel backPanel = new JPanel();
        backPanel.setSize(windowWidth, windowHeight);
        
        return backPanel;
    }

    public static Index getInstance() {
        if (indexInst == null) {
            indexInst = new Index();
        }
        return indexInst;
    }
}
