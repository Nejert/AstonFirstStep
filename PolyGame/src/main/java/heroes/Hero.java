package heroes;

import components.Entity;
import lombok.Getter;
import weapons.Weapon;

/**
 * Class {@code Hero} is the root of Hero hierarchy.
 * Every class has {@code Object} as a superclass. All objects,
 * including arrays, implement the methods of this class.
 *
 * @see components.Entity
 * @see components.Mortal
 */
public abstract class Hero extends Entity {
  private static final int MAX_ENERGY = 10;

  protected int energy;
  @Getter
  protected Weapon weapon;

  public Hero(String name) {
    super(name);
  }

  @Override
  public void uniqueAbility() {
    if (this.energy >= MAX_ENERGY) {
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
