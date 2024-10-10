package weapons;

import components.Entity;

/**
 * Class representing axe implements {@link MeleeWeapon}, implemented abstract method
 * {@link Weapon#getDamage()}.
 *
 * @see MeleeWeapon
 * @see Weapon
 */
public class Axe implements MeleeWeapon {
  private static final int damage = 4;

  @Override
  public int getDamage() {
    return damage;
  }
}
