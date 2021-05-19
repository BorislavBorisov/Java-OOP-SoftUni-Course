package spaceStation.models;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.mission.Mission;
import spaceStation.models.planets.Planet;

import java.util.ArrayDeque;
import java.util.Collection;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        ArrayDeque<String> plantItems = new ArrayDeque<>(planet.getItems());
        for (Astronaut astronaut : astronauts) {
            while (astronaut.getOxygen() != 0) {
                String item = plantItems.poll();
                if (item == null) {
                    return;
                }
                astronaut.getBag().getItems().add(item);
                astronaut.breath();
            }
        }
    }
}
