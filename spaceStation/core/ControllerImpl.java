package spaceStation.core;

import spaceStation.models.*;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.mission.Mission;
import spaceStation.models.planets.Planet;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ExceptionMessages.*;
import static spaceStation.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private AstronautRepository astronauts;
    private PlanetRepository planets;
    private Mission mission;
    private int planetsExplored;

    public ControllerImpl() {
        this.astronauts = new AstronautRepository();
        this.planets = new PlanetRepository();
        this.mission = new MissionImpl();
        this.planetsExplored = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                astronauts.add(astronaut);
                return String.format(ASTRONAUT_ADDED, type, astronautName);
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                astronauts.add(astronaut);
                return String.format(ASTRONAUT_ADDED, type, astronautName);
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                astronauts.add(astronaut);
                return String.format(ASTRONAUT_ADDED, type, astronautName);
            default:
                throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        this.planets.add(planet);
        for (String item : items) {
            planet.getItems().add(item);
        }
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronauts.findByName(astronautName);
        if (!astronauts.getModels().contains(astronaut)) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        astronauts.remove(astronaut);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet planet = this.planets.findByName(planetName);
        List<Astronaut> models = this.astronauts.getModels()
                .stream().filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toList());

        if (models.size() > 0) {
            long deadAstr = getAstronautsWithZeroOxygen(models);
            this.mission.explore(planet, models);

            this.planetsExplored++;

            return String.format(PLANET_EXPLORED, planetName, getAstronautsWithZeroOxygen(models) - deadAstr);

        } else {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
    }

    private long getAstronautsWithZeroOxygen(Collection<Astronaut> models) {
        return models.stream().filter(a -> !a.canBreath()).count();
    }


    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_PLANET_EXPLORED, this.planetsExplored)).append(System.lineSeparator());
        if (this.astronauts.getModels().size() > 0) {
            sb.append(REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
            for (Astronaut model : this.astronauts.getModels()) {
                sb.append(String.format(REPORT_ASTRONAUT_NAME, model.getName()))
                        .append(System.lineSeparator())
                        .append(String.format(REPORT_ASTRONAUT_OXYGEN, model.getOxygen()))
                        .append(System.lineSeparator());
                Collection<String> bagItems = model.getBag().getItems();
                if (bagItems.size() > 0) {
                    String joinedCollection = String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, model.getBag().getItems());
                    sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, joinedCollection)).append(System.lineSeparator());
                } else {
                    sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, "none")).append(System.lineSeparator());
                }
            }
        }
        return sb.toString().trim();
    }
}