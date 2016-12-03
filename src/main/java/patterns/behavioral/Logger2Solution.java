package patterns.behavioral;

/**
 * Use decorator pattern to add functionality on top of an existing class,
 * without touching that class' functionality or inheriting from it (which would break encapsulation).
 * Created by giladrber on 12/3/2016.
 */
public class Logger2Solution implements Logger2 {
    private final Logger2 base;

    private Logger2Solution(Logger2 base) {
        this.base = base;
    }

    @Override
    public void log(String level, String message) {
        base.log(level, message);
        System.out.println(level.toUpperCase()+": "+message);
    }
}
