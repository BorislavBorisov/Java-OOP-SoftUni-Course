package models.fish;

public class SaltwaterFish extends BaseFish {
    private static final int FISH_SIZE = 5;

    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        super.setSize(FISH_SIZE);
    }
    @Override
    public void eat() {
        int currentSize = super.getSize();
        currentSize += 2;
        super.setSize(currentSize);
    }
}
