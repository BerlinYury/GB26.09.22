package Java1.lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
            this.food = food;
        }

    boolean changingFood(int chn) {
        if (chn <= food) {
            food -= chn;
            return true;
        } else {
            return false;
        }
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
}
