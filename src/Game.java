public class Game {

    int menuChoice;

    public Game(){

        System.out.println("""
            Welcome to a game of Tic Tac Toe!
            
            Select game mode:
            1. vs Player
            2. vs Computer
            
            Your choice:""");

        menuChoice = InputHandler.getInt(1, 2);

        if (menuChoice == 1) {
            new PlayerVsPlayer();
        } else {
            new PlayerVsComputer();
        }
    }
}