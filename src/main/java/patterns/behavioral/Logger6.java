package patterns.behavioral;

import java.util.UUID;

/**
 * Command
 * Created by giladrber on 12/3/2016.
 */
public interface Logger6 {

    UUID log(String level, String msg);
    void undo(UUID uuid);
}
