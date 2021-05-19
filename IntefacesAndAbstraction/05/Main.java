import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();

        Identifiable current;
        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            if (tokens.length == 3) {
                current = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            } else {
                current = new Robot(tokens[1],tokens[0]);
            }
            identifiables.add(current);

            line = scanner.nextLine();
        }

        String fakeId = scanner.nextLine();

        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(fakeId)) {
                System.out.println(identifiable.getId());
            }
        }


    }
}
