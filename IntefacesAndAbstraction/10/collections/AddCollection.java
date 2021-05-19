package collections;

public class AddCollection extends Collection implements Addable {
    @Override
    public int add(String str) {
        return this.add(str, true);
    }
}
