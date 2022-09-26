package Java1.lesson1.hw1;

public class App {

    public static void main(String[] args) {
            printThreeWords();
            checkSumSign();
            printColor();
            compareNumbers();
        }

        private static void compareNumbers() {
            int a = 23;
            int b = 24;

            if (a >= b) {
                System.out.println("a>=b");
            } else {
                System.out.println("a<b");
            }
        }

        private static void printColor() {
            int c = -145;

            if (c <= 0) {
                System.out.println("Красный");
            } else if (c > 0 && c <= 100) {
                System.out.println("Желтый");
            } else {
                System.out.println("Зеленый");
            }
        }

        private static void checkSumSign() {
            int a = 10;
            int b = 20;

            if (a + b >= 0) {
                System.out.println("Сумма положительная");
            } else {
                System.out.println("Сумма отрицательная");
            }
        }

        private static void printThreeWords() {
            System.out.println("_Orange");
            System.out.println("_Banana");
            System.out.println("_Apple");
        }
    }



