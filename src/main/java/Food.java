import java.util.Random;

public class Food {
    private int x;
    private int y;
    private Random random;

    public Food() {
        random = new Random();
        this.x = random.nextInt(500);
        this.y = random.nextInt(500);
    }

    // Getters and Setters...

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
