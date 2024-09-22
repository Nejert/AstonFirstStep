package heroes;

import components.Entity;

public abstract class Hero extends Entity {

    protected int energy;

    public Hero(String name) {
        super(name);
    }

    @Override
    public void uniqueAbility() {
        if (this.energy >= 10) {
            this.energy = 0;
            performAbility();
        }
    }

    @Override
    public void attack(Entity entity) {
        uniqueAbility();
        super.attack(entity);
        energy++;
    }
}
