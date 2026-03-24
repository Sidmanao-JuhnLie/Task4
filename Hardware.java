public abstract class Hardware {
    private int id;
    private String brand;
    private int spec;

    public Hardware(int id, String brand, int spec) {
        this.id    = id;
        this.brand = brand;
        this.spec  = spec;
    }

    public abstract String getInterpretation();

    public int    getId()    { return id; }
    public String getBrand() { return brand; }
    public int    getSpec()  { return spec; }
}

