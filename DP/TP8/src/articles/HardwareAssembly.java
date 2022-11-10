package articles;

import java.util.ArrayList;

public abstract class HardwareAssembly extends BasicComponent implements HardwareComponent {
    private final ArrayList<HardwareComponent> components = new ArrayList<>();

    public HardwareAssembly(int price, String model, String constructor) {
        super(price, model, constructor);
    }

    public void addComponent(HardwareComponent component) {
        if (component.getConstructor() == null) {
            component.setConstructor(this.constructor);
        }
        this.components.add(component);
    }

    @Override
    public void assignId(int id) {
        this.id = id;
        int i = 1;
        for (HardwareComponent component : this.components) {
            component.assignId(id * 10 + i);
            i++;
        }
    }

    public void sell() {
        this.inStock = false;
        for (HardwareComponent component : components) {
            component.sell();
        }
    }

    public int inStock() {
        int inStock = this.inStock ? 1 : 0;
        for (HardwareComponent component : components) {
            inStock += component.inStock();
        }
        return inStock;
    }

    @Override
    public float getPrice() {
        float price = this.price;
        for (HardwareComponent component : components) {
            if (component.inStock() != 0) {
                price += component.getPrice();
            }
        }
        return price;
    }

    public String toString(int depth) {
        int inStock = this.inStock();
        StringBuilder stringBuilder = new StringBuilder(this.getName() + " " + constructor + " " + model + " / ");
        stringBuilder.append(inStock == 0 ? "sold / " : this.getPrice() + " euros " + "(" + inStock + " unsold components) / ");
        stringBuilder.append(id);
        for (HardwareComponent component : components) {
            stringBuilder.append("\n");
            stringBuilder.append("---".repeat(Math.max(0, depth + 1)));
            stringBuilder.append(" ").append(component.toString(depth + 1));
        }
        return stringBuilder.toString();
    }

    @Override
    public void setConstructor(String constructor) {
        this.constructor = constructor;
        for (HardwareComponent component : components) {
            if (component.getConstructor() == null) {
                component.setConstructor(this.constructor);
            }
        }
    }
}
