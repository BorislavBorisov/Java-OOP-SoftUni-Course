package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;

        Field[] declaredFields = richSoilLandClass.getDeclaredFields();

        while (!input.equals("HARVEST")) {
            for (Field declaredField : declaredFields) {
                String modName = Modifier.toString(declaredField.getModifiers());
                if (input.equals(modName) || input.equals("all")) {
                    System.out.printf("%s %s %s%n", modName, declaredField.getType().getSimpleName(), declaredField.getName());
                }
            }
            input = scanner.nextLine();
        }

    }
}
