package Java2.lesson6;

import java.util.Arrays;

public class App {
    private static final int size = 10000000;
    private static final int h = size / 2;
    private static final float[] arr = new float[size];

    public static void main(String[] args) {
        fullArr();
        long start = System.currentTimeMillis();
        form1();
        long middle = System.currentTimeMillis();
        form2();
        long finish = System.currentTimeMillis();

        System.out.printf(
                "Время выполнения первого метода: %d\n" +
                        "Время выполнения второго метода: %d\n"
                , middle - start, finish - middle);
    }

    private static void form2() {
        float[] arr3 = Arrays.copyOfRange(arr, 0, h);
        float[] arr4 = Arrays.copyOfRange(arr, h, arr.length);
        float[] arrFin = new float[size];

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                arr3[i] = (float) (arr3[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                arr4[i] = (float) (arr4[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arr3, 0, arrFin, 0, h);
        System.arraycopy(arr4, 0, arrFin, h, h);
    }

    private static void form1() {
        float[] arr1 = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void fullArr() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
    }
}
