import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DAOJSON implements DAO{
    @Override
    public ArrayList<Contact> load(String fichier) {
        return null;
    }

    @Override
    public void save(ArrayList<Contact> contacts) throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\Amaroke\\IdeaProjects\\addressbook\\contacts.json");

        Gson gson = new Gson();
        System.out.println(gson.toJson(contacts));
        writer.append("");
        writer.flush();
        writer.close();
    }
}
