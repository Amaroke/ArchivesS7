package articles;

public class MotherBoard extends HardwareAssembly {
    public MotherBoard(int price, String model, String constructor) {
        super(price, model, constructor);
    }

    @Override
    public String getName() {
        return "MotherBoard";
    }

    @Override
    public int getNbComponents() {
        return this.inStock();
    }

    @Override
    public String getDescription() {
        return this.toString(0);
    }
}
