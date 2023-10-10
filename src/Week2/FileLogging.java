package Week2;

import java.io.FileWriter;
import java.io.IOException;
public class FileLogging implements Logger {

    private String filePath;

    public FileLogging(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void logInfo(String message) {
        logToFile("INFO: " + message);
    }

    @Override
    public void logWarning(String message) {
        logToFile("WARNING: " + message);
    }

    @Override
    public void logError(String message) {
        logToFile("ERROR: " + message);
    }

    private void logToFile(String logMessage) {
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(logMessage + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Logger fileLogger = new FileLogging("C:\\Users\\U6074525\\OneDrive - Clarivate Analytics\\Desktop\\New folder\\data.txt");

        fileLogger.logInfo("This is an informational message.");
        fileLogger.logWarning("This is a warning message.");
        fileLogger.logError("This is an error message.");
    }
}
