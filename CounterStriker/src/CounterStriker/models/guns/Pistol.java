package CounterStriker.models.guns;

public class Pistol extends GunImpl {
    private static final int PISTOL_BULLETS = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }


    @Override
    public int fire() {
        int result = super.getBulletsCount() - PISTOL_BULLETS;
        super.setBulletsCount(Math.max(result, 0));
        return super.getBulletsCount() == 0 ? 0 : PISTOL_BULLETS;
    }
}
