package weapons;

/**
 * Class representing sword implements {@link RangeWeapon}, implemented abstract method
 * {@link Weapon#getDamage()}.
 *
 * @see RangeWeapon
 * @see Weapon
 */
public class Wand implements RangeWeapon {
  private static final int damage = 2;

  @Override
  public int getDamage() {
    return damage;
  }
}
