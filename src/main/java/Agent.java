import java.util.List;
import java.util.Random;

public class Agent {
    private int x;
    private int y;
    private int initialEnergy;
    private int energy;
    private boolean hasEaten;
    private float speed;
    private Random random;

    public Agent() {
        random = new Random();
        reset();
    }

    public void reset() {
        this.x = random.nextInt(500);
        this.y = random.nextInt(500);
        this.energy = random.nextInt(100) + 50;
        this.speed = random.nextFloat() * 10 + 1;
        this.initialEnergy = energy;
        this.hasEaten = false;
    }

    public void move(List<Food> foodSources) {
        if (foodSources.isEmpty()) {
            updateEnergy(-1);
            return;
        }

        Food nearestFood = findNearestFood(foodSources);
        moveTowards(nearestFood);

        updateEnergy(-1);
    }

    public Food findNearestFood(List<Food> foodSources) {
        Food nearestFood = null;
        double minDistance = Double.MAX_VALUE;

        for (Food food : foodSources) {
            double distance = calculateDistance(this.x, this.y, food.getX(), food.getY());
            if (distance < minDistance) {
                minDistance = distance;
                nearestFood = food;
            }
        }

        return nearestFood;
    }

    private void moveTowards(Food food) {
        if (food.getX() > this.x) {
            this.x += speed;
        } else if (food.getX() < this.x) {
            this.x -= speed;
        }

        if (food.getY() > this.y) {
            this.y += speed;
        } else if (food.getY() < this.y) {
            this.y -= speed;
        }
    }

    private double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public void updateEnergy(int amount) {
        energy += amount;
        if (energy <= 0) {
            System.out.println("The agent has run out of energy and died.");
        }
    }

    public void eat() {
        initialEnergy = energy;
        hasEaten = true;
    }

    public boolean isAtBase(Base base) {
        return calculateDistance(this.x, this.y, base.getX(), base.getY()) < 10; // Allow some tolerance
    }

    // Getters and Setters...

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getEnergy() {
        return energy;
    }

    public boolean hasEaten() {
        return hasEaten;
    }

    public float getSpeed() {
        return speed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setHasEaten(boolean hasEaten) {
        this.hasEaten = hasEaten;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getInitialEnergy() {
        return initialEnergy;
    }
}
