package components;

public abstract class Entity implements Mortal {
    protected int damage;
    protected int health;
    protected String name;

    public Entity(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public void attack(Entity entity) {
        if (this.isAlive()) {
            if (entity.isAlive()) {
                System.out.println(this.getClass().getSimpleName() + " " + name + " attacks " + entity.getClass().getSimpleName() + " " + entity.getName());
                entity.takeDamage(damage);
                System.out.println(entity.getClass().getSimpleName() + " " + entity.getName() + " has " + entity.getHealth() + " health points");
            }
            if (!entity.isAlive()) {
                System.out.println(entity.getClass().getSimpleName() + " " + entity.getName() + " is defeated");
            }
        }
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    public abstract void uniqueAbility();
    protected abstract void performAbility();
}
