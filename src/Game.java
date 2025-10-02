public class Game {

    Game() {
        run();
    }

    public void run() {
        System.out.println("""
                            Welcome to a game of Tic Tac Toe!
                            Your playing field:""");

        PlayingFields.printThreeTimesThree();

        GamePlay.gamePlay();

    }
}
