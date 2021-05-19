package collections;

public class MyListImpl extends Collection implements MyList {
    @Override
    public int getUsed() {
        return super.size();
    }

    @Override
    public String remove() {

        return super.remove(false);
    }

    @Override
    public int add(String str) {
        return super.add(str, false);
    }
}
