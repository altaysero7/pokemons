package Main;

/**
 *
 * @author altay
 */
public class Black extends Lutemon {

    public Black(String name) {
        this.name = name;
        color = "Black";
        attack = 9;
        defense = 0;
        experience = 0;
        health = 16;
        maxHealth = 16;
        id = idCounter;
    }
}
