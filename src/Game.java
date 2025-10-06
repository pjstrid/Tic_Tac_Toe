import java.util.Scanner;

public class Game {

    int menuChoice;

    public Game(){

        do {
            System.out.println("""
                    -------------------------------
                    ------ WELCOME TO A GAME ------
                    ------  OF TIC TAC TOE!  ------
                    -------------------------------
                    
                    SELECT GAME MODE
                    1. vs. Player
                    2. vs. Computer
                    
                    Your choice:""");

            menuChoice = InputHandler.getInt();

            if (menuChoice == 1) {
                new PlayerVsPlayer();
            } else {
                new PlayerVsComputer();
            }

        } while (!finishedPlaying());
    }

    // Method for a new game or not
    private static boolean finishedPlaying() {
        System.out.println();
        System.out.println("""
                            NEW GAME?
                            1. YES
                            2. NO
                            
                            Your choice:""");

        Scanner in = new Scanner(System.in);
        int newGame = InputHandler.getInt();

        if (newGame == 1) {

            // Program restarts
            return false;
        } else if (newGame == 2) {

            // Program ends
            System.out.println();
            System.out.println("""
                                -------------------------------
                                ---------- GOOD BYE! ----------
                                ---- THANK YOU FOR PLAYING ----
                                -------------------------------""");
            return true;
        } else {

            System.out.println("Wrong input. Try again");
            in.nextLine();
        }

        return false;
    }
}