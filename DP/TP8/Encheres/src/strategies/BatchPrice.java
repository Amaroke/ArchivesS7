package strategies;

public class BatchPrice implements PriceStrategy {

    @Override
    public double calculatePrice(double initPrice, int nbComponents) {
        if (nbComponents > 4) {
            return initPrice * 1.5;
        } else if (nbComponents > 2) {
            return initPrice * 1.25;
        } else {
            return initPrice;
        }
    }

    @Override
    public String toString() {
        return "ClosePrice";
    }
}
