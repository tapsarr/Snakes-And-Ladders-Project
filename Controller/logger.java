package Controller;

import java.util.logging.*;

public class logger {
    public static Logger logr;
    public static logger logger = null;
    private static String errorMSG = "Failed to Correctly log the message: ";

    private logger() {

        setupLogger();
    }

    private static void setupLogger() {
        logr = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        LogManager.getLogManager().reset();
        logr.setLevel(Level.ALL);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.WARNING);
        logr.addHandler(ch);

        try {
            System.out.println("entered");
            FileHandler fh = new FileHandler("Logs/all.log");
            fh.setFormatter(new SimpleFormatter());
            fh.setLevel(Level.FINE);
            logr.addHandler(fh);
        } catch (java.io.IOException e) {
            logr.log(Level.SEVERE, "File Logger Failed.", e);
        }
    }

    /**
     * Logger Levels in order:
     * 
     * OFF
     * 
     * SEVERE
     * 
     * WARNING
     * 
     * INFO
     * 
     * CONFIG
     * 
     * FINE
     * 
     * FINER
     * 
     * FINEST
     * 
     * ALL
     * 
     * 
     */

    public static void msgLog(int lvl, String message, Exception e, String className) {

        String msg = System.lineSeparator() + "\t" + "Class: " + className + System.lineSeparator() + "\tMessage: "
                + message;
        /*
         * Logging Levels Critical -> Good 7 -> SEVERE 6 -> WARNING 5 -> INFO 4 ->
         * CONFIG 3 -> FINE 2 -> FINER 1 -> FINEST
         */

        if (e != null) {
            msg = msg + System.lineSeparator() + "\tWith Exception: " + e;
            errorMSG = errorMSG + msg;
            switch (lvl) {
                case 1:
                    logr.finest(msg);
                    break;
                case 2:
                    logr.finer(msg);
                    break;
                case 3:
                    logr.fine(msg);
                    break;
                case 4:
                    logr.config(msg);
                    break;
                case 5:
                    logr.info(msg);
                    break;
                case 6:
                    logr.warning(msg);
                    break;
                case 7:
                    logr.severe(msg);
                    break;
                default:
                    logr.info(errorMSG);
                    break;
            }
        } else {
            msg = msg + System.lineSeparator() + "\tWithount any Exception.";
            switch (lvl) {
                case 1:
                    logr.finest(msg);
                    break;
                case 2:
                    logr.finer(msg);
                    break;
                case 3:
                    logr.fine(msg);
                    break;
                case 4:
                    logr.config(msg);
                    break;
                case 5:
                    logr.info(msg);
                    break;
                case 6:
                    logr.warning(msg);
                    break;
                case 7:
                    logr.severe(msg);
                    break;
                default:
                    logr.info(errorMSG);
                    break;
            }
        }
    }

    public static logger getInstance() {
        if (logger == null) {
            logger = new logger();
        }
        return logger;
    }
}