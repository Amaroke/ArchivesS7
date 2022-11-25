package articles;

import java.text.DecimalFormat;

public class Processor extends BasicComponent {

    private final float characteristic;

    public Processor(int price, float characteristic, String model, String constructor) {
        super(price, model, constructor);
        this.characteristic = characteristic;
    }


    @Override
    public String getName() {
        return "Processor";
    }

    public String toString(int depth) {
        DecimalFormat df = new DecimalFormat("#");
        return this.getName() + " " + constructor + " " + model + " - " + ((characteristic % 1 == 0.0) ? df.format(characteristic) : characteristic) + "Ghz / " + (!inStock ? "sold / " : " " + price + " euros / ") + id;
    }

    @Override
    public int getNbComponents() {
        return 1;
    }

    @Override
    public String getDescription() {
        return this.toString(0);
    }

}
