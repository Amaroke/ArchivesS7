import java.io.IOException;
import java.util.ArrayList;

public class Carnet {

    private final ArrayList<Contact> contacts = new ArrayList<>();
    private final Format format;

    public Carnet() {
        format = Format.CSV;
        contacts.add(new Contact("Mathieu Steinbach", "Hugo", "email@email.com"));
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void afficherContacts() {
        for (int i = 0; i < contacts.size(); ++i) {
            System.out.println(i + ". " + contacts.get(i).toString());
        }
    }

    public void supprimerContact(int i) {
        contacts.remove(i);
    }

    public void modifierContact(int i, Contact contact) {
        contacts.remove(i);
        contacts.add(i, contact);
    }

    public void load(String fichier){
    }

    public void save(){
        try {
            Factory.getDAO(format).save(this.contacts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
