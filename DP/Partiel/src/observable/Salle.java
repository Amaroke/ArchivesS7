package observable;

import carte.Carte;

public class Salle implements Observer {

    private String responsable;
    private Restaurant restaurant;

    public Salle(String responsable, Restaurant restaurant) {
        this.responsable = responsable;
        this.restaurant = restaurant;
    }

    public Carte getCarteCourante() {
        return this.restaurant.getCarteCourante();
    }

    public String afficherCarteCourante() {
        return this.restaurant.afficherCarteCourante();
    }

    @Override
    public void update() {
        if (restaurant.isCarteCouranteChange()) {
            this.afficherCarteCourante();
        }
    }
}
