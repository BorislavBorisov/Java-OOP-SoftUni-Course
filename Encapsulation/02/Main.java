import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String chickenName = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        Chicken chicken = new Chicken(chickenName, age);

        System.out.println(String.format("Chicken %s (%d) can produce %.2f eggs per day.",
                chickenName, age, chicken.productPerDay()));

    }
}
