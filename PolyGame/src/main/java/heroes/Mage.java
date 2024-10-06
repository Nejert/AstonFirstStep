package heroes;

import weapons.MeleeWeapon;
import weapons.RangeWeapon;

/**
 * Class with overridden {@code performAbility()} to perform the ability to heal himself
 * when {@code energy} reaches its maximum.
 *
 * @param <T> the type of weapon hero is equipped with.
 *            Mage's weapon type can only be associated with {@link RangeWeapon}s
 * @see Hero
 */
public class Mage<T extends RangeWeapon> extends Hero {

  private static final int INITIAL_HEALTH = 5;
  //private static final int INITIAL_DAMAGE = 1;
  private static final int INITIAL_ENERGY = 5;

  /**
   * Constructs a hero represents Mage.
   *
   * @param name name of Mage
   */
  public Mage(String name, T weapon) {
    super(name);
    this.weapon = weapon;
    this.health = INITIAL_HEALTH;
    this.damage = weapon.getDamage();
    this.energy = INITIAL_ENERGY;
  }

  //has the ability to heal himself
  @Override
  public void performAbility() {
    this.health += 1;
    System.out.println(getName() + " heals and now has " + getHealth() + " health points");
  }
}
