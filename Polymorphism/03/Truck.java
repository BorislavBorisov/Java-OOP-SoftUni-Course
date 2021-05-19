import java.text.DecimalFormat;

public class Truck extends Vehicles {

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void refuel(double quantity) {
        super.setFuelQuantity(super.getFuelQuantity() + quantity * 0.95);
    }

    @Override
    protected void drive(double distance) {
        double fuelCost = (super.getFuelConsumption() + 1.6) * distance;
        if (fuelCost < super.getFuelQuantity()) {
            super.setFuelQuantity(super.getFuelQuantity() - fuelCost);
            DecimalFormat decimalFormat = new DecimalFormat("###.##");
            System.out.printf("Truck travelled %s km%n", decimalFormat.format(distance));
        } else {
            System.out.println("Truck needs refueling");
        }
    }
    @Override
    public String toString() {
        return String.format("Truck: %.2f", super.getFuelQuantity());
    }
}
