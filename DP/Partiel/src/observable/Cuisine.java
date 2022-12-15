package observable;

import carte.Carte;

import java.util.ArrayList;

public class Cuisine implements Observer {

    private String chef;
    private Restaurant restaurant;

    public Cuisine(String chef, Restaurant restaurant) {
        this.chef = chef;
        this.restaurant = restaurant;
    }

    public ArrayList<Carte> getCartes() {
        return restaurant.getCartes();
    }

    @Override
    public void update() {
        this.getCartes();
    }
}
