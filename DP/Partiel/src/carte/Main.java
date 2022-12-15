package carte;

import decorator.DecorateurBraille;
import decorator.DecorateurSpeciale;

public class Main {

    public static void main(String[] args) {
        // Construction du carte principal
        SousCategorie carte = new SousCategorie("Carte de tous les jours", "Cyril Lignac", null);

        SousCategorie dejeuner = new SousCategorie("Déjeuner tranquille", null, carte);
        carte.ajouterCarte(dejeuner);
        SousCategorie dinner = new SousCategorie("Dinner romantique", null, carte);
        carte.ajouterCarte(dinner);

        SousCategorie pizzas = new SousCategorie("Pizza", "Luigi", dejeuner);
        dejeuner.ajouterCarte(pizzas);
        SousCategorie viandes = new SousCategorie("Viandes", "Ratatouille", dejeuner);
        dejeuner.ajouterCarte(viandes);
        SousCategorie desserts = new SousCategorie("Desserts", null, dejeuner);
        dejeuner.ajouterCarte(desserts);
        Plat couscous = new Plat("Couscous", 30, null, "semoule, legumes, viande", null, dejeuner);
        dejeuner.ajouterCarte(couscous);
        Formule formule = new Formule("Best of M1", null, dejeuner);
        dejeuner.ajouterCarte(formule);

        Plat pecheur = new Plat("Pizza pecheur", 10, "Mario", "poisson, capres, mozarela", null, formule);
        formule.ajouterPlat(pecheur);
        Plat cookie = new Plat("Cookie", 10, null, "chocolat, lait", null, formule);
        formule.ajouterPlat(cookie);

        Plat reine = new Plat("Pizza Reine", 10, null, "champignons, mozarela, jambon", "(vegetarien)", pizzas);
        pizzas.ajouterCarte(reine);
        Plat steak = new Plat("Steak", 20, "Alain Ducasse", "charolais", null, viandes);
        viandes.ajouterCarte(steak);
        Plat cake = new Plat("Pizza Reine", 10, null, "fromage, pate feuillete", "(vegetarien)", desserts);
        desserts.ajouterCarte(cake);

        //System.out.println(carte.getDescription());

        DecorateurSpeciale ds = new DecorateurSpeciale(carte);
        //System.out.println(ds.getDescription());

        DecorateurBraille db = new DecorateurBraille(carte);
        //System.out.println(db.getDescription());

        DecorateurSpeciale dsb = new DecorateurSpeciale(db);
        System.out.println(dsb.getDescription());
    }

}
