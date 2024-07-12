import java.util.Random;

public class Food {
    private int x;
    private int y;
    private Random random;

    public Food() {
        this.x = random.nextInt(500);
        this.y = random.nextInt(500);
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
