package carte;

public abstract class ElementCarte extends Carte {

    private final String nom;
    private int prix;
    private final String chef;

    public ElementCarte(String nom, int prix, String chef, Carte cartePere) {
        this.nom = nom;
        this.prix = prix;
        this.chef = chef;
        this.cartePere = cartePere;
    }

    public int getPrix() {
        return prix;
    }

    public void ajouterPrix(int prix) {
        this.prix += prix;
    }

    public String getNom() {
        return this.nom;
    }

    public String getChef() {
        if (chef != null) {
            return chef;
        } else {
            return cartePere.getChef();
        }
    }

}
