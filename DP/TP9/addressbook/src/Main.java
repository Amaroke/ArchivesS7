import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Carnet carnet = new Carnet();
        boolean stop = false;
        Scanner scanner = new Scanner(System.in);
        while (!stop) {
            System.out.println("""
                    \nVeuillez choisir une option :
                    1. Ajouter un contact
                    2. Afficher les contacts
                    3. Supprimer un contact
                    4. Modifier un contact
                    5. Sauvegarder les contacts
                    6. Quitter l'application
                    """);
            System.out.print("Saisissez votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1 -> {
                    System.out.print("\nCréation d'un nouveau contact\nNom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("E-mail : ");
                    String email = scanner.nextLine();
                    carnet.addContact(new Contact(nom, prenom, email));
                }
                case 2 -> carnet.afficherContacts();
                case 3 -> {
                    carnet.afficherContacts();
                    System.out.print("Supprimer le contact n° ? ");
                    int i = scanner.nextInt();
                    scanner.nextLine();
                    carnet.supprimerContact(i);
                }
                case 4 -> {
                    carnet.afficherContacts();
                    System.out.print("Modifier le contact n° ? ");
                    int i = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\nModification d'un contact\nNom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("E-mail : ");
                    String email = scanner.nextLine();
                    carnet.modifierContact(i, new Contact(nom, prenom, email));
                }
                case 5 -> {
                    carnet.save();
                    System.out.println("Sauvegarde effectuée !\n");
                }
                case 6 -> stop = true;
            }
        }
    }
}
