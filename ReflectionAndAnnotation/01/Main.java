import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Scanner scanner = new Scanner(System.in);

        Class<Reflection> reflectionClass = Reflection.class;
        System.out.println(reflectionClass);
        System.out.println(reflectionClass.getSuperclass());

        Class<?>[] interfaces = reflectionClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Constructor<Reflection> constructor = reflectionClass.getDeclaredConstructor();
        Reflection reflection = constructor.newInstance();


        System.out.println(reflection);

    }
}
