package Java1.lesson8;

import javax.swing.*;
import java.awt.*;

public class Setting extends JFrame {

    private JSlider slFieldSize;
    private JSlider slDotsToWin;

    public Setting(GameWindow gameWindow) throws HeadlessException {
        setBounds(450, 250, 400, 400);
        setTitle("Setting");
        int MIN_FIELD_SIZE = 3;
        int MAX_FIELD_SIZE = 10;
        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slFieldSize.setMajorTickSpacing(1);
        slFieldSize.setPaintTicks(true);
        slFieldSize.setPaintLabels(true);

        slDotsToWin = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        slDotsToWin.setMajorTickSpacing(1);
        slDotsToWin.setPaintTicks(true);
        slDotsToWin.setPaintLabels(true);

        slFieldSize.addChangeListener(e -> slDotsToWin.setMaximum(slFieldSize.getValue()));

        setLayout(new GridLayout(5, 1));

        add(new Label("FieldSize"));
        add(slFieldSize);

        add(new Label("Winning Line"));
        add(slDotsToWin);

        JButton button = new JButton("Start a game");
        add(button);

        button.addActionListener(e -> {
            int fieldSize=slFieldSize.getValue();
            int dotsToWin=slDotsToWin.getValue();

            Logic.SIZE=fieldSize;
            Logic.DOTS_TO_WIN=dotsToWin;
            Logic.initMap();

            gameWindow.startNewGame(fieldSize,dotsToWin);
            setVisible(false);
        });

        setVisible(false);
    }
}
