package lesson8.homework;

public class Cat implements Sporting {
    private String name;
    private int maxRunLenght; // default cat=20, human=30, robot=40
    private int maxJumpHeight; // default cat=1, h=2, r=3
    private boolean disqualified = false;

    public Cat(String name, int maxRunLenght, int maxJumpHeight) {
        this.name = name;
        this.maxRunLenght = maxRunLenght;
        this.maxJumpHeight = maxJumpHeight;
    }

    public Cat(String name) {
        this(name, 20, 1);
    }


    public String getName() {
        return name;
    }

    public int getMaxRunLenght() {
        return maxRunLenght;
    }


    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }


    @Override
    public int run(int trackW) {
        System.out.printf("Кот по имени %s бежит по треку длиной %dм и пробегает %dм.", this.getName(), trackW, this.maxRunLenght);
        return maxRunLenght;
    }


    @Override
    public int jump(int wallH) {
        System.out.printf("Кот по имени %s прыгает на %dм через стену высотой %dм.", this.getName(), this.maxJumpHeight, wallH);
//        System.out.println(getName());
        return maxJumpHeight;
    }

    public void disq() {
        this.disqualified = true;
    }

    @Override
    public boolean isdisqalified() {
        return this.disqualified;
    }

    public String getnam() {
        return name;
    }

}
