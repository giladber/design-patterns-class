package patterns.creational;

import java.net.URL;

/**
 * Created by giladrber on 12/3/2016.
 */
public class Logger3Solution implements Logger3 {

    @Override
    public void log(LoggerProperties props, String msg) {
        System.out.printf(props.getFormat(), props.getLevel(), msg);
    }

    public static final class LoggerPropertiesBuilder {
        private URL url;
        private Level level;
        private String format = "%s: %s";
        private String defaultFileLocation;

        private LoggerPropertiesBuilder() {}

        public static LoggerPropertiesBuilder newBuilder()  {return new LoggerPropertiesBuilder();}

        public LoggerPropertiesBuilder withUrl(URL url) {
            this.url = url;
            return this;
        }

        public LoggerPropertiesBuilder withLevel(Level level) {
            this.level = level;
            return this;
        }

        public LoggerPropertiesBuilder withFormat(String format) {
            this.format = format;
            return this;
        }

        public LoggerPropertiesBuilder withDefaultFileLocation(String defaultFileLocation) {
            this.defaultFileLocation = defaultFileLocation;
            return this;
        }

        public LoggerProperties build() {
            return new LoggerProperties(url, level, format, defaultFileLocation);
        }
    }
}
