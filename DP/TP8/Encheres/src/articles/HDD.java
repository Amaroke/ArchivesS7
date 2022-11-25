package articles;

public class HDD extends BasicComponent {
    private final int characteristic;

    public HDD(int price, int characteristic, String model, String constructor) {
        super(price, model, constructor);
        this.characteristic = characteristic;
    }

    @Override
    public void assignId(int id) {
        this.id = id;
    }

    public int inStock() {
        return inStock ? 1 : 0;
    }

    @Override
    public String getName() {
        return "HDD";
    }

    public String toString(int depth) {
        return this.getName() + " " + constructor + " " + model + " - " + characteristic + "G / " + (!inStock ? "sold / " : " " + price + " euros / ") + id;
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
