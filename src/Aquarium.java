import java.util.*;

public class Aquarium {
    public static final int x = 5;
    public static final int y = 5;
    public static final int totalArea = (x + 1) * (y + 1);
    public static final int fishInitialBound = 15;
    private List<Fish> fishList;

    public void start() {
        fishList = new Vector<>();
        int fishNumber = RandomUtil.getRandom(fishInitialBound);
        for (int i = 0; i < fishNumber; i++) {
            Fish fish = FishFactory.getFish(this);
            fishList.add(fish);
        }
        ListIterator<Fish> listIterator = fishList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next().start();
        }
        Shark shark=SharkFactory.getShark(this);
        shark.start();
        System.out.println(fishList.size());
    }

    public synchronized void checkCollision(Fish fish) {
        if (fishList.size() >= totalArea) {
            System.out.println("--------- No space");
            return;
        }
        ListIterator<Fish> listIterator = fishList.listIterator();
        while (listIterator.hasNext()) {
            Fish f = listIterator.next();
            if (f.getX() == fish.getX() && f.getY() == fish.getY() && !f.getGender().equals(fish.getGender()) && f.getPuberty() >= 3) {
                Fish bornFish = FishFactory.getFish(this);
                System.out.println("---------- New Fish " + bornFish);
                bornFish.start();
                listIterator.add(bornFish);
                printStatistics();
            }
        }
    }

    public synchronized void checkShark(Shark shark) {
        ListIterator<Fish> listIterator = fishList.listIterator();
        while (listIterator.hasNext()) {
            Fish f = listIterator.next();
            if (f.getX() == shark.x && f.getY() == shark.y) {
                System.out.println("Akula ni yedi  --------------  " + f);
                shark.setAge(shark.getAge() + f.getAge());
                System.out.println("Akula :" + shark);
                listIterator.remove();
                f.setAge(0);
            }
        }

    }

    public synchronized void remove(Fish fish) {
        ListIterator<Fish> listIterator = fishList.listIterator();
        while (listIterator.hasNext()) {
            Fish f = listIterator.next();
            if (f.getName().equals(fish.getName())) {
                System.out.println("---------- RIP " + fish);
                listIterator.remove();
                break;
            }
        }
    }

    public void printStatistics() {
        int male = 0, female = 0;
        for (Fish f : fishList) {
            if (f.getGender().equals(Gender.MALE)) {
                male++;
            } else {
                female++;
            }
        }
        System.out.println("--------- Statistics ");
        System.out.println("-- Total: " + (male + female));
        System.out.println("-- Male: " + male);
        System.out.println("-- Female: " + female);
    }
}
