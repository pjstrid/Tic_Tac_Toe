import java.util.Scanner;

public class InputHandler {

    public static Scanner in = new Scanner(System.in);

    public static String getString(){

        return in.nextLine();
    }

    // Method to check a players move, so it matches the coordinates on the board
    public static String getMove() {

        String input;
        while (true) {
            // Takes input and make it to upper case if it's not, to match the cases in the switch
            input = in.nextLine().toUpperCase();
            if (input.length() == 2 &&
                    (input.charAt(0) == 'A' || input.charAt(0) == 'B' || input.charAt(0) == 'C') &&
                            (input.charAt(1) == '1' || input.charAt(1) == '2' || input.charAt(1) == '3')) {

                return input;
            } else {
                System.out.println("""
            Wrong input. Answer with a correct
            coordinate e.g., 'A1'""");
            }
        }
    }
}




