package articles;

public class MotherBoard extends HardwareAssembly {
    public MotherBoard(int price, String model, String constructor) {
        super(price, model, constructor);
    }

    @Override
    public String getName() {
        return "MotherBoard";
    }


}
