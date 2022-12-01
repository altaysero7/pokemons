package Main;

import java.util.Scanner;

/**
 *
 * @author altay
 */
public class Home extends Storage {

    public Home() {
        super("Home");
    }

    public void createLutemonMenu(Scanner sc) {
        System.out.println("Add 1) White, 2) Green, 3) Pink, 4) Orange, 5) Black");
        if (sc.hasNext()) {
            int i = 0;
            String si = sc.nextLine();
            try {
                i = Integer.parseInt(si);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
            System.out.println("Give it a name:");
            String lutemonName = sc.nextLine();
            switch (i) {
                case 1:
                    White white = new White(lutemonName);
                    createLutemon(white);
                    break;
                case 2:
                    Green green = new Green(lutemonName);
                    createLutemon(green);
                    break;
                case 3:
                    Pink pink = new Pink(lutemonName);
                    createLutemon(pink);
                    break;
                case 4:
                    Orange orange = new Orange(lutemonName);
                    createLutemon(orange);
                    break;
                case 5:
                    Black black = new Black(lutemonName);
                    createLutemon(black);
                    break;
            }
        }
    }

    public void createLutemon(Lutemon lutemon) {
        lutemons.put(lutemon.getId(), lutemon);
        Lutemon.idCounter++;
    }
}
