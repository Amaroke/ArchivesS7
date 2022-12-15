package decorator;

import carte.Carte;

public abstract class Decorateur extends Carte {

    Carte carte;

    public Decorateur(Carte carte) {
        this.carte = carte;
    }


}
