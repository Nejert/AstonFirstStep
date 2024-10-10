import components.Entity;
import enemies.Enemy;
import enemies.Toad;
import enemies.Vagrant;
import enemies.Zombie;
import heroes.Archer;
import heroes.Hero;
import heroes.Mage;
import heroes.Warrior;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This class is a simulation of a battle between Heroes and Enemies.
 *
 * @see Hero
 * @see Enemy
 * @see Entity
 */
public class BattleGround {
  enum Weapon {
    Axe(weapons.Axe.class),
    Sword(weapons.Sword.class),
    Bow(weapons.Bow.class),
    Wand(weapons.Wand.class);

    final Class<? extends weapons.Weapon> weaponClass;

    Weapon(Class<? extends weapons.Weapon> weapon) {
      this.weaponClass = weapon;
    }

    weapons.Weapon getWeaponInstance()
        throws NoSuchMethodException, InvocationTargetException, InstantiationException,
        IllegalAccessException {
      return weaponClass.getDeclaredConstructor().newInstance();
    }
  }

  /**
   * Application entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    fight(Arrays.asList(equip()));
  }

  /**
   * Method allows user to choose which weapons heroes will equip.
   *
   * @return array of entities
   */
  public static Entity[] equip() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Equip your heroes with weapons");

    Entity[] room = new Entity[] {
        createHero("Pica", Warrior.class, sc),
        new Zombie("Shaun"),
        createHero("Pica", Mage.class, sc),
        new Toad("Hypnotoad"),
        createHero("Pica", Archer.class, sc),
        new Vagrant("Corvus")};

    sc.close();
    return room;
  }

  private static Hero createHero(String name, Class<? extends Hero> c, Scanner sc) {
    System.out.println("Arm the " + c.getSimpleName());
    Hero hero = null;
    int choice;
    while (hero == null) {
      menu();
      choice = sc.nextInt();
      try {
        hero = (Hero) c.getConstructors()[0].newInstance(name,
            Weapon.values()[choice].getWeaponInstance());
      } catch (InstantiationException | InvocationTargetException | IllegalAccessException
               | NoSuchMethodException | ArrayIndexOutOfBoundsException e) {
        System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage() + ". Try again.");
      } catch (IllegalArgumentException e) {
        System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());

        String type = c.getTypeParameters()[0].getBounds()[0].getTypeName();
        type = type.substring(type.lastIndexOf('.') + 1, type.lastIndexOf("W")).toLowerCase();
        System.out.println(
            c.getSimpleName() + " can only hold weapon for " + type + " attacks. Try again.");
      }
    }

    return hero;
  }

  private static void menu() {
    System.out.println("Choose a weapon");
    for (Weapon w : Weapon.values()) {
      System.out.println(w.ordinal() + "." + w.name());
    }
  }

  /**
   * Method initiates a simulation of a battle between Heroes and Enemies.
   *
   * @param list the list in which the entities will be packed
   */
  static void fight(List<? extends Entity> list) {
    int heroes = 0;
    int enemies = 0;
    for (Entity e : list) {
      if (e instanceof Hero) {
        heroes++;
      } else {
        enemies++;
      }
    }
    while (heroes != 0 && enemies != 0) {
      for (Entity e : list) {
        if (heroes == 0 || enemies == 0) {
          break;
        }
        if (!e.isAlive()) {
          continue;
        }

        if (e instanceof Hero) {
          for (Entity entity : list) {
            if (entity == e) {
              continue;
            }
            if (entity instanceof Enemy) {
              if (entity.isAlive()) {
                e.attack(entity);
                if (!entity.isAlive()) {
                  entity.uniqueAbility();
                  if (!entity.isAlive()) {
                    enemies--;
                  }
                }
              }
            }
          }
        } else {
          //(e instanceof Enemy)
          for (Entity entity : list) {
            if (entity == e) {
              continue;
            }
            if (entity instanceof Hero) {
              if (entity.isAlive()) {
                e.attack(entity);
                if (!entity.isAlive()) {
                  heroes--;
                }
              }
            }
          }
        }
      }
    }
    if (heroes != 0) {
      System.out.println("\nHeroes wins!");
    } else {
      System.out.println("\nEnemies wins!");
    }
    showContents(list);
  }

  static void showContents(List<? extends Entity> list) {
    for (Entity e : list) {
      System.out.println(e.getClass().getSimpleName() + " " + e.getName() + " "
          + (e.getHealth() <= 0 ? "Dead" : "HP: " + e.getHealth()));
    }
  }
}
