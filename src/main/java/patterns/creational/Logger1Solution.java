package patterns.creational;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Using holder-class-based idiom to implement Singleton pattern.
 * Also possible via a synchronized getLogger() method, or exposing the logger instance via an enum.
 * Created by giladrber on 12/3/2016.
 */
public class Logger1Solution{

    public Logger1 getLogger() {
        return Logger.INSTANCE;
    }

    private static final class Logger implements Logger1 {

        private static final Logger INSTANCE = new Logger();
        private final PrintStream writer;

        private Logger() {
            File target = new File(System.getProperty("logFile"));
            PrintStream p = System.out;

            try {
                p = new PrintStream(target);
            } catch (FileNotFoundException e) {
                System.err.println("Failed to instantiate INSTANCE: " + e.getMessage() + ", instead printing to System.out");
                e.printStackTrace();
            }

            this.writer = p;
        }

        @Override
        public void log(String level, String message) {
            writer.println(level.toUpperCase() + ": " + message);
        }
    }

}
