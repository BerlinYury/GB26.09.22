package Java2.lesson1.l2;

public class Participants implements Runnable, Jumping {
    private final String name;
    private final int runLimit;
    private final float jumpLimit;

    public Participants(String name, int runLimit, float jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean run(Treadmill treadmill, int distance, Participants participants) {
        if (distance <= runLimit) {
            System.out.printf("%s %s успешно преодалел %s длинной %d метров\n", participants.getClass().getSimpleName(), name, treadmill.getClass().getSimpleName(), distance);
            return true;
        } else {
            System.out.printf("%s %s не смог преодалеть %s длинной %d метров\n", participants.getClass().getSimpleName(), name, treadmill.getClass().getSimpleName(), distance);
            return false;
        }
    }

    @Override
    public boolean jump(Wall wall, float height, Participants participants) {
        if (height <= jumpLimit) {
            System.out.printf("%s %s успешно преодалел %s высотой %.1f метра\n", participants.getClass().getSimpleName(), name, wall.getClass().getSimpleName(), height);
            return true;
        } else {
            System.out.printf("%s %s не смог преодалеть %s высотой %.1f метра\n", participants.getClass().getSimpleName(), name, wall.getClass().getSimpleName(), height);
            return false;
        }
    }
}
