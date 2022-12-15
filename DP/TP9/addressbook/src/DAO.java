import java.io.IOException;
import java.util.ArrayList;

public interface DAO {
    ArrayList<Contact> load(String fichier);
    void save(ArrayList<Contact> contacts) throws IOException;
}
