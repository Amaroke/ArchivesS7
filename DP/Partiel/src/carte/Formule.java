package carte;

import java.util.ArrayList;

public class Formule extends ElementCarte {

    private final ArrayList<Plat> plats = new ArrayList<>();

    public Formule(String nom, String chef, Carte cartePere) {
        super(nom, 0, chef, cartePere);
    }

    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder(this.getNom() + " (Chef: " + this.getChef() + "): " + this.getPrix() + " euros\n");
        for (Plat plat : plats) {
            description.append(plat.getDescription()).append("\n");
        }
        return description.toString();
    }


    public void ajouterPlat(Plat plat) {
        plats.add(plat);
        this.ajouterPrix(plat.getPrix());
    }

}
