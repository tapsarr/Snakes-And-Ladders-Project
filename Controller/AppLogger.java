package Controller;

import java.io.IOException;
import java.util.logging.*;

/**
 * The <b>AppLogger</b> object is used internally for logging messages to both
 * <i>Console</i> and <i>all.log</i> file.
 * <p>
 * It can be obtained by <b>inserting</b> the package with <br>
 * 
 * <pre>
 * {@code
 * import Controller.AppLogger;
 * }
 * </pre>
 * <p>
 * {@other
 * <ul>
 * <li><b><i><u>WARNING!!!</b></i></u> You have to:
 * <ul>
 * <li>get the instance
 * <li>log message
 * </ul>
 * </ul>
 * } {@sev
 * <ul>
 * <li><b>Severity Levels:</b>
 * <ul>
 * <li>1 Finest
 * <li>2 Finer
 * <li>3 Fine
 * <li>4 Config
 * <li>5 Info
 * <li>6 Warning
 * <li>7 Severe
 * </ul>
 * </ul>
 * }
 * 
 * @see #getInstance()
 * @see #msgLog()
 * 
 * @author Psarris Anastasios
 * @version 1.0, 14 May 2022
 */

public class AppLogger {

    public static Logger logr;
    public static AppLogger logger = null;
    private String errorMSG = "Failed to Correctly log the message: ";

    /**
     * It is used for initialing the logger.
     * 
     * @see #setupLogger
     */
    private AppLogger() {

        setupLogger();
    }

    /**
     * It is used only for setting up perposes
     * 
     * @throws IOException if cannot be reached or created.
     * @since 1.0
     * @see #AppLogger
     * @see java.util.logging.FileHandler
     * @see java.util.logging.Logger
     */
    private static void setupLogger() {

        logr = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        LogManager.getLogManager().reset();
        logr.setLevel(Level.ALL);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.WARNING);
        logr.addHandler(ch);

        try {
            // System.out.println("entered");
            FileHandler fh = new FileHandler("Logs/all.log");
            fh.setFormatter(new SimpleFormatter());
            fh.setLevel(Level.FINE);
            logr.addHandler(fh);
        } catch (java.io.IOException e) {
            logr.log(Level.SEVERE, "File Logger Failed.", e);
        }
    }

    /**
     * Used to log a message with an exception.
     * <p>
     * 
     * {@sev
     * <ul>
     * <li><b>Severity Levels:</b>
     * <ul>
     * <li>1 Finest
     * <li>2 Finer
     * <li>3 Fine
     * <li>4 Config
     * <li>5 Info
     * <li>6 Warning
     * <li>7 Severe
     * </ul>
     * </ul>
     * }
     * 
     * 
     * @param lvl       The Level of Severity.
     * @param message   The Message you want to be logged.
     * @param e         The Exception that occured.
     * @param className Where You Calling this from.
     * @see #logging
     */
    public void msgLog(int lvl, String message, Exception e, String className) {

        String msg = System.lineSeparator() + "\t" + "Class: " + className + System.lineSeparator() + "\tMessage: "
                + message;
        msg = msg + System.lineSeparator() + "\tWith Exception: " + e;
        errorMSG = errorMSG + msg;
        logging(lvl, msg, errorMSG);
    }

    /**
     * Used to log a message without any exceptions.
     * <p>
     * 
     * {@sev
     * <ul>
     * <li><b>Severity Levels:</b>
     * <ul>
     * <li>1 Finest
     * <li>2 Finer
     * <li>3 Fine
     * <li>4 Config
     * <li>5 Info
     * <li>6 Warning
     * <li>7 Severe
     * </ul>
     * </ul>
     * }
     * 
     * 
     * @param lvl       The Level of Severity.
     * @param message   The Message you want to be logged.
     * @param className Where You Calling this from.
     * @see #logging
     */
    public void msgLog(int lvl, String message, String className) {

        String msg = System.lineSeparator() + "\t" + "Class: " + className + System.lineSeparator() + "\tMessage: "
                + message;
        errorMSG = errorMSG + msg;
        logging(lvl, msg, errorMSG);
    }

    /**
     * 
     * @param lvl    Level of Severity {@link AppLogger.msgLog/}
     * @param msg    Message W/o Exception
     * @param errorM Message of Failure
     */

    private static void logging(int lvl, String msg, String errorM) {
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
                logr.info(errorM);
                break;
        }
    }

    /**
     * Checks if a Logger is already started.
     * <p>
     * If not, it calls {@link #AppLogger} to Start the logger.
     * <p>
     * 
     * @return {@link #AppLogger() a Logger}
     */
    public static AppLogger getInstance() {
        if (logger == null) {
            logger = new AppLogger();
        }
        return logger;
    }
}