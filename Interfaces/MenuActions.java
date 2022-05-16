package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import javax.swing.JPanel;

import Controller.AppLogger;
import Views.BoardUI;
import Views.Index;
import Views.PlayerSetUp;
import Views.BoardUI;

/**
 * Main Menu Actions all in one file.
 * 
 * @see javax.swing.event
 * @see java.awt.event
 * 
 * @author Psarris Anastasios
 * @version 1.0, 14 May 2022
 */

public interface MenuActions {
    static AppLogger logr = AppLogger.getInstance();
    static String className = "MenuActions";
    static Index jfIndex = Index.getInstance();

    public class newGame extends AbstractAction {
        public newGame() {

            super("New Game");
            putValue(SHORT_DESCRIPTION, "Start A New Game");
            putValue(MNEMONIC_KEY, KeyEvent.VK_N);

        }

        public void actionPerformed(ActionEvent e) {

            String msg = "Entering: NewGame";
            logr.msgLog(4, msg, className);
            new PlayerSetUp();
            jfIndex.setPanel(new BoardUI());
            jfIndex.repaint();

        }
    }

    public class restartGame extends AbstractAction {
        public restartGame() {

            super("Restart Game");
            putValue(SHORT_DESCRIPTION, "Restart This Game");
            putValue(MNEMONIC_KEY, KeyEvent.VK_R);

        }

        public void actionPerformed(ActionEvent e) {

            String msg = "Entering: RestartGame";
            logr.msgLog(4, msg, className);

        }
    }

    public class exitGame extends AbstractAction {
        public exitGame() {

            super("Exit Game");
            putValue(SHORT_DESCRIPTION, "Exit Game");
            putValue(MNEMONIC_KEY, KeyEvent.VK_E);

        }

        public void actionPerformed(ActionEvent e) {

            String msg = "Entering: ExitGame";
            logr.msgLog(4, msg, className);
            System.exit(0);
        }
    }

    public class ShowHistory extends AbstractAction {
        public ShowHistory() {

            super("Show History");
            putValue(SHORT_DESCRIPTION, "Show the History of this Session");
            putValue(MNEMONIC_KEY, KeyEvent.VK_S);

        }

        public void actionPerformed(ActionEvent e) {

            String msg = "Entering: ShowHistory";
            logr.msgLog(4, msg, className);

        }
    }

    public class HideHistory extends AbstractAction {
        public HideHistory() {

            super("Hide History");
            putValue(SHORT_DESCRIPTION, "Hide the History of this Session");
            putValue(MNEMONIC_KEY, KeyEvent.VK_I);

        }

        public void actionPerformed(ActionEvent e) {

            String msg = "Entering: HideHistory";
            logr.msgLog(4, msg, className);

        }
    }

    public class About extends AbstractAction {
        public About() {

            super("About");
            putValue(SHORT_DESCRIPTION, "About This Game");
            putValue(MNEMONIC_KEY, KeyEvent.VK_A);

        }

        public void actionPerformed(ActionEvent e) {

            String msg = "Entering: About";
            logr.msgLog(4, msg, className);

        }
    }
}