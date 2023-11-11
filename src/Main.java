import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    private static Scanner in = new Scanner(System.in);
    private static ArrayList<String> lines = new ArrayList<>();

    private static boolean done = false;
    public static void main(String[] args) {
        String menuPrompt = "A = Add | D = Delete | P = Print | Q = Quit | : ";
        String menu = "";
        Scanner in = new Scanner(System.in);
        do {
            System.out.println();
            showList();
            System.out.println();
            menu = SafeInput.getRegExString(in, menuPrompt, "[AaDdPpQq]");
            menu = menu.toUpperCase();

                switch (menu) {
                    case "A":
                        add();
                        break;
                    case "D":
                        delete();
                        break;
                    case "P":
                        showList();
                        break;
                    case "Q":
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
        int target = SafeInput.getRangedInt(in, "Enter the number of the line that you will be deleting.", 1, lines.size());
        lines.remove(target - 1);
    }

    public static void add() {
        String message = SafeInput.getNonZeroLenString(in, "Enter your item");
        lines.add(message);
    }
}