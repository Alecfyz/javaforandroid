package lesson8.homework;

public class Wall {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public boolean doPassTheWall(Sporting obj) {
        int curJump = obj.jump(this.height);
        if (height <= curJump) {
            System.out.printf("%nПерепрыгнул! УРА!");
            return true;
        } else {
            System.out.printf("%nНедолёт...");
            return false;
        }
    }
}
