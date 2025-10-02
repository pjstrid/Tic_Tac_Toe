public class Game {

    Game() {
        System.out.println("Welcome to a game of Tic Tac Toe!");

        gamePlay();
    }

    public static void gamePlay() {

        // Creates a new playing field for this game
        char[][] currentPlayingField = createNewPlayingField();

        System.out.println();
        System.out.println("Player one, choose your name:");
        String selectedNamePlayerOne = InputHandler.getString();

        Player playerOne = new Player(selectedNamePlayerOne, 'X');

        System.out.println("Player two, choose your name:");
        String selectedNamePlayerTwo = InputHandler.getString();

        Player playerTwo = new Player(selectedNamePlayerTwo, 'O');

        char charPlayerOne = 'X';
        char charPlayerTwo = 'O';
        System.out.println();
        System.out.println(playerOne.getName() + " plays with: " + charPlayerOne);
        System.out.println(playerTwo.getName() + " plays with: " + charPlayerTwo);

        // Prints the starting playing field
        System.out.println();
        System.out.println("This is your playing field:");
        printCurrentPlayingField(currentPlayingField);
        System.out.println("Place your move by write a coordinate e.g., A1");

        int turn = 0;
        Player activePlayer;
        Player passivePlayer;    // KANSKE TA BORT ???

        while (turn != 9) {
            if (turn % 2 == 0) {
                activePlayer = playerOne;
                passivePlayer = playerTwo;
            } else {
                activePlayer = playerTwo;
                passivePlayer = playerOne;
            }

            System.out.println();
            System.out.println(activePlayer.getName() + ", your turn");

            // Takes input and make it to upper case
            String activePlayerChoice = InputHandler.getMove().toUpperCase();

            // Places the move in correct box and checks if that box is already played
            if (activePlayerChoice.equals("A1")) {
                if (currentPlayingField[1][1] == ' ') {
                    currentPlayingField[1][1] = activePlayer.getPlayingChar();
                    printCurrentPlayingField(currentPlayingField);
                    turn++;
                } else {
                    System.out.println("Already played. Try again");
                }
            } else if (activePlayerChoice.equals("A2")) {
                if (currentPlayingField[2][1] == ' ') {
                    currentPlayingField[2][1] = activePlayer.getPlayingChar();
                    printCurrentPlayingField(currentPlayingField);
                    turn++;
                } else {
                    System.out.println("Already played. Try again");
                }
            } else if (activePlayerChoice.equals("A3")) {
                if (currentPlayingField[3][1] == ' ') {
                    currentPlayingField[3][1] = activePlayer.getPlayingChar();
                    printCurrentPlayingField(currentPlayingField);
                    turn++;
                } else {
                    System.out.println("Already played. Try again");
                }
            } else if (activePlayerChoice.equals("B1")) {
                if (currentPlayingField[1][2] == ' ') {
                    currentPlayingField[1][2] = activePlayer.getPlayingChar();
                    printCurrentPlayingField(currentPlayingField);
                    turn++;
                } else {
                    System.out.println("Already played. Try again");
                }
            } else if (activePlayerChoice.equals("B2")) {
                if (currentPlayingField[2][2] == ' ') {
                    currentPlayingField[2][2] = activePlayer.getPlayingChar();
                    printCurrentPlayingField(currentPlayingField);
                    turn++;
                } else {
                    System.out.println("Already played. Try again");
                }
            } else if (activePlayerChoice.equals("B3")) {
                if (currentPlayingField[3][2] == ' ') {
                    currentPlayingField[3][2] = activePlayer.getPlayingChar();
                    printCurrentPlayingField(currentPlayingField);
                    turn++;
                } else {
                    System.out.println("Already played. Try again");
                }
            } else if (activePlayerChoice.equals("C1")) {
                if (currentPlayingField[1][3] == ' ') {
                    currentPlayingField[1][3] = activePlayer.getPlayingChar();
                    printCurrentPlayingField(currentPlayingField);
                    turn++;
                } else {
                    System.out.println("Already played. Try again");
                }
            } else if (activePlayerChoice.equals("C2")) {
                if (currentPlayingField[2][3] == ' ') {
                    currentPlayingField[2][3] = activePlayer.getPlayingChar();
                    printCurrentPlayingField(currentPlayingField);
                    turn++;
                } else {
                    System.out.println("Already played. Try again");
                }
            } else if (activePlayerChoice.equals("C3")) {
                if (currentPlayingField[3][3] == ' ') {
                    currentPlayingField[3][3] = activePlayer.getPlayingChar();
                    printCurrentPlayingField(currentPlayingField);
                    turn++;
                } else {
                    System.out.println("Already played. Try again");
                }
            } else {
                System.out.println("Wrong input. Answer with a correct coordinate e.g., 'A1'");
            }
        }
        System.out.println("""
                            
                            GAME OVER!
                            It's a tie!""");
    }

    private static void printCurrentPlayingField(char[][] currentPlayingField) {
        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.print("|");
            for (int j = 0; j < 4; j++) {
                System.out.print(currentPlayingField[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public static char[][] createNewPlayingField() {
        return PlayingFields.threeTimesThree();
    }
}