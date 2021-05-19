package motocrossWorldChampionship.entities;

import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SpeedMotorcycle extends MotorcycleImpl {
    private static final int CUBIC_CENTIMETERS_DEFAULT = 125;

    public SpeedMotorcycle(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS_DEFAULT);
    }

    @Override
    public void setHorsePower(int horsePower) {
        if (horsePower < 50 || horsePower > 69) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
        super.setHorsePower(horsePower);
    }
}
