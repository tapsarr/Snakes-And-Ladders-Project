package Model;

public class Difficulty {
    private int level;
    public static Difficulty difficultyInst = null;

    public final String EASY = "Easy";
    public final String NORMAL = "Normal";
    public final String HARD = "Hard";

    private Difficulty() {
        this.level = 2;
    }

    public void setDifficulty(int dif) {
        this.level = dif;
    }

    public int getDifficultyInt() {
        return this.level;
    }

    public String getDifficultyString() {
        switch (this.level) {
            case 1:
                return this.EASY;

            case 2:
                return this.NORMAL;
            case 3:
                return this.HARD;
            default:
                return this.NORMAL;
        }
    }

    public static Difficulty getInstance() {
        if (difficultyInst == null) {
            difficultyInst = new Difficulty();
        }
        return difficultyInst;
    }

}
