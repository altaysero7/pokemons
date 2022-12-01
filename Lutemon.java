package Main;

/**
 *
 * @author altay
 */
public class Lutemon {

    protected String name;
    protected String color;
    protected int attack;
    protected int defense;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int id;

    public static int idCounter = 0;

    public static int getNumberOfCreatedLutemons() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public int defense() {
        return defense;
    }

    public int attack() {
        return attack + experience;
    }
}
