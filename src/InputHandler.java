import javax.swing.Action;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class InputHandler {

    public void handleInput(GamePanel gamePanel) {
        // Move up
        bindKeyWithAction(gamePanel, KeyEvent.VK_UP, "move up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.setDirection(0, -1);
            }
        });

        // Move down
        bindKeyWithAction(gamePanel, KeyEvent.VK_DOWN, "move down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.setDirection(0, 1);
            }
        });

        // Move left
        bindKeyWithAction(gamePanel, KeyEvent.VK_LEFT, "move left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.setDirection(-1, 0);
            }
        });

        // Move right
        bindKeyWithAction(gamePanel, KeyEvent.VK_RIGHT, "move right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.setDirection(1, 0);
            }
        });
    }

    private void bindKeyWithAction(GamePanel gamePanel, int keyCode, String id, Action action) {
        KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, 0);
        gamePanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, id);
        gamePanel.getActionMap().put(id, action);
    }
}