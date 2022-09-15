import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Etudiant {

    private final String nom;
    private final String prenom;
    private final LocalDate dateNaissance;
    private final int noEtudiant;

    public Etudiant(String nom, String prenom, LocalDate dateDeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateDeNaissance;
        this.noEtudiant = FabriqueNoEtu.getInstance().getNo();
    }

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(dateNaissance, LocalDate.now());
    }

    @Override
    public String toString() {
        return "Étudiant " + this.nom + " " + this.prenom + " (noEt=" + this.noEtudiant + ") " + getAge() + " ans\n";
    }
}
