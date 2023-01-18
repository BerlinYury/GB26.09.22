package Java1.lesson5.hw5;

public class Stuff {
    private final String fullName;
    private final String position;
    private final String email;
    private final String phone;
    private final int salary;
    private final int age;

    public Stuff(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return fullName + ": " +
                " position= " + position + ";" +
                " email= " + email + ";" +
                " phone= " + phone + ";" +
                " salary= " + salary + ";" +
                " age= " + age + ";";
    }

    public int getAge() {
        return age;
    }

}
