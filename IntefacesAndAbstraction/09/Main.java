import Person.Birthable;
import Person.Citizen;
import Person.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;

        List<Birthable> birthdayList = new ArrayList<>();

        while (!(line = scanner.nextLine()).equals("End")) {
            String[] tokens = line.split("\\s+");
            if (tokens[0].equals("Citizen")) {
                Citizen citizen = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                birthdayList.add(citizen);
            } else if (tokens[0].equals("Pet")) {
                Pet pet = new Pet(tokens[1], tokens[2]);
                birthdayList.add(pet);
            }
        }
        String date = scanner.nextLine();

        for (Birthable birthable : birthdayList) {
            if (birthable.getBirthDate().endsWith(date)) {
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}

