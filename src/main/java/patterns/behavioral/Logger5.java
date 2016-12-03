package patterns.behavioral;

import java.io.File;
import java.io.Writer;

/**
 * Strategy
 * Implement the Logger5 interface so that clients will be able to log to many different mediums.
 * What if we decide that the client doesn't need to know which medium he is logging to?
 * What if we only ask him to tell us once, at runtime (defer binding from compile-time to runtime)
 * Created by giladrber on 12/3/2016.
 */
public interface Logger5 {

    void logToFile(File file, String level, String msg);
    void logToWriter(Writer writer, String level, String msg);
    void logToDatabase(String level, String msg);
    void logToEventManager(String level, String msg);
}
