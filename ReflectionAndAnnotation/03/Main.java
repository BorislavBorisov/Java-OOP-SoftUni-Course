import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class<Reflection> reflectionClass = Reflection.class;
        Field[] declaredFields = Arrays.stream(reflectionClass.getDeclaredFields())
                .sorted(Comparator.comparing(Field::getName))
                .toArray(Field[]::new);

        for (Field declaredField : declaredFields) {
            if (!Modifier.isPrivate(declaredField.getModifiers())) {
                System.out.printf("%s must be private!%n", declaredField.getName());
            }
        }


        Method[] declaredMethods = reflectionClass.getDeclaredMethods();
        List<Method> getters = new ArrayList<>(0);
        List<Method> setters = new ArrayList<>(0);
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().startsWith("get")) {
                getters.add(declaredMethod);
            } else if (declaredMethod.getName().startsWith("set")) {
                setters.add(declaredMethod);
            }
        }
        getters.sort(Comparator.comparing(Method::getName));
        for (Method getter : getters) {
            if (!Modifier.isPublic(getter.getModifiers())) {
                System.out.printf("%s have to be public!%n",getter.getName());
            }
        }
        setters.sort(Comparator.comparing(Method::getName));
        for (Method setter : setters) {
            if (!Modifier.isPrivate(setter.getModifiers())) {
                System.out.printf("%s have to be private!%n" , setter.getName());
            }
        }

    }
}
