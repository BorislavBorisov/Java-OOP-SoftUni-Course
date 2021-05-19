package spaceStation.models;

import spaceStation.models.BaseAstronaut;

public class Geodesist extends BaseAstronaut {
    private static final double OXYGEN = 50.0;

    public Geodesist(String name) {
        super(name,OXYGEN);
    }

    @Override
    public void breath() {
        
    }
}
