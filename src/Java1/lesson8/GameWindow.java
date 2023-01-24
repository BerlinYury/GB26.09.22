package Java1.lesson8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private BattleMap battleMap;
    private Setting setting;

    public GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(450, 250, 500, 500);
        setTitle("TicTacToe");

        JPanel settingPanel = new JPanel(new GridLayout());
        JButton buttonSetting = new JButton("Setting");
        settingPanel.add(buttonSetting);
        add(settingPanel, BorderLayout.NORTH);
        setting = new Setting(this);
        buttonSetting.addActionListener(e -> setting.setVisible(true));

        JPanel panel = new JPanel(new GridLayout());
        JButton buttonStartNewGame = new JButton("Start new game");
        panel.add(buttonStartNewGame);
        JButton buttonExit = new JButton("Exit");
        panel.add(buttonExit);
        add(panel, BorderLayout.SOUTH);

        buttonStartNewGame.addActionListener(e -> setting.setVisible(true));
        buttonExit.addActionListener(e -> System.exit(0));

        battleMap = new BattleMap(this);
        add(battleMap, BorderLayout.CENTER);

        setVisible(true);
    }

    void startNewGame(int fieldSize, int dotsToWin) {
        Logic.endGameWin=false;
        Logic.endGame=false;
        battleMap.startNewGame(fieldSize,dotsToWin);
    }

    void startLogic(int cellX, int cellY, BattleMap battleMap){
        Logic.go(cellX,cellY,battleMap,this);
    }
}
