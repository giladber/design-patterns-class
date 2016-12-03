package patterns.structural;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implement my own "logging" solution based on log4j
 * Implementation detail of underlying library is hidden from user (other than by compile-time dependency)
 * This class is a bridge between my API and the log4j api
 * Created by giladrber on 12/3/2016.
 */
public class Logger4Solution implements Logger4 {

    private final Logger logger = LoggerFactory.getLogger(Logger4Solution.class);

    @Override
    public void log(String level, String message) {
        switch(level.toUpperCase()) {
            case "TRACE":
                logger.trace(message);
                break;
            case "DEBUG":
                logger.debug(message);
                break;
            case "INFO":
                logger.info(message);
                break;
            case "WARNING":
            case "WARN":
                logger.warn(message);
                break;
            case "ERROR":
            case "FATAL":
                logger.error(message);
                break;
            default:
                logger.debug(level.toUpperCase() + ": " + message);
        }
    }
}
