package Java2.lesson1.l2;

public class Treadmill implements Trails {
    private final int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean overcomingObstacles(Participants participants) {
        return participants.run(this, distance, participants);
    }
}
