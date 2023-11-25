public class Fish extends Thread {
    private int age;
    private Gender gender;
    private int x;
    private int y;

    private int puberty = 0; ///

    private Aquarium aquarium;

    public Fish(Aquarium aquarium) {
        this.aquarium = aquarium;
    }

    @Override
    public void run() {
        while (age > 0) {
            move();
            aquarium.checkCollision(this);

            puberty++;          ///
            age--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        aquarium.remove(this);
    }

    public void move() {
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


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public int getPuberty() {
        return puberty;
    }

    public void setPuberty(int puberty) {
        this.puberty = puberty;
    }

    @Override
    public String toString() {
        return "Fish{" +
                " name=" + getName() +
                ", age=" + age +
                ", gender=" + gender +
                ", x=" + x +
                ", y=" + y +
                ", puberty=" + puberty +
                '}';
    }
}
