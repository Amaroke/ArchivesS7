import java.time.LocalDate;
import java.util.Calendar;

public class Main {
    public static void main (String[] args){
        Etudiant etudiant1 = new Etudiant("Dubois","Thierry", LocalDate.of(1999, Calendar.JULY, 6));
        Etudiant etudiant2 = new Etudiant("Martin", "Claire", LocalDate.of(1997, Calendar.JULY,6));
        Professeur professeur = new Professeur("Levy", "Jean", "Info", 250);
        Intervenant intervenant = new Intervenant("Bedos", "Martine", "Maths", 202);
        Promotion promotion = new Promotion("Master 1 2012-2013");
        promotion.ajouterEnseignant(professeur, intervenant);
        promotion.ajouterEtudiant(etudiant1, etudiant2);

        System.out.println(promotion);
        System.out.println(promotion.toStringMatieres());
    }
}