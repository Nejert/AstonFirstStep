package enemies;

/**
 * Class with overridden {@code performAbility()}
 * to perform the ability to randomly revive upon death.
 */
public class Zombie extends Enemy {

  private static final int INITIAL_HEALTH = 12;
  private static final int INITIAL_DAMAGE = 3;
  private static final int SUPERPOWER_CHANCE = 50;

  /**
   * Constructs an enemy represents Zombie.
   *
   * @param name name of Zombie
   */
  public Zombie(String name) {
    super(name);
    this.damage = INITIAL_DAMAGE;
    this.health = INITIAL_HEALTH;
    this.chance = SUPERPOWER_CHANCE;
  }

  //has the ability to randomly revive upon death
  @Override
  protected void performAbility() {
    if (!isAlive()) {
      health += INITIAL_HEALTH / 2;
      System.out.println(this.getClass().getSimpleName() + " " + name
          + " resurrected with " + health + " health points");
    }
  }
}
