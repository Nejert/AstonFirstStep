package heroes;

public class Warrior extends Hero {

    private final int INITIAL_HEALTH = 10;
    private final int INITIAL_DAMAGE = 4;
    private final int INITIAL_ENERGY = 8;

    public Warrior(String name) {
        super(name);
        this.health = INITIAL_HEALTH;
        this.damage = INITIAL_DAMAGE;
        this.energy = INITIAL_ENERGY;
    }

    //has the ability to fly into rage
    @Override
    protected void performAbility() {
        damage += 1;
        System.out.println(getName() + " became furious and raised his damage. His damage now " + damage + " points");

    }
}
