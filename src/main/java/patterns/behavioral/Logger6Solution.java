package patterns.behavioral;

import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by giladrber on 12/3/2016.
 */
public class Logger6Solution implements Logger6 {
    @Override
    public UUID log(String level, String msg) {
        return null;
    }

    @Override
    public void undo(UUID uuid) {

    }

    public static class WriteCommand {
        private final UUID uuid;
        private final Path target;
        private final String content;

        public WriteCommand(UUID uuid, String content, Path target) {
            this.content = content;
            this.uuid = uuid;
            this.target = target;
        }

        public void execute(Logger logger) {
            logger.info("["+ uuid.toString() + "] " + content);
        }

        /**
         * This is pretty terrible =[
         * @throws IOException
         */
        public synchronized void undo() throws IOException {
            String filtered = Files.readAllLines(target).stream()
                    .filter(s -> !s.contains(content) && !s.startsWith(uuid.toString()))
                    .collect(Collectors.joining("\n"));

            Files.write(target, filtered.getBytes());
        }

        public UUID getUuid() {
            return uuid;
        }
    }
}
