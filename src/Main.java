import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> lines = new ArrayList<>();

    private static boolean done = false;
    private static boolean saved = false;

    public static void main(String[] args) {
        String menuPrompt = "A = Add | D = Delete | V = Print | Q = Quit | O = Open List | S = Save List | C = Clear List : ";
        String menu = "";
        Scanner in = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println();
            menu = SafeInput.getRegExString(in, menuPrompt, "[AaDdVvQqOoSsCc]");
            menu = menu.toUpperCase();

            switch (menu) {
                case "A":
                    add();
                    break;
                case "D":
                    showList();
                    delete();
                    break;
                case "V":
                    showList();
                    break;
                case "O":
                    openList();
                    break;
                case "S":
                    saveList();
                    break;
                case "C":
                    clearList();
                    break;
                case "Q":
                    if(!saved){
                        System.out.println("Your list isn't saved, please save before leaving.");
                        break;
                    }
                    if (SafeInput.getYNConfirm(in, "Are you sure you want to quit?").equalsIgnoreCase("y")) {
                        System.exit(0);
                    } else {
                        in.nextLine();
                        break;
                    }
            }

        } while (!done);
    }

    public static void showList() {
        if (lines.isEmpty()) {
            System.out.println();
            System.out.println("Nothing to display, add some items!.");
            System.out.println();
        } else {
            for (int i = 0; i < lines.size(); i++) {
                System.out.println();
                System.out.println((i + 1) + ". " + lines.get(i));
                System.out.println();
            }
        }
    }

    private static void delete() {
        System.out.println();
        if (lines.isEmpty()) {
            System.out.println();
            System.out.println("Nothing to delete in your list, add some items!.");
            System.out.println();
            return;
        }
        saved = false;
        int target = SafeInput.getRangedInt(scanner, "Enter the number of the line that you will be deleting.", 1, lines.size());
        lines.remove(target - 1);
    }
    public static void add() {
        String message = SafeInput.getNonZeroLenString(scanner, "Enter your item");
        lines.add(message);
        saved = false;
    }

    private static void openList() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the filename to open: ");
        String fileName = scanner.nextLine();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName + ".txt"))) {
            lines = (ArrayList<String>) ois.readObject();
            System.out.println("Successfully loaded.");
            saved = false;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }

    private static void saveList() {
        if (lines.isEmpty()) {
            System.out.println("Your list is empty, add somethings!.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the filename to save: ");
        String fileName = scanner.nextLine();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName + ".txt"))) {
            oos.writeObject(lines);
            System.out.println("Successfully saved.");
            saved = true;
        } catch (IOException e) {
            System.out.println("Error saving the list: " + e.getMessage());
        }
    }

    private static void clearList() {
        lines.clear();
        saved = true;
        System.out.println("List has been cleared.");
    }
}