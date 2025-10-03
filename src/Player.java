public class Player {

    private String name;

    private char playingChar;

    int score;

    public Player (String name, char playingChar, int score){
        this.name = name;
        this.playingChar = playingChar;
        this.score = score;
    }

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
