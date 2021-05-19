package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String type;

        while (!(type = sc.nextLine()).equals("Beast!")) {
            String[] input = sc.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            String gender = input[2];

            try {
                Animal animal = Animal.createAnimal(type, name, age, gender);
                animals.add(animal);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
