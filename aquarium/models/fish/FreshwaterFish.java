package models.fish;

public class FreshwaterFish extends BaseFish {
    private static final int FISH_SIZE = 3;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        super.setSize(FISH_SIZE);
    }

    @Override
    public void eat() {
        int currentSize = super.getSize();
        currentSize += 3;
        super.setSize(currentSize);
    }
}
