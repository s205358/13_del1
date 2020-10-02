package Game;

public class Die {
    private final int MAX = 6;
    private int faceValue;

    public Die() {
       roll();
    }

    public void roll() {
        setFaceVale((int) (Math.random() * MAX) + 1);
    }

    public void setFaceVale(int faceValue) {
        this.faceValue = faceValue;
    }

    public int getFaceVale() {
        return faceValue;
    }
}
