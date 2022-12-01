package Main;

import java.util.Scanner;

/**
 *
 * @author altay
 */
public class BattleField extends Storage {

    public BattleField() {
        super("Battle field");
    }

    public void action(int A, int B) {
        System.out.println(A + ": " + lutemons.get(A).color + "(" + lutemons.get(A).name + ") att: " + lutemons.get(A).attack + "; def: " + lutemons.get(A).defense + "; exp:" + lutemons.get(A).experience + "; health: " + lutemons.get(A).health + "/" + lutemons.get(A).maxHealth);
        System.out.println(B + ": " + lutemons.get(B).color + "(" + lutemons.get(B).name + ") att: " + lutemons.get(B).attack + "; def: " + lutemons.get(B).defense + "; exp:" + lutemons.get(B).experience + "; health: " + lutemons.get(B).health + "/" + lutemons.get(B).maxHealth);
        System.out.println(lutemons.get(A).color + "(" + lutemons.get(A).name + ") attacks " + lutemons.get(B).color + "(" + lutemons.get(B).name + ")");
        lutemons.get(B).health -= lutemons.get(A).attack() - lutemons.get(B).defense();
    }

    public void dead(int A, int B) {
        System.out.println(lutemons.get(A).color + "(" + lutemons.get(A).name + ") gets killed.");
        lutemons.get(B).experience++;
        lutemons.remove(A);
    }

    public void alive(int ID) {
        System.out.println(lutemons.get(ID).color + "(" + lutemons.get(ID).name + ") manages to escape death.");
    }

    public void fight(Scanner sc) {
        listLutemons();
        System.out.println("Give the ID of the first fighter:");
        String firstFighter = sc.nextLine();
        int id = 0;
        try {
            id = Integer.parseInt(firstFighter);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        System.out.println("Give the ID of the second fighter:");
        String secondFighter = sc.nextLine();
        int id2 = 0;
        try {
            id2 = Integer.parseInt(secondFighter);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        while (lutemons.get(id).health > 0 && lutemons.get(id2).health > 0) {
            action(id, id2);
            if (lutemons.get(id2).health > 0) {
                alive(id2);
            } else {
                dead(id2, id);
                System.out.println("The battle is over.");
                break;
            }
            action(id2, id);
            if (lutemons.get(id).health > 0) {
                alive(id);
            } else {
                dead(id, id2);
                System.out.println("The battle is over.");
                break;
            }
        }
    }
}
