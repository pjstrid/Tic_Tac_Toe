public class PlayingFields {

    // Method which create a playing field: 3x3
    public static char[][] threeTimesThree() {
        return new char[][]{
                {'*', 'A', 'B', 'C'},
                {'1', ' ', ' ', ' '},
                {'2', ' ', ' ', ' '},
                {'3', ' ', ' ', ' '}
        };
    }

    // Method which prints a playing field: 3x3
    public static void printThreeTimesThree() {
        char [][] chosenPlayingField = threeTimesThree();
        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.print("|");
            for (int j = 0; j < 4; j++) {
                System.out.print(chosenPlayingField[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println();
    }
}

