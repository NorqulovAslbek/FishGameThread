import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();

    public static int getRandom(int n) {
        return random.nextInt(n) + 1; // [0,,,,n-1] + 1  -> [1......n]
    }

    public static boolean getBoolean() {
        return random.nextBoolean();
    }
}
