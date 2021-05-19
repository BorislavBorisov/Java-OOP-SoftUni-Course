import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInput = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]));
        String[] truckInput = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens[0].equals("Drive")) {
                if (tokens[1].equals("Car")) {
                    car.drive(Double.parseDouble(tokens[2]));
                } else {
                    truck.drive(Double.parseDouble(tokens[2]));
                }
            } else if (tokens[0].equals("Refuel")) {
                if (tokens[1].equals("Car")) {
                    car.refuel(Double.parseDouble(tokens[2]));
                } else {
                    truck.refuel(Double.parseDouble(tokens[2]));
                }
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}

