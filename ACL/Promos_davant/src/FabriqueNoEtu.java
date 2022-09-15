public final class FabriqueNoEtu {
    private static final FabriqueNoEtu instance = new FabriqueNoEtu();
    private int no;

    public static FabriqueNoEtu getInstance() {
        return instance;
    }

    public int getNo() {
        no++;
        return no;
    }
}