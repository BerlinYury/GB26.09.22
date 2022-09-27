package Java1.lesson2.hw2;

public class App2 {
    public static void main(String[] args) {

        System.out.println(method1(2, 9));

        if (method2(-2) == true) {
            System.out.println("положительное");
        } else {
            System.out.println("отрицательное");
        }

        System.out.println(method3(-5));

        mehod4("hello world", 8);

        System.out.println(method5(1000));
    }

    private static boolean method5(int i) {
        return (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) ? true : false;
    }

    private static void mehod4(String a, int i) {
        for (int j = 0; j < i; j++) {
            System.out.println(a);
        }
    }


    private static boolean method3(int i) {
        return i < 0 ? true : false;
    }

    private static boolean method2(int i) {
        return i < 0 ? false : true;
    }

    private static boolean method1(int a, int b) {
        return a + b > 10 && a + b <= 20 ? true : false;
    }

}
