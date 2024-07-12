import java.util.Random;

public class Base {
    private int x;
    private int y;
    private boolean isTaken;
    private Random random;

    public Base() {
        this.x = random.nextInt(500);
        this.y = random.nextInt(500);
        this.isTaken = false;
    }

    // Method to check if the base is taken
    public boolean isTaken() {
        return isTaken;
    }

    // Method to set the base as taken
    public void setTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
