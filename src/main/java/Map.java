import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Map extends JPanel {
    private List<Agent> agents;
    private List<Food> foods;
    private Base base;

    public Map(List<Agent> agents, List<Food> foods, Base base) {
        this.agents = agents;
        this.foods = foods;
        this.base = base;

        JFrame frame = new JFrame("Simulation Map");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(this);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBase(g);
        drawFoods(g);
        drawAgents(g);
    }

    private void drawBase(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(base.getX(), base.getY(), 10, 10);
    }

    private void drawFoods(Graphics g) {
        g.setColor(Color.RED);
        for (Food food : foods) {
            g.fillRect(food.getX(), food.getY(), 5, 5);
        }
    }

    private void drawAgents(Graphics g) {
        g.setColor(Color.GREEN);
        for (Agent agent : agents) {
            g.fillRect(agent.getX(), agent.getY(), 10, 10);
        }
    }

    public void updateMap(List<Agent> agents, List<Food> foods) {
        this.agents = agents;
        this.foods = foods;
        repaint();
    }
}
