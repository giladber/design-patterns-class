package patterns.structural;

/**
 * Adapter
 * Created by giladrber on 12/3/2016.
 */
public interface Logger4 {

    /**
     * Log the given message with the input severity level, using the underlying log4j logger.
     * Calling class semantics must be kept as if this and implementing classes do not exist in the stack trace.
     * @param level
     * @param message
     */
    void log(String level, String message);
}
