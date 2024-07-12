import java.util.Random;

public class Base {
    private int x;
    private int y;
    private boolean isTaken;
    private Random random;

    public Base() {
        random = new Random();
        this.x = random.nextInt(500);
        this.y = random.nextInt(500);
        this.isTaken = false;
    }

    // Getters and Setters...

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
