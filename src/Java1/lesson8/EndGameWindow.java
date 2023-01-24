package Java1.lesson8;

import javax.swing.*;
import java.awt.*;

public class EndGameWindow extends JFrame {
    private Setting setting;

    public EndGameWindow(String res, GameWindow gameWindow) throws HeadlessException {
        setBounds(450, 250, 200, 150);
        setTitle("End game");
        Label label = new Label(res);
        label.setFont(new Font("Serif", Font.PLAIN, 22));
        add(label);
        JPanel panel = new JPanel(new GridLayout());
        JButton buttonStartNewGame = new JButton("Start new game");
        panel.add(buttonStartNewGame);
        add(panel, BorderLayout.SOUTH);
        setting = new Setting(gameWindow);
        buttonStartNewGame.addActionListener(e -> {
            setVisible(false);
            setting.setVisible(true);
        });
        setVisible(false);


    }
}
