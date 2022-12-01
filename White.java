package Main;

/**
 *
 * @author altay
 */
public class White extends Lutemon {

    public White(String name) {
        this.name = name;
        color = "White";
        attack = 5;
        defense = 4;
        experience = 0;
        health = 20;
        maxHealth = 20;
        id = idCounter;
    }
}
