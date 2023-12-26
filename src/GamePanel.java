import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class GamePanel extends JPanel {

    List<Point> snakeBody = new ArrayList<>();
    
    Random random = new Random();

    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 600;
    private static final int CELL_SIZE = 40;

    private int snakeX = GAME_WIDTH / (2 * CELL_SIZE);
    private int snakeY = GAME_HEIGHT / (2 * CELL_SIZE);

    private int directionX = 0;
    private int directionY = 0;

    private int foodX = 200;
    private int foodY = 200;

    public GamePanel() {
        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        snakeBody.add(new Point(snakeX, snakeY));
    }

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Center the game to window
    int x = (getWidth() - GAME_WIDTH) / 2;
    int y = (getHeight() - GAME_HEIGHT) / 2;

    // Draw the background
    g.setColor(Color.BLACK);
    g.fillRect(x, y, GAME_WIDTH, GAME_HEIGHT);

    // Draw the grid
    g.setColor(Color.DARK_GRAY);
    for (int i = 0; i < GAME_WIDTH; i += CELL_SIZE) {
        for (int j = 0; j < GAME_HEIGHT; j += CELL_SIZE) {
            g.drawRect(x + i, y + j, CELL_SIZE, CELL_SIZE);
        }
    }

    // Draw the snake
    for (Point point : snakeBody) {
        g.setColor(Color.GREEN);
        g.fillRect(x + point.x * CELL_SIZE, y + point.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }

    // Draw the food
    g.setColor(Color.RED);
    g.fillRect(x + foodX, y + foodY, CELL_SIZE, CELL_SIZE);
}

    public void setDirection(int directionX, int directionY) {
        this.directionX = directionX;
        this.directionY = directionY;
    }

    public void move() {
        // Update the position of the snake
        int newSnakeX = snakeX + directionX * CELL_SIZE;
        int newSnakeY = snakeY + directionY * CELL_SIZE;    

        // Check if the snake collides with itself
        // ...

        List<Point> snakeBody = new ArrayList<>();

        for (Point point : snakeBody) {
            if (point.x == newSnakeX && point.y == newSnakeY) {
                // End the game
                System.out.println("Game Over! The snake collided with itself.");
                System.exit(0);
            }
        }

        // Check if the snake collides with the wall
        if (newSnakeX < 0 || newSnakeX >= GAME_WIDTH || newSnakeY < 0 || newSnakeY >= GAME_HEIGHT) {
            // End the game
            System.out.println("Game Over! The snake collided with the wall.");
            System.exit(0);
        }

        // Move the snake
        boolean ateFood = false; // Declare and initialize the variable ateFood

        snakeX = newSnakeX;
        snakeY = newSnakeY;

        // Add the new position to the front of the snake's body
        snakeBody.add(0, new Point(snakeX, snakeY));

        // Check if the snake ate the food
        if (snakeX == foodX && snakeY == foodY) {
            ateFood = true;

            // Place the food at a new random location
            foodX = random.nextInt(GAME_WIDTH / CELL_SIZE) * CELL_SIZE;
            foodY = random.nextInt(GAME_HEIGHT / CELL_SIZE) * CELL_SIZE;
        } else {
            ateFood = false;
        }

    }

}