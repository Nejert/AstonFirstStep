import components.Entity;
import enemies.*;
import heroes.*;

import java.util.Arrays;
import java.util.List;

public class BattleGround {
    public static void main(String[] args) {
        Entity[] room = new Entity[]{
                new Warrior("Pica"),
                new Zombie("Shaun"),
                new Mage("Catus"),
                new Toad("Hypnotoad"),
                new Archer("Procyon"),
                new Vagrant("Corvus")
        };
        fight(Arrays.asList(room));
    }

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
                if (heroes == 0 || enemies == 0) break;
                if (!e.isAlive()) continue;

                if (e instanceof Hero) {
                    for (Entity entity : list) {
                        if (entity == e) continue;
                        if (entity instanceof Enemy) {
                            if (entity.isAlive()) {
                                e.attack(entity);
                                if (!entity.isAlive()) {
                                    entity.uniqueAbility();
                                    if (!entity.isAlive()) enemies--;
                                }
                            }
                        }
                    }
                } else {
                    //(e instanceof Enemy)
                    for (Entity entity : list) {
                        if (entity == e) continue;
                        if (entity instanceof Hero) {
                            if (entity.isAlive()) {
                                e.attack(entity);
                                if (!entity.isAlive()) heroes--;
                            }
                        }
                    }
                }
            }
        }
        if (heroes != 0) System.out.println("\nHeroes wins!");
        else System.out.println("\nEnemies wins!");
        showContents(list);
    }

    static void showContents(List<? extends Entity> list) {
        for (Entity e : list) {
            System.out.println(e.getClass().getSimpleName() + " " +
                    e.getName() + " " + (e.getHealth() <= 0 ? "Dead" : "HP: " + e.getHealth()));
        }
    }
}
