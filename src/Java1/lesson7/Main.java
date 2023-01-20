package Java1.lesson7;

//      1. Расширить задачу про котов и тарелки с едой.
//      2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды,
// а кот пытается покушать 15-20).
//      3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
// Если коту удалось покушать (хватило еды), сытость = true.
//      4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
// то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
//      5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию
// о сытости котов в консоль.
//      6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int foodInPlate;

        do {
            System.out.println("Введите количество еды в тарелке");
            foodInPlate = in.nextInt();
        } while (foodInPlate <= 0);

        Plate plate = new Plate(foodInPlate);

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat(random.nextInt(30), "Barsik"));
        cats.add(new Cat(random.nextInt(30), "Rusik"));
        cats.add(new Cat(random.nextInt(30), "Tolstyak"));
        cats.add(new Cat(random.nextInt(30), "Baton"));
        cats.add(new Cat(random.nextInt(30), "Garfild"));
        cats.add(new Cat(random.nextInt(30), "Shekel"));

        for (int i = 0; i < cats.size(); i++) {
            if (cats.get(i).getAppetite() <= 0) {
                System.out.printf("Кот %s не голоден\n", cats.get(i).getName());
            } else {
                if (cats.get(i).eat(plate)) {
                    System.out.printf("Кот %s поел! =)\n", cats.get(i).getName());
                    System.out.printf("В тарелке осталось %d грамм еды\n", plate.getFood());
                } else {
                    System.out.printf("Кот %s не смог поесть, так как\n", cats.get(i).getName());
                    System.out.printf("в тарелке осталось только %d грамм еды\n", plate.getFood());
                    addFood(plate, in);
                    i--;
                }
            }
        }

    }

    private static void addFood(Plate plate, Scanner in) {
        int addFood;
        do {
            System.out.println("Положите добавку еды");
            addFood = in.nextInt();
        } while (addFood <= 0);
        plate.setFood(plate.getFood() + addFood);
    }
}
