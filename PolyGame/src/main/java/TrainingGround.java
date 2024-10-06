import enemies.Enemy;
import enemies.Zombie;
import heroes.Archer;
import heroes.Hero;
import heroes.Mage;
import heroes.Warrior;
import weapons.Axe;
import weapons.Bow;
import weapons.Wand;

/**
 * Class for testing combat between entities.
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

    final Enemy zombie = new Zombie("Shaun");
    final Hero warrior = new Warrior<>("Pica", new Axe());
    final Hero mage = new Mage<>("Catus", new Wand());
    final Hero archer = new Archer<>("Procyon", new Bow());

    warrior.attack(zombie);
    zombie.attack(warrior);
    warrior.attack(zombie);
    zombie.attack(warrior);
    mage.attack(archer);
    archer.attack(mage);
  }
}