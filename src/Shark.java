public class Shark extends Thread {
    private int age;
    public int x;
    public int y;
    private Aquarium aquarium;

    public Shark(Aquarium aquarium) {
        this.aquarium = aquarium;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void run() {
        while (age > 0) {
            sharkStep();
            aquarium.checkShark(this);
            try {
                Thread.sleep(1000);
                age--;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("RIP SHARK!!");

    }

    private void sharkStep() {
        int n = RandomUtil.getRandom(4);
        switch (n) {
            case 1 -> {
                if (y < Aquarium.y) {
                    y++;
                }
            }
            case 2 -> {
                if (x < Aquarium.x) {
                    x++;
                }
            }
            case 3 -> {
                if (y > 0) {
                    y--;
                }
            }
            case 4 -> {
                if (x > 0) {
                    x--;
                }
            }
        }

    }

    @Override
    public String toString() {
        return "Shark{" +
                "age=" + age +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
