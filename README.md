# AI Simulation - Agent-Based Behavior

## Overview
This project is an AI-driven agent-based simulation where multiple agents move within a 2D space, searching for food to survive. The agents interact with food sources and a base while being governed by energy constraints. The simulation visually represents their movement and actions through a graphical interface.

## How It Works
The simulation consists of several components working together to create a dynamic and interactive environment:

### 1. **Agent Behavior**
- Each agent starts at a random position with a random energy level and speed.
- Agents continuously move in search of food, prioritizing the nearest food source.
- Movement is dictated by speed and distance calculations using the Euclidean formula.
- Agents consume energy with every move.
- When an agent reaches a food source, it "eats," refilling its energy.
- Agents attempt to return to the base after eating.
- If an agent runs out of energy, it "dies" and is removed from the simulation.

### 2. **Food Generation**
- Food objects are randomly placed on the 2D grid at the start of each round.
- When agents eat food, the consumed food is removed from the list.
- After every round, new food sources are generated to keep the environment populated.

### 3. **Base Mechanics**
- The base is a fixed point on the map where agents can return after eating.
- Returning to the base restores additional energy and resets the agent's status.
- Agents that reach the base after eating can continue in subsequent rounds.

### 4. **Controller (Simulation Engine)**
- Manages the overall execution of the simulation, including agents, food, and base interactions.
- Initializes agents and food sources at the start.
- Runs the simulation loop where agents move, interact, and update their statuses.
- Re-populates food sources and resets agent positions for new rounds.
- Ends the simulation when all agents have exhausted their energy.

### 5. **Map Visualization**
- The graphical interface (GUI) represents the simulation state visually.
- The `Map` class extends `JPanel` to render agents, food, and the base on a grid.
- Uses different colors to represent entities:
  - **Green**: Agents
  - **Red**: Food
  - **Blue**: Base
- The interface updates every round, visually reflecting changes in the simulation.

## Technologies Used
- **Java (Maven)** (Core logic and simulation mechanics)
- **Swing (JPanel, JFrame)** (Graphical user interface for visualization)
- **Random Library** (For random placements of agents and food sources)
- **OOP Principles** (Encapsulation, inheritance, and polymorphism for modular code design)

## How to Run the Simulation
1. Clone the repository:
   ```sh
   git clone <repository-url>
   cd <repository-folder>
   ```
2. Compile the project using Maven:
   ```sh
   mvn clean install
   ```
3. Run the simulation:
   ```sh
   mvn exec:java -Dexec.mainClass="Controller"
   ```
4. Observe the simulation in the graphical window.

## Future Enhancements
- Implementing AI learning strategies for better agent behavior.
- Adding obstacles to create a more complex environment.
- Improving the visualization with more detailed graphics.
- Introducing different agent types with varied behaviors.

