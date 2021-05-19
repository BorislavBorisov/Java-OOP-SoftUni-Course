import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInput = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInput[1]),
                Double.parseDouble(carInput[2]),
                Double.parseDouble(carInput[3]));
        String[] truckInput = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInput[1]),
                Double.parseDouble(truckInput[2]),
                Double.parseDouble(truckInput[3]));
        String[] busInput = scanner.nextLine().split("\\s+");
        Bus bus = new Bus
                (Double.parseDouble(busInput[1]),
                        Double.parseDouble(busInput[2]),
                        Double.parseDouble(busInput[3]));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens[0].equals("Drive")) {
                if (tokens[1].equals("Car")) {
                    car.drive(Double.parseDouble(tokens[2]));
                } else if (tokens[1].equals("Truck")) {
                    truck.drive(Double.parseDouble(tokens[2]));
                } else if (tokens[1].equals("Bus")) {
                    bus.drive(Double.parseDouble(tokens[2]));
                }
            } else if (tokens[0].equals("Refuel")) {
                if (tokens[1].equals("Car")) {
                    car.refuel(Double.parseDouble(tokens[2]));
                } else if (tokens[1].equals("Truck")) {
                    truck.refuel(Double.parseDouble(tokens[2]));
                } else if (tokens[1].equals("Bus")) {
                    bus.refuel(Double.parseDouble(tokens[2]));
                }
            } else if (tokens[0].equals("DriveEmpty")) {
                bus.drive(Double.parseDouble(tokens[2]));
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}

