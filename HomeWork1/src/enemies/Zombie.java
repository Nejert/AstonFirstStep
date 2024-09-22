package enemies;

public class Zombie extends Enemy {

    private final int INITIAL_HEALTH = 12;
    private final int INITIAL_DAMAGE = 3;
    private final int SUPERPOWER_CHANCE = 50;

    public Zombie(String name) {
        super(name);
        this.damage = INITIAL_DAMAGE;
        this.health = INITIAL_HEALTH;
        this.chance = SUPERPOWER_CHANCE;
    }

    //has the ability to randomly revive upon death
    @Override
    protected void performAbility() {
        if (!isAlive()) {
            health += INITIAL_HEALTH / 2;
            System.out.println(this.getClass().getSimpleName() + " " + name +
                    " resurrected with " + health + " health points");
        }
    }
}
