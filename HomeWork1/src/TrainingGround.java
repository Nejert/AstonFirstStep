import enemies.Enemy;
import heroes.Hero;
import enemies.Zombie;
import heroes.Warrior;

public class TrainingGround {
    public static void main(String[] args) {

        Enemy zombie = new Zombie("Shaun");
        Hero warrior = new Warrior("Pica");

        warrior.attack(zombie);
        zombie.attack(warrior);
        warrior.attack(zombie);
        zombie.attack(warrior);
    }
}