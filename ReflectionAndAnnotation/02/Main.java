import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class<Reflection> reflectionClass = Reflection.class;

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
            System.out.printf("%s will return %s %s%n", getter.getName(),
                    getter.getReturnType() == int.class ? "class" : "",
                    getter.getReturnType());

        }
        setters.sort(Comparator.comparing(Method::getName));
        for (Method setter : setters) {
            System.out.printf("%s and will set field of %s %s%n", setter.getName(),
                    setter.getReturnType() == int.class ? "class" : "",
                    setter.getParameterTypes()[0]);

        }

    }
}
