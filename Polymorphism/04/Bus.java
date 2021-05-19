import java.text.DecimalFormat;

public class Bus extends Vehicles {
    private boolean isEmpty;

    public Bus(double fuelQuantity, double fuelConsumption, double capacity) {
        super(fuelQuantity, fuelConsumption, capacity);
        isEmpty = false;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    protected void refuel(double quantity) {
        if (quantity > 0) {
            if (quantity + super.getFuelQuantity() <= super.getCapacity()) {
                super.setFuelQuantity(super.getFuelQuantity() + quantity);
            } else {
                System.out.println("Cannot fit fuel in tank");
            }
        } else {
            System.out.println("Fuel must be a positive number");
        }
    }

    @Override
    protected void drive(double distance) {
        double fuelCost = 0;
        if (isEmpty) {
            fuelCost = super.getFuelConsumption() * distance;
        } else {
            fuelCost = (super.getFuelConsumption() + 1.4) * distance;
        }
        if (fuelCost > super.getFuelQuantity()) {
            System.out.println("Bus needs refueling");
        } else {
            super.setFuelQuantity(super.getFuelQuantity() - fuelCost);
            DecimalFormat decimalFormat = new DecimalFormat("###.##");
            System.out.printf("Bus travelled %s km%n", decimalFormat.format(distance));
        }
    }
    public String toString() {
        return String.format("Bus: %.2f", super.getFuelQuantity());
    }
}
