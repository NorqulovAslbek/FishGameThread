public class FishFactory {
    private static final int ageMax = 20;

    public static Fish getFish(Aquarium aquarium) {
        Fish fish = new Fish(aquarium);
        fish.setAge(RandomUtil.getRandom(ageMax));
        fish.setGender(RandomUtil.getBoolean() ? Gender.MALE : Gender.FEMALE);
        fish.setX(RandomUtil.getRandom(Aquarium.x));
        fish.setY(RandomUtil.getRandom(Aquarium.y));
        return fish;
    }


}
