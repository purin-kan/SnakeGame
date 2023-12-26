import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        setupWindow();

    }

    private static void setupWindow() {
        GamePanel gamePanel = new GamePanel();
        
        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gamePanel);
        frame.pack();
        frame.setVisible(true);

        GameLoop gameLoop = new GameLoop(gamePanel);
        gameLoop.start();
    }
}
