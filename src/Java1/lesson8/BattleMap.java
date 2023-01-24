package Java1.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    private GameWindow gameWindow;
    private int fieldSize;
    private int dotsToWin;
    private int cellWith;
    private int cellHeight;
    private boolean isInit = false;

    int yS;
    int xS;
    int yD;
    int xD;

    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.GRAY);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (!Logic.endGame && isInit) {
                    int cellY = e.getX() / cellWith;
                    int cellX = e.getY() / cellHeight;
                    startLogic(cellX, cellY);
                }
                repaint();
            }
        });
    }

    private void startLogic(int cellX, int cellY) {
        gameWindow.startLogic(cellX, cellY, this);
    }

    void startNewGame(int fieldSize, int dotsToWin) {
        this.fieldSize = fieldSize;
        this.dotsToWin = dotsToWin;
        isInit = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;
        }
        int panelWith = getWidth();
        int panelHeight = getHeight();

        cellWith = panelWith / fieldSize;
        cellHeight = panelHeight / fieldSize;

        g.setColor(Color.black);
        ((Graphics2D) g).setStroke(new BasicStroke(3f));

        gridPaint(g,panelWith,panelHeight);

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    xPaint(g, i, j);
                }
                if (Logic.map[i][j] == Logic.DOT_O) {
                    oPaint(g, i, j);
                }
            }
        }
        if (Logic.endGameWin) {
            winLinePaining(g, yS, xS, yD, xD);
        }
    }

    void info(int yS, int xS, int yD, int xD) {
        this.yS = yS;
        this.xS = xS;
        this.yD = yD;
        this.xD = xD;
    }

    private void gridPaint(Graphics g, int panelWith, int panelHeight){
        for (int i = 1; i < fieldSize; i++) {
            int x = cellWith * i;
            int y = cellHeight * i;
            g.drawLine(x, 0, x, panelHeight);
            g.drawLine(0, y, panelWith, y);
        }
    }

    private void oPaint(Graphics g, int i, int j) {
        g.drawOval(cellWith * j, cellHeight * i, cellWith, cellHeight);
    }

    private void xPaint(Graphics g, int i, int j) {
        g.drawLine(cellWith * j, cellHeight * i, cellWith * (j + 1), cellHeight * (i + 1));
        g.drawLine(cellWith * (j + 1), cellHeight * i, cellWith * j, cellHeight * (i + 1));
    }

    void winLinePaining(Graphics g, int yS, int xS, int yD, int xD) {
        g.setColor(Color.red);
        ((Graphics2D) g).setStroke(new BasicStroke(5f));
        int dopWith;
        int dopHeight;
        int x1;
        int y1;
        int x2;
        int y2;
        for (int i = 0; i < dotsToWin; i++) {
            if (xD == 1 && yD == 1) {
                dopWith = 0;
                dopHeight = 0;
            } else if (xD == 1 && yD == -1) {
                dopWith = 0;
                dopHeight = cellHeight;
            } else {
                dopWith = cellWith / 2 * yD;
                dopHeight = cellHeight / 2 * xD;
            }
            x1 = cellWith * xS + cellWith * xD * i + dopWith;
            y1 = cellHeight * yS + cellHeight * yD * i + dopHeight;
            x2 = cellWith * xS + cellWith * xD * (i + 1) + dopWith;
            y2 = cellHeight * yS + cellHeight * yD * (i + 1) + dopHeight;

            g.drawLine(x1, y1, x2, y2);
        }
    }
}
