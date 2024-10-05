package heroes;

/**
 * Class with overridden {@code performAbility()} to perform the ability to heal himself
 * when {@code energy} reaches its maximum.
 *
 * @see Hero
 */
public class Mage extends Hero {

  private static final int INITIAL_HEALTH = 5;
  private static final int INITIAL_DAMAGE = 1;
  private static final int INITIAL_ENERGY = 5;

  /**
   * Constructs a hero represents Mage.
   *
   * @param name name of Mage
   */
  public Mage(String name) {
    super(name);
    this.health = INITIAL_HEALTH;
    this.damage = INITIAL_DAMAGE;
    this.energy = INITIAL_ENERGY;
  }

  //has the ability to heal himself
  @Override
  public void performAbility() {
    this.health += 1;
    System.out.println(getName() + " heals and now has " + getHealth() + " health points");
  }
}
