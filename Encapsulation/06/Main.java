import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String[] inputOfPersons = scanner.nextLine().split(";");
        Map<String, Person> people = new LinkedHashMap<>();
        for (String current : inputOfPersons) {
            String[] tokens = current.split("=");
            people.putIfAbsent(tokens[0], new Person(tokens[0], Double.parseDouble(tokens[1])));
        }

        String[] inputOfProducts = scanner.nextLine().split(";");
        Map<String, Product> products = new LinkedHashMap<>();
        for (String current : inputOfProducts) {
            String[] tokens = current.split("=");
            products.putIfAbsent(tokens[0], new Product(tokens[0], Double.parseDouble(tokens[1])));
        }

        String input;

        while (!(input = scanner.nextLine()).equals("END")) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];

            if (people.containsKey(personName) && products.containsKey(productName)) {
                Person person = people.get(personName);
                Product product = products.get(productName);
                person.buyProduct(product);
            }


        }
        for (Person value : people.values()) {
            System.out.println(value);
        }
    }

}
