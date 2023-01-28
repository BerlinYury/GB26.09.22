package Java2.lesson1.l2;

import java.util.ArrayList;

public class App {
    private static int START_DISTANCE = 100;
    private static float START_HEIGHT = 0.5f;
    private static int round = 1;

    public static void main(String[] args) {
        ArrayList<Trails> trails = new ArrayList<>();
        trails.add(new Treadmill(START_DISTANCE));
        trails.add(new Wall(START_HEIGHT));

        ArrayList<Participants> participants = new ArrayList<>();
        participants.add(new Robot("Rob", 1050, 3.2f));
        participants.add(new Cat("Barsik", 751, 2.1f));
        participants.add(new Human("Lisa", 750, 2.5f));
        participants.add(new Cat("Chernish", 450, 3.3f));
        participants.add(new Robot("r579", 790, 0f));
        participants.add(new Cat("l679", 1200, 4.3f));
        participants.add(new Robot("t789", 1050, 3.7f));
        participants.add(new Human("Gari", 1150, 3.5f));
        participants.add(new Cat("Misha", 1000, 3.6f));
        participants.add(new Robot("e555", 950, 2.1f));
        participants.add(new Human("Oleg", 700, 3.4f));
        participants.add(new Human("Vika", 1250, 4.1f));

        while (participants.size() > 1) {
            System.out.printf("\nРаунд: %d\n\n", round);
            removingThoseWhoCouldNot(trails, participants);
            if (participants.size() == 1) {
                System.out.printf("\nПобедитель соревнований: %s %s\n", participants.get(0).getClass().getSimpleName(), participants.get(0).getName());
            } else if (participants.size() == 0) {
                System.out.println("\nПобедителей нет\n");
            } else {
                increasingTheDifficultyOfObstacles(trails);
            }
        }
    }

    private static void removingThoseWhoCouldNot(ArrayList<Trails> trails, ArrayList<Participants> participants) {
        for (Trails trail : trails) {
            for (int i = 0; i < participants.size(); i++) {
                if (!trail.overcomingObstacles(participants.get(i))) {
                    participants.remove(participants.get(i));
                    i--;
                }
            }
        }
    }

    private static void increasingTheDifficultyOfObstacles(ArrayList<Trails> trails) {
        START_DISTANCE += Math.random() * 300;
        START_HEIGHT += Math.random();
        trails.set(0, new Treadmill(START_DISTANCE));
        trails.set(1, new Wall(START_HEIGHT));
        round++;
    }
}

