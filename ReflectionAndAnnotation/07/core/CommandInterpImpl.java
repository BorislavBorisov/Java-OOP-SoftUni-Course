package barracksWars.core;

import barracksWars.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpImpl implements CommandInterpreter {

    private static final String COMMAND_PACKAGE = "barracksWars.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {

        String command = getClassName(data[0]);
        Executable executable = null;

        try {
            Class clazz = Class.forName(COMMAND_PACKAGE + command);
            Constructor declaredConstructor =
                    clazz.getDeclaredConstructor(String[].class);

            executable = (Executable) declaredConstructor
                    .newInstance(
                            new Object[]{data});

            popDep(executable);

        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | InvocationTargetException
                | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return executable;
    }

    private void popDep(Executable executable) {
        Field[] exeFields = executable.getClass().getDeclaredFields();

        Field[] curClFields = this.getClass().getDeclaredFields();

        for (Field requiredField : exeFields) {
            Inject annotation = null;
            try {
                annotation = requiredField.getAnnotation(Inject.class);
            } catch (ClassCastException ex) {
                continue;
            }

            for (Field curClField : curClFields) {
                if (curClField.getType().equals(requiredField.getType())) {
                    requiredField.setAccessible(true);
                    try {
                        requiredField.set(executable, curClField.get(this));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    private String getClassName(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(name.charAt(0)));
        sb.append(name.substring(1));
        return sb.toString();

    }
}
