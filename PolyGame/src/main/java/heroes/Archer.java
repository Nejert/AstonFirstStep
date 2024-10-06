package heroes;

import weapons.RangeWeapon;

/**
 * Class with overridden {@code performAbility()} to perform the ability to become invulnerable
 * when {@code energy} reaches its maximum.
 *
 * @param <T> the type of weapon hero is equipped with.
 *            Archer's weapon type can only be associated with {@link RangeWeapon}s
 * @see Hero
 */
public class Archer<T extends RangeWeapon> extends Hero {

  private static final int INITIAL_HEALTH = 7;
  //private static final int INITIAL_DAMAGE = 2;
  private static final int INITIAL_ENERGY = 0;

  private boolean isInvulnerable;

  /**
   * Constructs a hero represents Archer.
   *
   * @param name name of Archer
   */
  public Archer(String name, T weapon) {
    super(name);
    this.weapon = weapon;
    this.health = INITIAL_HEALTH;
    this.damage = weapon.getDamage();
    this.energy = INITIAL_ENERGY;
    isInvulnerable = false;
  }

  //has the ability to become invulnerable
  @Override
  protected void performAbility() {
    isInvulnerable = true;
    System.out.println(this.getName() + " is now invulnerable to damage on next move");
  }

  @Override
  public void takeDamage(int damage) {
    if (!isInvulnerable) {
      super.takeDamage(damage);
    } else {
      isInvulnerable = false;
    }
  }
}
