package weapons;

/**
 * Class representing sword implements {@link MeleeWeapon}, implemented abstract method
 * {@link Weapon#getDamage()}.
 *
 * @see MeleeWeapon
 * @see Weapon
 */
public class Sword implements MeleeWeapon {
  private static final int damage = 3;

  @Override
  public int getDamage() {
    return damage;
  }
}
