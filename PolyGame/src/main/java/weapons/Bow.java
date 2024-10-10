package weapons;

/**
 * Class representing bow implements {@link RangeWeapon}, implemented abstract method
 * {@link Weapon#getDamage()}.
 *
 * @see RangeWeapon
 * @see Weapon
 */
public class Bow implements RangeWeapon {
  private static final int damage = 3;

  @Override
  public int getDamage() {
    return damage;
  }
}
