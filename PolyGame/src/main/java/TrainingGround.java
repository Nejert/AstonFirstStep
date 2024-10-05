import enemies.Enemy;
import enemies.Zombie;
import heroes.Hero;
import heroes.Warrior;

/**
 * Сlass for testing combat between entities.
 *
 * @see Hero
 * @see Enemy
 * @see components.Entity
 */
public class TrainingGround {
  /**
   * Application entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {

    Enemy zombie = new Zombie("Shaun");
    Hero warrior = new Warrior("Pica");

    warrior.attack(zombie);
    zombie.attack(warrior);
    warrior.attack(zombie);
    zombie.attack(warrior);
  }
}