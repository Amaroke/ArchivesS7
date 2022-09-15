import java.util.*;

public class Promotion {

    private final String nom;
    private final List<Enseignant> enseignants = new ArrayList<>();
    private final List<Etudiant> etudiants = new ArrayList<>();
    private final HashMap<String, ArrayList<Enseignant>> associations = new HashMap<>();

    public Promotion(String nom) {
        this.nom = nom;
    }

    public void ajouterEnseignant(Enseignant... enseignants) {
        for(Enseignant enseignant : enseignants) {
            if (!associations.containsKey(enseignant.getMatiere())) {
                associations.put(enseignant.getMatiere(), new ArrayList<>());
            }
            associations.get(enseignant.getMatiere()).add(enseignant);
            this.enseignants.add(enseignant);
        }
    }

    public void ajouterEtudiant(Etudiant... etudiant) {
        Collections.addAll(etudiants, etudiant);
    }

    public String toStringMatieres() {
        StringBuilder string = new StringBuilder("Promo " + this.nom + "\n");
        for(Map.Entry<String, ArrayList<Enseignant>> entry : associations.entrySet()) {
            string.append("Les intervenants en ").append(entry.getKey()).append(" :\n");
            for(Enseignant enseignant : entry.getValue()) {
                string.append(enseignant.toString());
            }
        }
        return string.toString();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Promo " + this.nom + "\n");
        string.append("Les étudiants :\n");
        for (Etudiant etudiant: etudiants) {
            string.append(etudiant.toString());
        }
        string.append("Les intervenants :\n");
        for (Enseignant enseignant: enseignants) {
            string.append(enseignant.toString());
        }
        return string.toString();
    }
}
