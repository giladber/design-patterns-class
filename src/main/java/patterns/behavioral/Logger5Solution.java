package patterns.behavioral;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * We want a logger that is capable of logging to db, file, console, event manager, etc.
 * But we want this binding to be made at instantiation time.
 * To do that, we'll introduce a LogStrategy interface which will be passed at logger instantiation,
 * which will be responsible for handling the actual writing
 * Created by giladrber on 12/3/2016.
 */
public class Logger5Solution {

    private final LogStrategy strategy;

    public Logger5Solution(LogStrategy strategy) {
        this.strategy = strategy;
    }

    void log(String level, String msg) {
        this.strategy.log(level.toUpperCase() + ": " + msg);
    }

    public interface LogStrategy {
        void log(String msg);
    }

    public class ToFile implements LogStrategy {

        private final PrintStream stream;

        public ToFile(File file) {
            try {
                this.stream = new PrintStream(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void log(String msg) {
            stream.println(msg);
        }
    }

    public class ToEventLog implements LogStrategy {

        @Override
        public void log(String msg) {
            //...
        }
    }
}
