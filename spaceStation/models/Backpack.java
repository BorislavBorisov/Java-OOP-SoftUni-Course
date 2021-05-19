package spaceStation.models;

import spaceStation.models.bags.Bag;

import java.util.ArrayList;
import java.util.Collection;

public class Backpack implements Bag {
    private Collection<String> items;

    public Backpack() {
        this.items = new ArrayList<>();
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }
}
