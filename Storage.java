package Main;

import java.util.HashMap;

/**
 *
 * @author altay
 */
public class Storage {

    protected String name;
    protected HashMap<Integer, Lutemon> lutemons = new HashMap();

    public Storage(String name) {
        this.name = name;
    }

    public void moveLutemon(Lutemon lutemon) {
        lutemons.put(lutemon.getId(), lutemon);
    }

    public Lutemon getLutemon(int id) {
        if (lutemons.containsKey(id)) {
            return lutemons.remove(id);
        } else {
            return null;
        }
    }

    public void listLutemons() {
        System.out.println("There are the following Lutemons at " + name + ":");
        for (Integer i : lutemons.keySet()) {
            System.out.println(i + ": " + lutemons.get(i).color + "(" + lutemons.get(i).name + ") att: " + lutemons.get(i).attack + "; def: " + lutemons.get(i).defense + "; exp:" + lutemons.get(i).experience + "; health: " + lutemons.get(i).health + "/" + lutemons.get(i).maxHealth);
        }
    }
}
