package articles;

public class Computer extends HardwareAssembly {
    public Computer(int price, String model, String constructor) {
        super(price, model, constructor);
    }

    @Override
    public String getName() {
        return "Computer";
    }

}
