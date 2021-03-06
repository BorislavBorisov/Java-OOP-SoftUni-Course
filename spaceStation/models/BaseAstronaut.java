package spaceStation.models;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.bags.Bag;

import java.util.ArrayList;

import static spaceStation.common.ExceptionMessages.*;
public abstract class BaseAstronaut implements Astronaut {
    private String name;
    private double oxygen;
    private Bag bag;

    public BaseAstronaut(String name, Double oxygen) {
        setName(name);
        setOxygen(oxygen);
        this.bag = new Backpack();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    public void setOxygen(Double oxygen) {
        if(oxygen < 0) {
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public boolean canBreath() {
        return getOxygen() > 0;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {
      this.oxygen -= 10;
      if(this.oxygen < 0) {
          this.setOxygen(0.0);
      }
    }
}
