package patterns.creational;

import patterns.behavioral.Logger5;

/**
 * Provide a way to get different *types* of loggers:
 *      A file-based logger
 *      DB-based logger (without impl)
 *      Eventlog-based logger (without impl, unless you're bored)
 *  From within one class, where there is no distinction between returned types to the user of this API.
 * Created by giladrber on 12/4/2016.
 */
public interface Logger9 {
    void log(String level, String message);
}
