import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    public T getRandomElement() {
        Random random = new Random();
        int i = random.nextInt(this.size());
        return this.remove(i);
    }
}
