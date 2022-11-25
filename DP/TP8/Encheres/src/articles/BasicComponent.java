package articles;

public abstract class BasicComponent implements HardwareComponent {

    protected int id;
    protected boolean inStock;
    protected final float price;
    protected final String model;
    protected String constructor;

    public BasicComponent(float price, String model, String constructor) {
        this.id = -1;
        this.inStock = true;
        this.price = price;
        this.model = model;
        this.constructor = constructor;
    }

    @Override
    public void assignId(int id) {
        this.id = id;
    }

    public int inStock() {
        return inStock ? 1 : 0;
    }

    public void sell() {
        this.inStock = false;
    }

    public abstract String getName();

    public String getConstructor() {
        return constructor;
    }

    public void setConstructor(String constructor) {
        this.constructor = constructor;
    }

    public float getPrice() {
        return price;
    }
}
