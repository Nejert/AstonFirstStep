package heroes;

import weapons.MeleeWeapon;
import weapons.RangeWeapon;

/**
 * Class with overridden {@code performAbility()} to perform the ability to fly into rage
 * when {@code energy} reaches its maximum.
 *
 * @param <T> the type of weapon hero is equipped with.
 *            Warrior's weapon type can only be associated with {@link MeleeWeapon}s
 * @see Hero
 */
public class Warrior<T extends MeleeWeapon> extends Hero {

  private static final int INITIAL_HEALTH = 10;
  //private static final int INITIAL_DAMAGE = 4;
  private static final int INITIAL_ENERGY = 8;

  /**
   * Constructs a hero represents Warrior.
   *
   * @param name name of Warrior
   */
  public Warrior(String name, T weapon) {
    super(name);
    this.weapon = weapon;
    this.health = INITIAL_HEALTH;
    this.damage = weapon.getDamage();
    this.energy = INITIAL_ENERGY;
  }

  //has the ability to fly into rage
  @Override
  protected void performAbility() {
    damage += 1;
    System.out.println(
        getName() + " became furious and raised his damage. His damage now " + damage + " points");

  }
}
