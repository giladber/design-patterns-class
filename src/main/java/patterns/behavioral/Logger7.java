package patterns.behavioral;

/**
 * Null Object
 * Add a logger which will do nothing.
 * This logger will be used when no logger can be prepared using the input settings,
 * so that the user can still operate his program even if logger initialization failed.
 * Created by giladrber on 12/4/2016.
 */
public interface Logger7 {

    void log(String level, String message);
}
