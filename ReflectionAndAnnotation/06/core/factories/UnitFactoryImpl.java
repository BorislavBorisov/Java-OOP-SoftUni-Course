package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import barracksWars.models.units.AbstractUnit;
import barracksWars.models.units.Gunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        try {
            Class<?> unit = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<?> constructor = unit.getConstructor();
            Object newInstance = constructor.newInstance();
            if (newInstance instanceof AbstractUnit) {
                return (Unit) newInstance;
            }
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("This type is not a Unit");

    }
}
