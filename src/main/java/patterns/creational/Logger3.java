package patterns.creational;

import java.net.URL;

/**
 * Builder
 * Created by giladrber on 12/3/2016.
 */
public interface Logger3 {

    /**
     * Write a message with the given severity level to the log's target file.
     * This method is guaranteed to be thread-safe on all implementations.
     * @param level
     * @param msg
     */
    void log(Level level, String msg);

    enum Level {
        TRACE,
        DEBUG,
        INFO,
        WARNING,
        ERROR,
        FATAL;
    }

    final class LoggerProperties {
        private final URL url;
        private final Level level;
        private final String format;
        private final String defaultFileLocation;

        private LoggerProperties(URL url, Level level, String format, String defaultFileLocation) {
            this.url = url;
            this.level = level;
            this.format = format;
            this.defaultFileLocation = defaultFileLocation;
        }
    }

}
