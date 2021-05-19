package spaceStation.models;

public class Meteorologist extends BaseAstronaut {
    private static final double OXYGEN = 90.0;

    public Meteorologist(String name) {
        super(name, OXYGEN);
    }
}
