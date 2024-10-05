package enemies;

import components.Entity;

/**
 * Class with overridden {@code attack()} to perform the ability to steal health.
 */
public class Vagrant extends Enemy {

  private static final int INITIAL_HEALTH = 8;
  private static final int INITIAL_DAMAGE = 4;
  private static final int HEALTH_DRAIN = 2;
  private static final int SUPERPOWER_CHANCE = 20;

  /**
   * Constructs an enemy represents Vagrant.
   *
   * @param name name of Vagrant
   */
  public Vagrant(String name) {
    super(name);
    this.damage = INITIAL_DAMAGE;
    this.health = INITIAL_HEALTH;
    this.chance = SUPERPOWER_CHANCE;
  }

  @Override
  public void uniqueAbility() {
  }

  @Override
  protected void performAbility() {
  }

  //has the ability to steal health
  @Override
  public void attack(Entity entity) {
    int temp = rd.nextInt(100);
    if (temp < chance) {
      entity.takeDamage(HEALTH_DRAIN);
      this.health += HEALTH_DRAIN;
      System.out.println(this.getClass().getSimpleName() + " " + name
          + " steals " + entity.getClass().getSimpleName() + " " + entity.getName() + " health");
      System.out.println(entity.getClass().getSimpleName() + " " + entity.getName()
          + " now has " + entity.getHealth() + " health");
    }
    super.attack(entity);
  }
}
