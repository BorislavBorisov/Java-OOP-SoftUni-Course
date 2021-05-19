package collections;

public class AddRemoveCollection extends Collection implements AddRemovable {
    @Override
    public String remove() {
        return super.remove(true);
    }

    @Override
    public int add(String str) {
        return super.add(str, false);
    }
}
