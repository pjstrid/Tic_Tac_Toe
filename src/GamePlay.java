public class GamePlay {


    public static void gamePlay() {

        System.out.println("Player one, choose your name:");
        String selectedNamePlayerOne = InputHandler.getString();

        Player playerOne = new Player(selectedNamePlayerOne);

        System.out.println("Player two, choose your name:");
        String selectedNamePlayerTwo = InputHandler.getString();

        Player playerTwo = new Player(selectedNamePlayerTwo);

        char charPlayerOne = 'X';
        char charPlayerTwo = 'O';

        System.out.println(playerOne.getName() + " plays with: " + charPlayerOne);
        System.out.println(playerTwo.getName() + " plays with: " + charPlayerTwo);
        char[][] currentPlayingField = createNewPlayingField();

        while (true) {
            System.out.println(playerOne.getName() + ", place your next move");
            String playerOneChoice = InputHandler.getMove().toUpperCase();

            if (playerOneChoice.equals("A1")) {
                if (currentPlayingField[1][1] == ' ') {
                    currentPlayingField[1][1] = 'X';
                } else {
                    System.out.println("Already played");
                }
            } else if (playerOneChoice.equals("A2")) {
                currentPlayingField[2][1] = 'X';
            } else if (playerOneChoice.equals("A3")) {
                currentPlayingField[3][1] = 'X';
            } else if (playerOneChoice.equals("B1")) {
                currentPlayingField[1][2] = 'X';
            } else if (playerOneChoice.equals("B2")) {
                currentPlayingField[2][2] = 'X';
            } else if (playerOneChoice.equals("B3")) {
                currentPlayingField[3][2] = 'X';
            } else if (playerOneChoice.equals("C1")) {
                currentPlayingField[1][3] = 'X';
            } else if (playerOneChoice.equals("C2")) {
                currentPlayingField[2][3] = 'X';
            } else if (playerOneChoice.equals("C3")) {
                currentPlayingField[3][3] = 'X';
            } else {
                System.out.println("Wrong input. Try again");
            }

            System.out.println();
            for (int i = 0; i < 4; i++) {
                System.out.print("|");
                for (int j = 0; j < 4; j++) {
                    System.out.print(currentPlayingField[i][j]);
                    System.out.print("|");
                }
                System.out.println();
            }

            System.out.println(playerTwo.getName() + ", place your next move");
            String playerTwoChoice = InputHandler.getMove().toUpperCase();

            if (playerTwoChoice.equals("A1")) {
                if (currentPlayingField[1][1] == ' ') {
                    currentPlayingField[1][1] = charPlayerTwo;
                } else {
                    System.out.println("Already played. Try again");
                }
            } else if (playerTwoChoice.equals("A2")) {
                currentPlayingField[2][1] = charPlayerTwo;
            } else if (playerTwoChoice.equals("A3")) {
                currentPlayingField[3][1] = charPlayerTwo;
            } else if (playerTwoChoice.equals("B1")) {
                currentPlayingField[1][2] = charPlayerTwo;
            } else if (playerTwoChoice.equals("B2")) {
                currentPlayingField[2][2] = charPlayerTwo;
            } else if (playerTwoChoice.equals("B3")) {
                currentPlayingField[3][2] = charPlayerTwo;
            } else if (playerTwoChoice.equals("C1")) {
                currentPlayingField[1][3] = charPlayerTwo;
            } else if (playerTwoChoice.equals("C2")) {
                currentPlayingField[2][3] = charPlayerTwo;
            } else if (playerTwoChoice.equals("C3")) {
                currentPlayingField[3][3] = charPlayerTwo;
            } else {
                System.out.println("Wrong input. Try again");
            }

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
    }

    public static char[][] createNewPlayingField() {
        return PlayingFields.threeTimesThree();
    }
}
