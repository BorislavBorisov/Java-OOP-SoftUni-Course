package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Scanner scanner = new Scanner(System.in);

        String string;

        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;
        Constructor<BlackBoxInt> declaredConstructor = blackBoxIntClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        BlackBoxInt blackBoxInt = declaredConstructor.newInstance();

        Method[] declaredMethods = blackBoxInt.getClass().getDeclaredMethods();

        while (!(string = scanner.nextLine()).equals("END")) {
            String[] tokens = string.split("_");

            Field declaredField = blackBoxInt.getClass().getDeclaredFields()[1];
            if (tokens[0].equals("add")) {
                for (Method declaredMethod : declaredMethods) {
                    declaredMethod.setAccessible(true);
                    if (declaredMethod.getName().equals("add")) {
                        declaredMethod.invoke(blackBoxInt, Integer.parseInt(tokens[1]));
                        declaredField.setAccessible(true);
                        System.out.println(declaredField.getInt(blackBoxInt));
                    }
                }
            } else if (tokens[0].equals("subtract")) {
                for (Method declaredMethod : declaredMethods) {
                    declaredMethod.setAccessible(true);
                    if (declaredMethod.getName().equals("subtract")) {
                        declaredMethod.invoke(blackBoxInt, Integer.parseInt(tokens[1]));
                        declaredField.setAccessible(true);
                        System.out.println(declaredField.getInt(blackBoxInt));
                    }
                }

            } else if (tokens[0].equals("multiply")) {
                for (Method declaredMethod : declaredMethods) {
                    declaredMethod.setAccessible(true);
                    if (declaredMethod.getName().equals("multiply")) {
                        declaredMethod.invoke(blackBoxInt, Integer.parseInt(tokens[1]));
                        declaredField.setAccessible(true);
                        System.out.println(declaredField.getInt(blackBoxInt));
                    }
                }

            } else if (tokens[0].equals("divide")) {
                for (Method declaredMethod : declaredMethods) {
                    declaredMethod.setAccessible(true);
                    if (declaredMethod.getName().equals("divide")) {
                        declaredMethod.invoke(blackBoxInt, Integer.parseInt(tokens[1]));
                        declaredField.setAccessible(true);
                        System.out.println(declaredField.getInt(blackBoxInt));
                    }
                }

            } else if (tokens[0].equals("leftShift")) {
                for (Method declaredMethod : declaredMethods) {
                    declaredMethod.setAccessible(true);
                    if (declaredMethod.getName().equals("leftShift")) {
                        declaredMethod.invoke(blackBoxInt, Integer.parseInt(tokens[1]));
                        declaredField.setAccessible(true);
                        System.out.println(declaredField.getInt(blackBoxInt));
                    }
                }

            } else if (tokens[0].equals("rightShift")) {
                for (Method declaredMethod : declaredMethods) {
                    declaredMethod.setAccessible(true);
                    if (declaredMethod.getName().equals("rightShift")) {
                        declaredMethod.invoke(blackBoxInt, Integer.parseInt(tokens[1]));
                        declaredField.setAccessible(true);
                        System.out.println(declaredField.getInt(blackBoxInt));
                    }
                }

            }
        }
    }
}
