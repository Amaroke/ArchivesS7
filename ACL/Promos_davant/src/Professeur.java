public class Professeur extends Enseignant {

    public Professeur(String nom, String prenom, String matiere, int nbHeures) {
        super(nom, prenom, matiere, nbHeures);
        setSalaire(24000+(getNbHeures()-200)*getSalaireHorraire());
    }


}
