package articles;

public interface HardwareComponent {

    void assignId(int id);

    int inStock();

    void sell();

    String toString(int depth);

    String getConstructor();

    float getPrice();

    void setConstructor(String constructor);

}
