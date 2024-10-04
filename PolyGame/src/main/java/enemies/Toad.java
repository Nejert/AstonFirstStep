package enemies;

import components.Entity;

public class Toad extends Enemy {

    private final int INITIAL_HEALTH = 6;
    private final int INITIAL_DAMAGE = 1;
    private final int SUPERPOWER_CHANCE = 20;

    public Toad(String name) {
        super(name);
        this.damage = INITIAL_DAMAGE;
        this.health = INITIAL_HEALTH;
        this.chance = SUPERPOWER_CHANCE;
    }

    @Override
    public void uniqueAbility() {
    }

    @Override
    protected void performAbility() {
    }

    //has the ability to randomly instantly kill its enemy
    @Override
    public void attack(Entity entity) {
        if (this.isAlive()) {
            int temp = rd.nextInt(100);
            if (temp < chance) {
                entity.takeDamage(entity.getHealth());
                System.out.println(this.getClass().getSimpleName() + " " + name +
                        " killed instantly " + entity.getClass().getSimpleName() + " " + entity.getName());
            } else {
                super.attack(entity);
            }
            if (!entity.isAlive()) {
                System.out.println(entity.getClass().getSimpleName() + " " + entity.getName() + " is defeated");
            }
        }
    }
}
