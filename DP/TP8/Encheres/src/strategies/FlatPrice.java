package strategies;

public class FlatPrice implements PriceStrategy {

    @Override
    public double calculatePrice(double initPrice, int nbComponents) {
        return initPrice;
    }

    @Override
    public String toString() {
        return "FlatPrice";
    }
}
