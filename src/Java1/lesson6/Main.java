package Java1.lesson6;

import Java1.lesson6.animals.Animals;
import Java1.lesson6.animals.Cat;
import Java1.lesson6.animals.Dog;
import Java1.lesson6.animals.Type;

import java.util.ArrayList;

public class Main {
//    1. Создать классы Собака и Кот с наследованием от класса Животное.
//    2. Все животные могут бежать и плыть. В качестве параметра
//            каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль.
//            (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//    3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
//             плавание: кот не умеет плавать, собака 10 м.).
//    4. * Добавить подсчет созданных котов, собак и животных.

    public static void main(String[] args) {
        ArrayList<Animals> animals = new ArrayList<>();
        animals.add(new Cat(75, 900, "Misha",Type.CAT));
        animals.add(new Dog(130, 1000, "Rizhik",Type.DOG));
        animals.add(new Dog(40, 1500, "Tuzik",Type.DOG));
        animals.add(new Cat(170, 1700, "Barsik",Type.CAT));
        animals.add(new Dog(60, 300, "Vulkan",Type.DOG));
        animals.add(new Cat(190, 1100, "Baton",Type.CAT));

        for (Animals a : animals) {
            if (a.run()){
                System.out.printf("%s по кличке %s пробежал %d метров\n",a.getType(),a.getName(),a.getDistanceRun());
            }else {
                System.out.printf("Увы! %s по кличке %s не смог пробежать %d метров\n",a.getType(),a.getName(),a.getDistanceRun());
            }
            if (a.swim()) {
                System.out.printf("%s по кличке %s проплыл %d метров\n",a.getType(),a.getName(),a.getDistanceSwim());
            }else {
                System.out.printf("Увы! %s по кличке %s не смог проплыть %d метров\n",a.getType(),a.getName(),a.getDistanceSwim());
            }
        }
    }

}