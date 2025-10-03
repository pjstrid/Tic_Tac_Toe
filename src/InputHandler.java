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
            input = in.nextLine();
            if (input.length() == 2 &&
                    (input.charAt(0) == 'a' || input.charAt(0) == 'b' || input.charAt(0) == 'c' ||
                        input.charAt(0) == 'A' || input.charAt(0) == 'B' || input.charAt(0) == 'C') &&
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




