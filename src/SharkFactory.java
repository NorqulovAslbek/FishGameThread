public class SharkFactory {
    private static final int ageMax = 30;


    public static Shark getShark(Aquarium aquarium) {
        Shark shark = new Shark(aquarium);
        shark.setAge(RandomUtil.getRandom(ageMax));
        shark.setX(RandomUtil.getRandom(Aquarium.x));
        shark.setY(RandomUtil.getRandom(Aquarium.y));
        return shark;
    }


}
