import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DAOCSV implements DAO {
    @Override
    public ArrayList<Contact> load(String fichier) {
        return null;
    }

    @Override
    public void save(ArrayList<Contact> contacts) throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\Amaroke\\IdeaProjects\\addressbook\\contacts.csv");

        for(Contact contact : contacts) {
            writer.append(contact.nom());
            writer.append(",");
            writer.append(contact.prenom());
            writer.append(",");
            writer.append(contact.mail());
            writer.append('\n');
        }
        writer.flush();
        writer.close();
    }
}
