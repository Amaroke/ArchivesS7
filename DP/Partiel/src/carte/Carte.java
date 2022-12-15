package carte;

public abstract class Carte {

    Carte cartePere; // Pour ChainOfResponsability

    public abstract String getDescription();

    public abstract String getChef();
}
