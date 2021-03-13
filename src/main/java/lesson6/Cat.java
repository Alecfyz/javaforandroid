package lesson6;

public class Cat extends Animal{
    protected static int catsCount;


    public Cat(String name, String color, int age) {
        super(name, color, age);
        this.canSweem = false;
        this.canRun = true;
        this.maxRunLenght = 200;
        this.animClass = "Cat";
        catsCount++;
    }

    public Cat(String name) {
        this(name, "", 1);
    }

    @Override
    public void voice() {
        System.out.println("Frrr-frrr");
//        super.voice();
    }


    public int getCatsCount() {
        return catsCount;
    }
}
