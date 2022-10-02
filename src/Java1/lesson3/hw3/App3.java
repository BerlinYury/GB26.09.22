package Java1.lesson3.hw3;

import java.util.Arrays;

public class App3 {
    /*
    * 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    *  С помощью цикла и условия заменить 0 на 1, 1 на 0;
    *
    2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
*
    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
*
    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
*  заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
* Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
*  то есть [0][0], [1][1], [2][2], …, [n][n];
*
    5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный
*  массив типа int длиной len, каждая ячейка которого равна initialValue;
*
    6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
    *
    7. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
*  метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
**Примеры:
checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
checkBalance([1, 14, 1, ||| 2, 1, 6, 7]) → true, т.е. 1 + 14 + 1 = 2 + 1 + 6 + 7
граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.

    8. *** Написать метод, которому на вход подается одномерный массив и число n
* (может быть положительным, или отрицательным), при этом метод должен сместить
* все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения
*  задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо)
*  -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону
* сдвиг можете выбирать сами.
Если выполнение задач вызывает трудности, можете обратиться к последней странице методического пособия.
* Для задач со * не нужно искать решение в интернете, иначе нет смысла их выполнять.*/

    public static void main(String[] args) {

        int[] a = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(method1(a)));

        int[] a2 = new int[100];
        System.out.println(Arrays.toString(method2(a2)));

        int[] a3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(method3(a3)));

        int n = 5;
        int[][] a4 = {{n}, {n}};
        method4Print(method4(a4, n), n);

        int len = 6;
        int initialValue = 25;
        int[] a5 = new int[len];
        System.out.println(Arrays.toString(method5(a5, len, initialValue)));

        int[] a6={5, 3, 2, 11, 4, 25, 27, 4, 8, 9};
        System.out.println(method6Max(a6));
        System.out.println(method6Min(a6));

        int[] a7 = {5, 3, 2, 11, 4, 25, 27, 4, 8, 9, 2};
        method7Summ(a7);
        System.out.println(method7(method7Summ(a7), a7));

        int[] a8 = {5, 3, 2, 11, 4, 25, 27, 4, 8, 9, 2};
        int m = -2;
        System.out.println(Arrays.toString(method8(m, a8)));

    }

    private static int[] method8(int m, int[] a8) {
        if (m<0){
            m= a8.length-(m*-1);
        }
        for (int i = 0; i <m; i++) {
            int x=a8[a8.length-1];
            for (int j = a8.length-1; j >0; j--) {
                a8[j] = a8[j-1];
            }
            a8[0]=x;
        }
        return a8;
    }

    private static int method7Summ( int[] a7) {
        int summ = a7[0];
        for (int i = 0; i < a7.length -1; i++) {
            summ += a7[i + 1];
        }
        return summ;
    }

    private static boolean method7(int n, int[] a7) {
        if (n%2!=0){
            return false;
        }
        int summ = a7[0];
        for (int i = 0; i < a7.length-1; i++) {
            summ += a7[i + 1];
            if (summ==n/2){
                return true;
            }
        }
        return false;
    }


    private static int method6Min(int[] a6) {
        int min = a6[0];
        for (int i = 0; i < a6.length; i++) {
            min = min < a6[i] ? min : a6[i];
        }
        return min;
    }

    private static int method6Max(int[] a6) {
        int max = a6[0];
        for (int i = 0; i < a6.length; i++) {
            max = max > a6[i] ? max : a6[i];
        }
        return max;
    }


    private static int[] method5(int[] a5, int len, int initialValue) {
        for (int i = 0; i < len; i++) {
            a5[i] = initialValue;
        }
        return a5;
    }

    private static void method4Print(char[][] b4, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3c", b4[i][j]);
            }
            System.out.println();
        }
    }

    private static char[][] method4(int[][] a4, int n) {
        char[][] b4 = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b4[i][j] = i == j || j == n - 1 - i ? 'x' : '.';
            }
        }
        return b4;
    }

    private static int[] method3(int[] a3) {
        int[] b3 = new int[a3.length];
        for (int i = 0; i < a3.length; i++) {
            b3[i] = a3[i] < 6 ? a3[i] * 2 : a3[i];
        }
        return b3;
    }

    private static int[] method2(int[] a2) {
        for (int i = 0; i < 100; i++) {
            a2[i] = i + 1;
        }
        return a2;
    }

    private static int[] method1(int[] a) {
        int b[] = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            b[i] = (a[i] == 0) ? 1 : 0;
        }
        return b;
    }
}
