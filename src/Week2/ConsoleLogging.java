package Week2;

public class ConsoleLogging implements Logger {
    @Override
    public void logInfo(String message) {
        System.out.println("INFO: " + message);
    }

    @Override
    public void logWarning(String message) {
        System.out.println("WARNING: " + message);
    }

    @Override
    public void logError(String message) {
        System.err.println("ERROR: " + message);
    }

    public static void main(String[] args) {
        Logger console = new ConsoleLogging();
        console.logInfo("This is an informational message.");
        console.logWarning("This is an warning message.");
        console.logError("This is an error message.");
    }
}
