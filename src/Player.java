public class Player {

    // Variables
    private String name;

    private char playingChar;

    int score;

    // Constructor
    public Player (){
    }

    // Getter and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getPlayingChar() {
        return playingChar;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
