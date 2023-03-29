package Java2.lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App2 {
    public final Object monitor = new Object();
    List<Integer> data = new ArrayList<>(10);

    public static void main(String[] args) {
        try {
            doWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("the end");
    }

    private static void doWork() throws InterruptedException {
        final int ROUND = 4;
        final App2 app = new App2();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < ROUND; i++) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                app.prepareData(app.data);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < ROUND; i++) {
                    app.sendData(app.data);
            }
        });
        thread2.setDaemon(true);
        thread1.setName("one");
        thread2.setName("two");
        thread1.start();
        thread2.start();
        thread1.join();
    }

    private void prepareData(List<Integer> data) {
        synchronized (monitor) {
            System.out.printf("поток %s готовит данные\n", Thread.currentThread().getName());
            Random random = new Random();
            for (int j = 0; j < 10; j++) {
                data.add(random.nextInt(10));
            }
            monitor.notify();
            try {
                System.out.printf("поток %s замирает\n", Thread.currentThread().getName());
                monitor.wait();
                System.out.printf("поток %s ожил\n", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendData(List<Integer> data) {
        synchronized (monitor) {
//                        try {
//                System.out.printf("поток %s замирает\n", Thread.currentThread().getName());
//                monitor.wait();
//                System.out.printf("поток %s ожил\n", Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.printf("поток %s отправляет данные\n", Thread.currentThread().getName());
            for (Integer d : data) {
                System.out.printf("%d ", d);
            }
            System.out.println();
            data.clear();
            monitor.notify();
            try {
                System.out.printf("поток %s замирает\n", Thread.currentThread().getName());
                monitor.wait();
                System.out.printf("поток %s ожил\n", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
