package Java2.lesson2;

public class App {
    //      1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
//подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//      2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
//просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
//ячейке лежит символ или текст вместо числа), должно быть брошено исключение
//MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
//      3 В методе main() вызвать полученный метод, обработать возможные исключения
//MyArraySizeException и MyArrayDataException и вывести результат расчета (сумму элементов,
//при условии что подали на вход корректный массив).

    public static void main(String[] args) {
        String[][] str = {
                {"57", "47", "39", "84"},
                {"60", "12", "31", "43"},
                {"72", "90", "12", "44"},
                {"43", "92", "14"}
        };
        try {
            System.out.printf("Сумма всех элементов равна: %d\n",sum(strToInt(str)));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            String[][] strNew = {
                    {"57", "47", "39", "84"},
                    {"60", "12", "31", "43"},
                    {"72", "90", "12", "44"},
                    {"43", "92", "14", "52"}
            };
            System.out.printf("Сумма всех элементов равна: %d\n",sum(strToInt(strNew)));
        }catch (MyArrayDataException e){
            e.printStackTrace();
            str[e.getI()][e.getJ()]="1000";
            System.out.printf("Сумма всех элементов равна: %d\n",sum(strToInt(str)));
        }
    }

    private static int sum(int[][] ints) {
        int sum = 0;
        for (int[] anInt : ints) {
            for (int i : anInt) {
                sum += i;
            }
        }
        return sum;
    }

    private static int[][] strToInt(String[][] str) throws MyArraySizeException {
        int[][] strToInt = new int[str.length][str.length];
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length; j++) {
                if (str.length != 4 || str[i].length != 4) {
                    throw new MyArraySizeException("Длинна массива не равна 4");
                }
                try {
                    strToInt[i][j] = Integer.parseInt(str[i][j]);
                }catch (NumberFormatException e){
                   throw new MyArrayDataException("Элемент в строке "+i+" столбце "+j+" не является числом",i,j);
                }
            }
        }
        return strToInt;
    }
}
