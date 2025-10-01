import java.util.Scanner;

public class InputHandler {

    public static Scanner in = new Scanner(System.in);

    public static String getString() {

        String input;
        while (true) {
            input = in.nextLine();
            if (input.length() != 2) {
                System.out.println("Wrong input. Answer with two characters e.g., 'A1'");

            } else {
                return input;
            }
        }

    }

}




