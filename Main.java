
import Controller.AppLogger;
import Views.Index;
/**
 * 
 * Starting The App.
 * 
 * @author Psarris Anastasios
 * @author Kolokouris Charalabos
 * @version 1.0, 13 Oct 2021
 */
public class Main {
    static AppLogger logr = AppLogger.getInstance();

    /**
     * 
     * Strating The App
     * 
     */
    public static void main(String[] args) {
        logr.msgLog(6, "App Started", "main");

        Index.getInstance();

    }
}