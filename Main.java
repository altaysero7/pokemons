package Main;

import java.util.Scanner;

/**
 *
 * @author altay
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Lutemon simulator!");
        Home home = new Home();
        TrainingArea trainingArea = new TrainingArea();
        BattleField battleField = new BattleField();

        while (!exit) {
            System.out.println("1) Create a Lutemon, 2) List all the Lutemons, "
                    + "3) Move Lutemons, 4) Train Lutemons, 5) Let them fight, 0) Exit");

            if (sc.hasNext()) {
                int i = 0;
                String si = sc.nextLine();
                try {
                    i = Integer.parseInt(si);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
                switch (i) {
                    case 1:
                        home.createLutemonMenu(sc);
                        break;
                    case 2:
                        home.listLutemons();
                        trainingArea.listLutemons();
                        battleField.listLutemons();
                        break;
                    case 3:
                        System.out.println("Give the ID of Lutemon that should be moved:");
                        String ID = sc.nextLine();
                        int id = 0;
                        try {
                            id = Integer.parseInt(ID);
                        } catch (NumberFormatException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println("Where would the Lutemon be moved? 1) Home, 2) Training area, 3) Battle field");
                        if (sc.hasNext()) {
                            int j = 0;
                            String sj = sc.nextLine();
                            try {
                                j = Integer.parseInt(sj);
                            } catch (NumberFormatException ex) {
                                ex.printStackTrace();
                            }
                            Lutemon lutemon = home.getLutemon(id);
                            if (lutemon == null) {
                                lutemon = trainingArea.getLutemon(id);
                                if (lutemon == null) {
                                    lutemon = battleField.getLutemon(id);
                                }
                            }
                            if (lutemon == null) {
                                System.out.println("No Lutemon with ID " + id + " could be found!");
                            } else {
                                switch (j) {
                                    case 1:
                                        lutemon.health = lutemon.maxHealth;
                                        home.moveLutemon(lutemon);
                                        break;
                                    case 2:
                                        trainingArea.moveLutemon(lutemon);
                                        break;
                                    case 3:
                                        battleField.moveLutemon(lutemon);
                                        break;
                                }
                            }
                        }
                        break;
                    case 4:
                        trainingArea.train();
                        break;
                    case 5:
                        battleField.fight(sc);
                        break;
                    case 0:
                        System.out.println("The game has closed. In total " + Lutemon.getNumberOfCreatedLutemons() + " Lutemons were created.");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid input.");
                }
            }
        }
        sc.close();
    }
}
