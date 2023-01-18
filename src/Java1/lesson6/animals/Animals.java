package Java1.lesson6.animals;

public class Animals {
    private final int distanceSwim = 130;
    private final int distanceRun = 850;
    private final int limitDistanceSwim;
    private final int limitDistanceRun;
    private final Type type;
    private final String name;

    public Animals(int limitDistanceSwim, int limitDistanceRun, String name, Type type) {
        this.limitDistanceSwim = limitDistanceSwim;
        this.limitDistanceRun = limitDistanceRun;
        this.type = type;
        this.name = name;
    }

    public boolean swim() {
        if (limitDistanceSwim >= distanceSwim) {
            return true;
        }
        return false;
    }

    public boolean run() {
        if (limitDistanceRun >= distanceRun) {
            return true;
        }
        return false;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getDistanceSwim() {
        return distanceSwim;
    }

    public int getDistanceRun() {
        return distanceRun;
    }

}
