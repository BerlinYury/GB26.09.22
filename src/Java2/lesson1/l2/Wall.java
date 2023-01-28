package Java2.lesson1.l2;

public class Wall implements Trails {
    private final float height;

    public Wall(float height) {
        this.height = height;
    }

    @Override
    public boolean overcomingObstacles(Participants participants) {
        return participants.jump(this, height, participants);
    }
}
