package decorator;

import carte.Carte;

public class DecorateurSpeciale extends Decorateur {

    public DecorateurSpeciale(Carte carte) {
        super(carte);
    }

    public String getDescription() {
        return "****************************************************\n" + "***** *****\n" + "*** ***\n" + this.carte.getDescription() + "*** ***\n" + "***** *****\n" + "****************************************************";
    }

    public String getChef() {
        return carte.getChef();
    }

}
