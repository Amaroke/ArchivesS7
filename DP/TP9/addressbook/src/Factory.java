public class Factory {

    private static Factory instance;

    public static DAO getDAO(Format format) {
        switch (format) {
            case JSON -> {
                return new DAOJSON();

            }
            case SQL -> {
                return new DAOSQL();
            }
            default -> {
                return new DAOCSV();
            }
        }
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

}
