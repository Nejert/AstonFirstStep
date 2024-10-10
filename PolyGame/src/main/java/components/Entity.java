package components;

import lombok.Getter;
import weapons.Weapon;

/**
 * Abstract class representing an entity and implementing the {@link Mortal} interface.
 *
 * @see Mortal
 */
public abstract class Entity implements Mortal {
  protected int damage;
  @Getter
  protected int health;
  @Getter
  protected String name;

  public Entity(String name) {
    this.name = name;
  }

  /**
   * Method that allows {@link Entity} to take damage.
   *
   * @param damage amount of damage taken
   */
  public void takeDamage(int damage) {
    health -= damage;
    if (health < 0) {
      health = 0;
    }
  }

  /**
   * Method that allows attacking another entity.
   *
   * @param entity entity to be attacked
   */
  public void attack(Entity entity) {
    if (this.isAlive()) {
      if (entity.isAlive()) {
        System.out.println(this.getClass().getSimpleName() + " " + name + " attacks "
            + entity.getClass().getSimpleName() + " " + entity.getName());
        entity.takeDamage(damage);
        System.out.println(entity.getClass().getSimpleName() + " " + entity.getName() + " has "
            + entity.getHealth() + " health points");
      }
      if (!entity.isAlive()) {
        System.out.println(
            entity.getClass().getSimpleName() + " " + entity.getName() + " is defeated");
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
