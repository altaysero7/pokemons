package Main;

/**
 *
 * @author altay
 */
public class TrainingArea extends Storage {

    public TrainingArea() {
        super("Training area");
    }

    public void train() {
        for (Integer i : lutemons.keySet()) {
            lutemons.get(i).experience++;
            System.out.println(lutemons.get(i).color + "(" + lutemons.get(i).name + ") trains and gain experience!");
        }
    }
}
