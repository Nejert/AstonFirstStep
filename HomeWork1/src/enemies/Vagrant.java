package enemies;

import components.Entity;

public class Vagrant extends Enemy {

    private final int INITIAL_HEALTH = 8;
    private final int INITIAL_DAMAGE = 4;
    private final int HEALTH_DRAIN = 2;
    private final int SUPERPOWER_CHANCE = 20;

    public Vagrant(String name) {
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

    //has the ability to steal health
    @Override
    public void attack(Entity entity) {
        int temp = rd.nextInt(100);
        if (temp < chance) {
            entity.takeDamage(HEALTH_DRAIN);
            this.health += HEALTH_DRAIN;
            System.out.println(this.getClass().getSimpleName() + " " + name +
                    " steals " + entity.getClass().getSimpleName() + " " + entity.getName() + " health");
            System.out.println(entity.getClass().getSimpleName() + " " + entity.getName() +
                    " now has " + entity.getHealth() + " health");
        }
        super.attack(entity);
    }
}
