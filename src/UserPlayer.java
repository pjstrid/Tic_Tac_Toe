public class UserPlayer extends Player{
    String name;

    char playingChar;
    public UserPlayer(String name, char playingChar) {
        super();
            this.name = name;
            this.playingChar = playingChar;

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
