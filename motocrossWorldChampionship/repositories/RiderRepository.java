package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RiderRepository implements Repository<Rider> {
    private Collection<Rider> data;

    public RiderRepository() {
        this.data = new ArrayList<>();
    }

    @Override
    public Rider getByName(String name) {
        Rider rider = null;
        for (Rider datum : data) {
            if (datum.getName().equals(name)) {
                rider = datum;
                break;
            }
        }
        return rider;
    }

    @Override
    public Collection<Rider> getAll() {
        return Collections.unmodifiableCollection(this.data);
    }

    @Override
    public void add(Rider model) {
        this.data.add(model);
    }

    @Override
    public boolean remove(Rider model) {
        return this.data.removeIf(r -> r.getName().equals(model.getName()));
    }
}
