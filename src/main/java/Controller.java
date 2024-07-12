import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Controller {
    private List<Agent> agents;
    private List<Food> foods;
    private Base base;
    private Map map;
    private Random random;

    public Controller() {
        random = new Random();
        agents = new ArrayList<>();
        foods = new ArrayList<>();
        base = new Base();

        // Initialize agents
        for (int i = 0; i < 5; i++) {
            agents.add(new Agent());
        }

        // Initialize foods
        for (int i = 0; i < 10; i++) {
            foods.add(new Food());
        }

        // Initialize the map
        map = new Map(agents, foods, base);
    }

    public void startSimulation() {
        int round = 0;
        while (!agents.isEmpty()) {
            round++;
            System.out.println("Round: " + round);

            // Move agents towards food
            Iterator<Agent> iterator = agents.iterator();
            while (iterator.hasNext()) {
                Agent agent = iterator.next();
                agent.move(foods);

                // Check if agent has eaten
                if (!foods.isEmpty()) {
                    Food food = agent.findNearestFood(foods);
                    if (agent.getX() == food.getX() && agent.getY() == food.getY()) {
                        agent.eat();
                        foods.remove(food);
                    }
                }

                // Check if agent has returned to base
                if (agent.hasEaten() && agent.isAtBase(base)) {
                    agent.setHasEaten(false); // Reset eating status for next round
                    agent.setEnergy(agent.getEnergy() + agent.getInitialEnergy()); // Restore energy
                }

                // Remove dead agents
                if (agent.getEnergy() <= 0) {
                    iterator.remove();
                }
            }

            // Update the map with new positions
            map.updateMap(agents, foods);

            // Reinitialize food for next round
            foods.clear();
            for (int i = 0; i < 10; i++) {
                foods.add(new Food());
            }

            // Reinitialize agent positions for next round
            for (Agent agent : agents) {
                agent.reset();
            }

            // Add a delay to visually see each round
            try {
                Thread.sleep(1000); // 1 second delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All agents have died. Simulation over.");
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.startSimulation();
    }
}
