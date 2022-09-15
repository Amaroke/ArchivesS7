public class Intervenant extends Enseignant {
    public Intervenant(String nom, String prenom, String matiere, int nbHeures) {
        super(nom, prenom, matiere, nbHeures);
        setSalaire(getSalaireHorraire()*getNbHeures());
    }
}
