package ferrari;

public class Ferrari implements Car {
    private static final String MODEL_NAME = "488-Spider";

    private String driverName;
    private String model;

    public Ferrari(String driverName) {
        this.driverName = driverName;
        this.model = MODEL_NAME;
    }

    @Override
    public String brakes() {
        return "Breaks!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",this.model,this.brakes(),this.gas(),this.driverName);
    }
}
