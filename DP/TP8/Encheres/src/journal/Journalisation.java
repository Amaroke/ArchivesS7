package journal;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class Journalisation {

    private static Journalisation instance = null;
    final PrintWriter writer = new PrintWriter("journal.txt", StandardCharsets.UTF_8);

    public Journalisation() throws IOException {
    }

    public static Journalisation getInstance() throws IOException {
        if (instance == null) {
            instance = new Journalisation();
        }
        return instance;
    }

    public void writeJournal(String line) {
        writer.println(line);
    }

    public void closeJournal() {
        writer.close();
    }

}
