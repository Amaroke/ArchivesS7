package carte;

import java.util.ArrayList;

public class SousCategorie extends Carte {

    private final ArrayList<Carte> cartes;
    private final String chef;
    private final String nom;

    public SousCategorie(String nom, String chef, Carte cartePere) {
        this.nom = nom;
        this.chef = chef;
        this.cartes = new ArrayList<>();
        this.cartePere = cartePere;
    }

    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder(this.nom + " (Chef: " + this.getChef() + ")" + "\n");
        for (Carte carte : cartes) {
            description.append(carte.getDescription()).append("\n");
        }
        return description.toString();
    }

    @Override
    public String getChef() {
        if (chef != null) {
            return chef;
        } else {
            return cartePere.getChef();
        }
    }

    public void ajouterCarte(Carte carte) {
        cartes.add(carte);
    }

}
