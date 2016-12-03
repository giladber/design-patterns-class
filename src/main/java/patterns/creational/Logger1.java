package patterns.creational;

/**
 * Singleton
 * Created by giladrber on 12/3/2016.
 */
@FunctionalInterface
public interface Logger1 {

    /**
     * Write the input message to the logger's target file.
     * This method is guaranteed to be thread-safe by all implementations.
     * @param level
     * @param message
     */
    void log(String level, String message);

}
