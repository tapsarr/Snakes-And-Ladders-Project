import Controller.AppLogger;
import Views.Index;

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