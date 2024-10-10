package enemies;

import components.Entity;
import java.util.Random;

/**
 * Class representing enemies extends {@link Entity}, implemented abstract method
 * {@code uniqueAbility()} with default behavior.
 *
 * @see Entity
 */
public abstract class Enemy extends Entity {
  protected Random rd = new Random();
  protected int chance = 0;

  public Enemy(String name) {
    super(name);
  }

  @Override
  public void uniqueAbility() {
    int temp = rd.nextInt(100);
    if (temp < chance) {
      performAbility();
    }
  }
}
