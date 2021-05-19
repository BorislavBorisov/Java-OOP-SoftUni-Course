package core;

import models.aquariums.*;
import models.decorations.*;
import models.fish.*;
import repositories.*;

import java.util.LinkedHashMap;
import java.util.Map;

import static common.ConstantMessages.*;
import static common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Map<String, Aquarium> aquariums;

    public ControllerImpl() {
        decorations = new DecorationRepository();
        aquariums = new LinkedHashMap<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        if (aquariumType.equals("FreshwaterAquarium")) {
            aquarium = new FreshwaterAquarium(aquariumName);
            this.aquariums.putIfAbsent(aquariumName, aquarium);
        } else if (aquariumType.equals("SaltwaterAquarium")) {
            aquarium = new SaltwaterAquarium(aquariumName);
            this.aquariums.putIfAbsent(aquariumName, aquarium);
        } else {
            throw new IllegalArgumentException(INVALID_AQUARIUM_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        if (type.equals("Ornament")) {
            this.decorations.add(new Ornament());
        } else if (type.equals("Plant")) {
            this.decorations.add(new Plant());
        } else {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        String msg;
        Decoration decoration = this.decorations.findByType(decorationType);

        if (decoration == null) {
            msg = String.format(NO_DECORATION_FOUND, decorationType);
            throw new IllegalArgumentException(msg);
        }

        Aquarium aquarium = this.aquariums.get(aquariumName);
        aquarium.addDecoration(decoration);
        this.decorations.remove(decoration);

        msg = String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
        return msg;
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Aquarium aquarium = this.aquariums.get(aquariumName);
        boolean isFreshWaterFish = false;
        boolean isSaltWaterFish = false;
        Fish fish;

        if (fishType.equals("FreshwaterFish")) {
            isFreshWaterFish = true;
            fish = new FreshwaterFish(fishName, fishSpecies, price);
        } else if (fishType.equals("SaltwaterFish")) {
            isSaltWaterFish = true;
            fish = new SaltwaterFish(fishName, fishSpecies, price);
        } else {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        aquarium.addFish(fish);

        if (aquarium.getClass().getSimpleName().contains("Fresh") && isFreshWaterFish) {
            return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
        } else if (aquarium.getClass().getSimpleName().contains("Salt") && isSaltWaterFish) {
            return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
        } else {
            return WATER_NOT_SUITABLE;
        }
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = this.aquariums.get(aquariumName);
        aquarium.feed();
        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = this.aquariums.get(aquariumName);
        double fishPrice = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double decorationsPrice = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        return String.format(VALUE_AQUARIUM, aquariumName, fishPrice + decorationsPrice);
    }

    @Override
    public String report() {
        StringBuilder out = new StringBuilder();

        for (Aquarium aquarium : aquariums.values()) {
            out.append(aquarium.getInfo()).append(System.lineSeparator());
        }

        return out.toString().trim();
    }
}
