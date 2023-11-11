import java.util.Scanner;
import java.util.regex.Pattern;

public class SafeInput {
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int retInt=0;  // Set this to zero length. Loop runs until it isn’t
        boolean done = false;
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            if (pipe.hasNextInt()){
                retInt = pipe.nextInt();

                done = true;
            } else {
                pipe.next();
            }
        }while(!done);

        return retInt;

    }

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        boolean done = false;
        double retDouble = 0;  // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            if (pipe.hasNextDouble()){
                retDouble = pipe.nextDouble();
                done = true;
            } else {
                pipe.next();
            }

        }while(!done);

        return retDouble;

    }

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retInt=0;  // Set this to zero length. Loop runs until it isn’t
        boolean done = false;
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            if (pipe.hasNextInt()){
                retInt = pipe.nextInt();

                if (retInt < low || retInt > high) {
                    done = false;
                } else {
                    done = true;
                }

            } else {
                pipe.next();
            }
        }while(!done);

        return retInt;

    }

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retDouble=0;  // Set this to zero length. Loop runs until it isn’t
        boolean done = false;
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            if (pipe.hasNextDouble()){
                retDouble = pipe.nextDouble();

                if (retDouble < low || retDouble > high) {
                    done = false;
                } else {
                    done = true;
                }

            } else {
                pipe.next();
            }
        }while(!done);

        return retDouble;
    }

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getYNConfirm(Scanner pipe, String prompt)
    {
        String returnString="";  // Set this to zero length. Loop runs until it isn’t
        boolean done = false;
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            if (pipe.hasNext()){
                returnString = pipe.next();

                if (returnString.equalsIgnoreCase("y") || returnString.equalsIgnoreCase("n")){
                    done = true;
                } else {
                    done = false;
                }

            } else {
                pipe.next();
            }
        }while(!done);

        return returnString;
    }

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String input;
        do {
            System.out.print(prompt);

            // Check if there's a next line and if it matches the regex
            while (!pipe.hasNextLine()) {
                System.out.println("Invalid input! Please try again.");
                pipe.nextLine(); // read the trash
            }

            input = pipe.nextLine();

            if (!Pattern.matches(regEx, input)) {
                System.out.println("Input doesn't match the pattern! Please try again.");
            }
        } while (!Pattern.matches(regEx, input));

        return input;
    }

    public static void prettyHeader(String msg){
        int WIDTH = 60;
        int STARSAROUND = 6; // 3 on each side
        int SPACING = 3; // Spacing between stars and message

        // line 1
        for (int i = 0; i < 60; i++) {
            System.out.print("*");
        }

        System.out.println();

        int totalPadding = WIDTH - msg.length() - 3 - 2 * SPACING;
        int paddingBefore = totalPadding / 2;
        int paddingAfter = totalPadding - paddingBefore;

        for (int i = 0; i < 3; i++) {
            System.out.print("*");
        }

        for (int i = 0; i < paddingBefore; i++) {
            System.out.print(" ");
        }


        System.out.print(msg);

        for (int i = 0; i < SPACING; i++) {
            System.out.print(" ");
        }


        for (int i = 0; i < paddingAfter; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < 3; i++) {
            System.out.print("*");
        }

        System.out.println();

        for (int i = 0; i < 60; i++) {
            System.out.print("*");
        }

        System.out.println();

    }
}

