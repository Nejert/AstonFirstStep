package heroes;

public class Archer extends Hero {

    private final int INITIAL_HEALTH = 7;
    private final int INITIAL_DAMAGE = 2;
    private final int INITIAL_ENERGY = 0;

    private boolean isInvulnerable;

    public Archer(String name) {
        super(name);
        this.health = INITIAL_HEALTH;
        this.damage = INITIAL_DAMAGE;
        this.energy = INITIAL_ENERGY;
        isInvulnerable = false;
    }

    //has the ability to become invulnerable
    @Override
    protected void performAbility() {
        isInvulnerable = true;
        System.out.println(this.getName() + " is now invulnerable to damage on next move");
    }

    @Override
    public void takeDamage(int damage) {
        if (!isInvulnerable) {
            super.takeDamage(damage);
        } else {
            isInvulnerable = false;
        }
    }
}
