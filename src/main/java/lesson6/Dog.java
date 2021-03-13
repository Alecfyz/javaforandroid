package lesson6;

public class Dog extends Animal{
    protected boolean isBark;

    protected static int dogsCount;

    public Dog(String name, String color, int age, boolean isBark) {
        super(name, color, age);
        this.isBark = isBark;
        this.name = "Эй, " + name;
        this.canSweem = true;
        this.canRun = true;
        this.maxRunLenght = 500;
        this.maxSweemLenght = 10;
        this.animClass = "Dog";
        dogsCount++;
    }

    public Dog(String name) {
        this(name, "darkblue", 1, true);
    }

    @Override
    public void voice() {
        System.out.println("Gauuu-Gauuu");
    }

    @Override
    public String toString() {
        return super.toString() + ", isBark=" + isBark + ", как звать: '" + this.name + "' и '" + super.name + "'";
    }

    public int getDogsCount() {
        return dogsCount;
    }
}
