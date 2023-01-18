package Java1.lesson4;

import java.util.Random;
import java.util.Scanner;

public class XOgame {
    static final int SIZE = 3;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';
    static final int DOTS_TO_WIN = 3;

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn(sc);
            printMap();
            if (isFull()){
                System.out.println("Ниичья");
            }else {
                if(isWin(DOT_X, DOTS_TO_WIN)) {
                    System.out.println("Победа");
                    break;
                }
            }
            System.out.println();

            aiTurn();
            printMap();
            if (isFull()){
                System.out.println("Ничья");
            }else {
                if (isWin(DOT_O, DOTS_TO_WIN)) {
                    System.out.println("Порожение");
                    break;
                }
            }
        }
    }

    private static boolean isWin(char sym, int dotsToWin) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkWin(map, i, j, 1, 1, sym, dotsToWin) || checkWin(map, i, j, 1, 0, sym, dotsToWin) || checkWin(map, i, j, 0, 1, sym, dotsToWin) || checkWin(map, i, j, -1, 1, sym, dotsToWin)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkWin(char[][] map, int xStat, int yStat, int xDin, int yDin, char sym, int dotsToWin) {
        if (xStat + ((DOTS_TO_WIN - 1) * xDin) < map.length && yStat + ((DOTS_TO_WIN - 1) * yDin) < map.length && xStat + ((DOTS_TO_WIN - 1) * xDin) >= 0 && yStat + ((DOTS_TO_WIN - 1) * yDin) >= 0) {
            for (int i = 0; i < dotsToWin; i++) {
                if (map[xStat + i * xDin][yStat + i * yDin] != sym) {
                    return false;
                }
            }
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

    private static void aiTurn() {
        int x;
        int y;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isTrue(i, j)) {
                    map[i][j] = DOT_O;
                    if (isWin(DOT_O, DOTS_TO_WIN)) {
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
                    if (isWin(DOT_X, DOTS_TO_WIN)) {
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
                    if (isWin(DOT_O, DOTS_TO_WIN - 1)) {
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
                    if (isWin(DOT_X, DOTS_TO_WIN - 1) && random.nextInt(10)<4) {
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

    private static void humanTurn(Scanner sc) {
        int x;
        int y;
        do {
            System.out.println("Введите номер поля: ");
            x = sc.nextInt();
            y = sc.nextInt();
        } while (!isTrue(x - 1, y - 1));
        map[x - 1][y - 1] = DOT_X;
    }

    private static void printMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%3d", i + 1);
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%d", i + 1);
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%3c", map[i][j]);
            }
            System.out.println();
        }
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
}
