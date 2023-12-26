import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLoop {

    private Timer timer;

    public GameLoop(GamePanel gamePanel) {
        this.timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.move();
                gamePanel.repaint();
            }
        });
    }

    public void start() {
        timer.start();
    }
    
}