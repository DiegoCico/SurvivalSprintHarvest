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
        reset();
    }

    public void reset(){
        this.x = random.nextInt(500);
        this.y = random.nextInt(500);
        this.energy = random.nextInt(100);
        this.speed = random.nextFloat(15);
        this.energy = random.nextInt(350);
        this.initialEnergy = energy;
        this.hasEaten = false;
    }

    // Method to move the agent towards the nearest energy source
    public void move(List<Food> foodSources) {
        if (foodSources.isEmpty()) {
            // No food sources, the agent dies if it runs out of energy
            updateEnergy(-1);
            if (energy <= 0) {
                System.out.println("The agent has run out of energy and died.");
            }
            return;
        }

        Food nearestFood = findNearestFood(foodSources);
        moveTowards(nearestFood);

        // Decrease energy with each move
        updateEnergy(-1);
        if (energy <= 0) {
            System.out.println("The agent has run out of energy and died.");
        }
    }

    // Method to find the nearest food source
    private Food findNearestFood(List<Food> foodSources) {
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

    // Method to move the agent towards a specific food source
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

    // Method to calculate the distance between two points
    private double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Method to update energy
    public void updateEnergy(int amount) {
        energy += amount;
        if (energy <= 0) {
            // Agent dies if energy runs out
            System.out.println("The agent has run out of energy and died.");
        }
    }

    // Method to eat food
    public void eat() {
        initialEnergy = energy;
        hasEaten = true;
    }

    // Getters
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

    // Setters
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
}
