package Java1.lesson8;

import java.util.Random;

public class Logic {
    static int SIZE;
    static int DOTS_TO_WIN;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';
    static char[][] map;
    static Random random = new Random();
    static boolean endGame = false;
    static boolean endGameWin = false;

    public static void go(int x, int y, BattleMap battleMap, GameWindow gameWindow) {

        humanTurn(x, y);
        if (isFull()) {
            EndGameWindow endGameWindow = new EndGameWindow("Draw", gameWindow);
            endGameWindow.setVisible(true);
            endGame = true;
            return;
        } else {
            if (isWin(DOT_X, DOTS_TO_WIN, battleMap)) {
                EndGameWindow endGameWindow = new EndGameWindow("You Win", gameWindow);
                endGameWindow.setVisible(true);
                endGame = true;
                endGameWin = true;
                return;
            }
        }
        System.out.println();

        aiTurn(battleMap);
        if (isFull()) {
            EndGameWindow endGameWindow = new EndGameWindow("Draw", gameWindow);
            endGameWindow.setVisible(true);
            endGame = true;
            return;
        } else {
            if (isWin(DOT_O, DOTS_TO_WIN, battleMap)) {
                EndGameWindow endGameWindow = new EndGameWindow("You Loose", gameWindow);
                endGameWindow.setVisible(true);
                endGame = true;
                endGameWin = true;
                return;
            }
        }
    }

    private static boolean isWin(char sym, int dotsToWin, BattleMap battleMap) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkWin(map, i, j, 1, 1, sym, dotsToWin, battleMap)
                        || checkWin(map, i, j, 1, 0, sym, dotsToWin, battleMap)
                        || checkWin(map, i, j, 0, 1, sym, dotsToWin, battleMap)
                        || checkWin(map, i, j, -1, 1, sym, dotsToWin, battleMap)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkWin(char[][] map, int xStat, int yStat, int xDin, int yDin, char sym, int dotsToWin, BattleMap battleMap) {
        if (xStat + ((DOTS_TO_WIN - 1) * xDin) < map.length && yStat + ((DOTS_TO_WIN - 1) * yDin) < map.length && xStat + ((DOTS_TO_WIN - 1) * xDin) >= 0 && yStat + ((DOTS_TO_WIN - 1) * yDin) >= 0) {
            for (int i = 0; i < dotsToWin; i++) {
                if (map[xStat + i * xDin][yStat + i * yDin] != sym) {
                    return false;
                }
            }
          battleMap.info(xStat, yStat, xDin, yDin);
            return true;
        } else {
            return false;
        }
    }
    private static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void aiTurn(BattleMap battleMap) {
        int x;
        int y;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isTrue(i, j)) {
                    map[i][j] = DOT_O;
                    if (isWin(DOT_O, DOTS_TO_WIN, battleMap)) {
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isTrue(i, j)) {
                    map[i][j] = DOT_X;
                    if (isWin(DOT_X, DOTS_TO_WIN, battleMap)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isTrue(i, j)) {
                    map[i][j] = DOT_O;
                    if (isWin(DOT_O, DOTS_TO_WIN - 1, battleMap)) {
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isTrue(i, j)) {
                    map[i][j] = DOT_X;
                    if (isWin(DOT_X, DOTS_TO_WIN - 1, battleMap) && random.nextInt(10) < 4) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isTrue(x, y));
        map[x][y] = DOT_O;
    }

    private static boolean isTrue(int xT, int yT) {
        if (xT < 0 || xT >= SIZE || yT < 0 || yT >= SIZE) {
            return false;
        } else return map[xT][yT] == DOT_EMPTY;
    }

    static void humanTurn(int x, int y) {
        if (isTrue(x, y)) {
            map[x][y] = DOT_X;
        }
    }

    static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
}
