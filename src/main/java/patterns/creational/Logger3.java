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
     * @param props
     * @param msg
     */
    void log(LoggerProperties props, String msg);

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

        LoggerProperties(URL url, Level level, String format, String defaultFileLocation) {
            this.url = url;
            this.level = level;
            this.format = format;
            this.defaultFileLocation = defaultFileLocation;
        }

        public URL getUrl() {
            return url;
        }

        public Level getLevel() {
            return level;
        }

        public String getFormat() {
            return format;
        }

        public String getDefaultFileLocation() {
            return defaultFileLocation;
        }
    }

}
