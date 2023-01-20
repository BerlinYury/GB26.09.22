package Java1.lesson7;

public class Cat {
    private final int appetite;
    private final String name;

    public Cat(int appetite, String name) {
            this.appetite = appetite;
            this.name = name;
        }

    public boolean eat(Plate plate) {
        System.out.printf("Кот %s пытается поесть %d грамм еды\n", name, appetite);
        return plate.changingFood(appetite);
    }

    public int getAppetite() {
        return appetite;
    }

    public String getName() {
        return name;
    }
}
