package Assets;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controller.AppLogger;
import Interfaces.MenuActions;
import Views.Index;

/**
 * Creating the Main Menu Bar.
 * <p>
 * <b> Needs {@link NewProducer New Producer}</b>
 * <p>
 * <b> Needs {@link AppLogger AppLogger}</b>
 * <p>
 * 
 * @see javax.swing.JMenu
 * @see javax.swing.JMenuBar
 * @see javax.swing.JMenuItem
 * @see java.awt.event
 * 
 * @author Psarris Anastasios
 * @author Kolokouris Charalabos
 * @version 1.0, 14 May 2022
 */

public class MainMenu extends JMenuBar implements MenuActions {

    public Index jf;

    public JMenu gameMenu = new JMenu("Game");
    public JMenu optionsMenu = new JMenu("Options");
    public JMenu historyMenu = new JMenu("History");
    public JMenu helpMenu = new JMenu("Help");

    public JMenuItem newGameItem;
    public JMenuItem restartGameItem;
    public JMenuItem exitItem;
    public JMenuItem showHistoryItem;
    public JMenuItem hideHistoryItem;
    public JMenuItem aboutItem;

    static AppLogger logr = AppLogger.getInstance();

    /**
     * Starting up the MainMenu Bar
     */
    public MainMenu() {

        initComp();
    }

    private void creatingItems() {
        newGameItem = new JMenuItem(new newGame());
        restartGameItem = new JMenuItem(new restartGame());
        exitItem = new JMenuItem(new exitGame());
        showHistoryItem = new JMenuItem(new ShowHistory());
        hideHistoryItem = new JMenuItem(new HideHistory());
        aboutItem = new JMenuItem(new About());
    }

    private void initComp() {
        creatingItems();

        gameMenu.setMnemonic(KeyEvent.VK_G);
        historyMenu.setMnemonic(KeyEvent.VK_H);
        helpMenu.setMnemonic(KeyEvent.VK_F1);


        this.gameMenu.add(newGameItem);
        this.gameMenu.add(restartGameItem);
        this.gameMenu.add(exitItem);
        this.add(gameMenu);

        this.historyMenu.add(showHistoryItem);
        this.historyMenu.add(hideHistoryItem);
        this.add(historyMenu);

        this.helpMenu.add(aboutItem);
        this.add(helpMenu);
    }
}