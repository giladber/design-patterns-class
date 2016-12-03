package patterns.structural;

/**
 * Proxy
 * Implement a logger which flushes to file only every 1000 messages.
 * However, we may not flush to the file by ourselves - instead we may only rely on another,
 * existing logger, which is unaware of this functionality.
 * Created by giladrber on 12/4/2016.
 */
public interface Logger8 {
    void log(String level, String message);
}
