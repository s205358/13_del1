package Game;

public class Player {
    private String name;
    private int score = 0, streak = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void resetScore() {
        this.score = 0;
    }

    public int getStreak() {
        return this.streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public void resetStreak() {
        this.streak = 0;
    }
}
