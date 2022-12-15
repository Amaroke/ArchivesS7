package carte;

public class Plat extends ElementCarte {

    private final String ingredients;
    private final String description;

    public Plat(String nom, int prix, String chef, String ingredients, String description, Carte cartePere) {
        super(nom, prix, chef, cartePere);
        this.ingredients = ingredients;
        this.description = description;
    }

    @Override
    public String getDescription() {
        return this.getNom() + " (Chef: " + this.getChef() + "): " + this.getPrix() + " euros\n" + "   " + this.ingredients + " " + ((this.description == null) ? "" : this.description);
    }
}
