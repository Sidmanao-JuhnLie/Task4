public class Laptop extends Hardware {

    public Laptop(int id, String brand, int spec) {
        super(id, brand, spec);
    }

    @Override
    public String getInterpretation() {
        return getSpec() + "GB RAM";
    }
    }
