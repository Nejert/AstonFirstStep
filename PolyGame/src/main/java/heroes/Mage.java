package heroes;

public class Mage extends Hero {

    private final int INITIAL_HEALTH = 5;
    private final int INITIAL_DAMAGE = 1;
    private final int INITIAL_ENERGY = 5;

    public Mage(String name) {
        super(name);
        this.health = INITIAL_HEALTH;
        this.damage = INITIAL_DAMAGE;
        this.energy = INITIAL_ENERGY;
    }

    //has the ability to heal himself
    @Override
    public void performAbility() {
        this.health += 1;
        System.out.println(getName() + " heals and now has " + getHealth() + " health points");
    }
}
