public abstract class Enseignant {

    private final String nom;
    private final String prenom;
    private final String matiere;
    private final int nbHeures;
    private float salaire;

    public Enseignant(String nom, String prenom, String matiere, int nbHeures) {
        this.nom = nom;
        this.prenom = prenom;
        this.matiere = matiere;
        this.nbHeures = nbHeures;
    }

    public int getSalaireHorraire() {
        return 30;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public int getNbHeures() {
        return nbHeures;
    }

    public String getMatiere() {
        return matiere;
    }

    @Override
    public String toString() {
        return this.prenom + " " + this.nom + " en " + this.matiere + ", salaire = " + this.salaire + "\n";
    }

}
