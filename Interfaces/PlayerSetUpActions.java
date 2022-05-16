package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import javax.swing.JPanel;

import Controller.AppLogger;
import Views.Index;
import Model.PlayerPiece;

public interface PlayerSetUpActions {
    static AppLogger logr = AppLogger.getInstance();
    static String className = "MenuActions";
    static PlayerPiece player = PlayerPiece.getInstance();
    static PlayerPiece computer = PlayerPiece.getInstance();

    public class setRed(){
        
    }
}
