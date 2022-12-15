package decorator;

import carte.Carte;

public class DecorateurBraille extends Decorateur {

    public DecorateurBraille(Carte carte) {
        super(carte);
    }

    public String getDescription() {
        return this.toBraille(this.carte.getDescription());
    }

    @Override
    public String getChef() {
        return carte.getChef();
    }

    private String toBraille(String description) {
        return "..::...:..::.::...::..\n" +
                ".::....::....::.::::.::.\n" +
                "..::.::..::...\n" +
                ".:..:..::....:..:..:\n" +
                "...\n";
    }

}
