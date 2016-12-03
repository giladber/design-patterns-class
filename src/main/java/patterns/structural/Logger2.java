package patterns.structural;

/**
 * Decorator
 * Created by giladrber on 12/3/2016.
 */
public interface Logger2 {

    /**
     * Logs the input message (along with the input severity level) to the target file, as well as to the console.
     * @param level
     * @param message
     */
    void log(String level, String message);
}
