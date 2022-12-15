package observable;

import carte.Carte;

import java.util.ArrayList;

public class Restaurant extends Observable {

    private ArrayList<Carte> cartes;
    private Carte carteCourante;
    private boolean isCarteCouranteChange;

    public void ajouterCarte(Carte carte) {
        this.cartes.add(carte);
        this.notifyObservers();
    }

    public void modifierCarteCourante(Carte carteCourante) {
        this.carteCourante = carteCourante;
        this.isCarteCouranteChange = true;
        this.notifyObservers();
        this.isCarteCouranteChange = false;
    }

    public void supprimerCarte(Carte carte) {
        this.cartes.remove(carte);
        this.notifyObservers();
    }

    public Carte getCarteCourante() {
        return this.carteCourante;
    }

    public String afficherCarteCourante() {
        return this.carteCourante.getDescription();
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    public boolean isCarteCouranteChange() {
        return isCarteCouranteChange;
    }
}
