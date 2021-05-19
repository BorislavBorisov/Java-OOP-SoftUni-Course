package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceRepository implements Repository<Race> {
    private Collection<Race> data;

    public RaceRepository() {
        this.data = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        Race race = null;
        for (Race datum : data) {
            if (race.getName().equals(name)) {
                race = datum;
            }
        }
        return race;
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.data);
    }

    @Override
    public void add(Race model) {
        this.data.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return this.data.removeIf(r -> r.getName().equals(model.getName()));
    }
}
