import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TrafficLights[] lights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(TrafficLights::valueOf).toArray(TrafficLights[]::new);

        int n = Integer.parseInt(scanner.nextLine());
        TrafficLights[] trafficLights = TrafficLights.values();
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < lights.length; i1++) {
                TrafficLights light = lights[i1];
                int nextIndex = light.ordinal() + 1;
                TrafficLights val = trafficLights[nextIndex % trafficLights.length];
                lights[i1] = val;
                System.out.print(val + " ");
            }
            System.out.println();
        }


    }
}
