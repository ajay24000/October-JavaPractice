package Week2;

public class DatabaseLogging implements Logger {


    @Override
    public void logInfo(String message) {
        logToDatabase("INFO: " + message);
    }

    @Override
    public void logWarning(String message) {
        logToDatabase("WARNING: " + message);
    }

    @Override
    public void logError(String message) {
        logToDatabase("ERROR: " + message);
    }

    private void logToDatabase(String logMessage) {

        System.out.println("Logging to database: " + logMessage);
    }

    public static void main(String[] args) {
        Logger databaseLogger = new DatabaseLogging();

        databaseLogger.logInfo("This is an informational message.");
        databaseLogger.logWarning("This is a warning message.");
        databaseLogger.logError("This is an error message.");
    }

}
